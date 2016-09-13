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
package com.wechat.sdk.core.util.encrypt;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.wechat.sdk.core.Config;


/**
 * message encrypt/decrypt tool
 * @author 帮杰
 *
 */
public class EncryptUtil {
	
	public static String encryptMsg(Config config,String msg, String timestamp, String nonce) {
		return encryptMsg(config.getToken(), config.getEncodingAesKey(), config.getAppId(), msg, timestamp, nonce);
	}
	
	public static String encryptMsg(String token,String encodingAesKey,String appId,String msg, String timestamp, String nonce) {
		try {
			WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
			return pc.encryptMsg(msg, timestamp, nonce);
		} catch (AesException e) {
			e.printStackTrace();
			//加密失败则原样返回
			return msg;
		}
	}
	
	public static String decryptMsg(Config config,String msg, String timestamp, String nonce) {
		return decryptMsg(config.getToken(), config.getEncodingAesKey(), config.getAppId(), msg, timestamp, nonce);
	}
	
	public static String decryptMsg(String token,String encodingAesKey,String appId,String encryptedMsg, String timestamp, String nonce) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			StringReader sr = new StringReader(encryptedMsg);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);
			
			Element root = document.getDocumentElement();
			NodeList nodelist1 = root.getElementsByTagName("Encryptor");
			NodeList nodelist2 = root.getElementsByTagName("MsgSignature");
			
			String encrypt = nodelist1.item(0).getTextContent();
			String msgSignature = nodelist2.item(0).getTextContent();
			
			String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encryptor><![CDATA[%1$s]]></Encryptor></xml>";
			String fromXML = String.format(format, encrypt);
			
			WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
			return pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
		}
		catch (Exception e) {
			e.printStackTrace();
			//解密失败则原样返回
			return encryptedMsg;
		}
	}
	
	public static String decryptEchoStr(Config config,String signature, String timestamp, String nonce,String echostr){
		return decryptEchoStr(config.getToken(), config.getEncodingAesKey(), config.getAppId(), signature, timestamp, nonce, echostr);
	}
	
	public static String decryptEchoStr(String token,String encodingAesKey,String appId,String signature, String timestamp, String nonce,String echostr){
		try {
			WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
			return pc.verifyUrl(signature, timestamp, nonce, echostr);
		} catch (AesException e) {
			e.printStackTrace();
			//解密失败则原样返回
			return echostr;
		}
	}
}



