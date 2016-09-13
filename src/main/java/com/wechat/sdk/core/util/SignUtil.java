/**
 * Copyright (c) 2011-2015, Mobangjack 莫帮杰 (mobangjack@foxmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wechat.sdk.core.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Generate signature and check to shake hands with WeChat server.
 * @author 帮杰
 *
 */
public class SignUtil {
	
	/**
	 * 生成签名
	 * @param token
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static String generateSignature(String token,String timestamp,String nonce) {
		if (token==null||timestamp==null||nonce==null) {
			return null;
		}
        String[] arr = new String[]{token, timestamp, nonce};
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            content.append(arr[i]);
        }
        String signature = null;
        try {
        	MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(content.toString().getBytes());
            signature = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return signature;
	}
	
    /**
     * 验证签名
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkSignature(String token,String signature, String timestamp, String nonce){
    	if (token==null||signature==null||timestamp==null||nonce==null) {
			return false;
		}
        String sign = generateSignature(token, timestamp, nonce);
        return sign==null?false:sign.equalsIgnoreCase(signature);
    }
    
    /**
     * 将字节数组转换为十六进制字符串
     * @param digest
     * @return
     */
    private static String byteToStr(byte[] digest) {
        String strDigest = "";
        for(int i = 0; i < digest.length; i++){
            strDigest += byteToHexStr(digest[i]);
        }
        return strDigest;
    }
    
    /**
     * 将字节转换为十六进制字符串
     * @param b
     * @return
     */
    private static String byteToHexStr(byte b) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(b >>> 4) & 0X0F];
        tempArr[1] = Digit[b & 0X0F];
        String s = new String(tempArr);
        return s;
    }
}