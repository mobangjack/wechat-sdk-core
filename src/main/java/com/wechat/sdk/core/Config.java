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
package com.wechat.sdk.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * WeChat API configuration.
 * @author 帮杰
 *
 */
public class Config {

	private String token;
	private String appId;
	private String appSecret;
	private boolean encryptMsg = false;
	private String encodingAesKey;
	
	public Config() {
	}
	
	public Config(String token,String appId,String appSecret) {
		config(token, appId, appSecret);
	}
	
	public void config(String token,String appId,String appSecret) {
		config(token, appId, appSecret, false, null);
	}
	
	public Config(String token,String appId,String appSecret,boolean encryptMsg,String encodingAesKey) {
		config(token, appId, appSecret, encryptMsg, encodingAesKey);
	}
	
	public Config config(String token,String appId,String appSecret,boolean encryptMsg,String encodingAesKey) {
		if(isBlank(token))
			throw new IllegalArgumentException("token can not be null.");
		this.token = token;
		if(isBlank(appId))
			throw new IllegalArgumentException("appId can not be null.");
		this.appId = appId;
		if(isBlank(appSecret))
			throw new IllegalArgumentException("appSecret can not be null.");
		this.appSecret = appSecret;
		this.encryptMsg = encryptMsg;
		if(encryptMsg&&isBlank(encodingAesKey))
			throw new IllegalArgumentException("encodingAesKey can not be null if encryptMsg=true.");
		this.encodingAesKey = encodingAesKey;
		return this;
	}
	
	public Config loadProperties(Properties properties) {
		if(properties==null)
			throw new IllegalArgumentException("properties can not be null.");
		String token = properties.getProperty("token");
		if(isBlank(token))
			throw new RuntimeException("token can not be null");
		String appId = properties.getProperty("appId");
		if(isBlank(appId))
			throw new RuntimeException("appId can not be null");
		String appSecret = properties.getProperty("appSecret");
		if(isBlank(appSecret))
			throw new RuntimeException("appSecret can not be null");
		String encryptMsgStr = properties.getProperty("encryptMsg","false");
		boolean encryptMsg = encryptMsgStr.trim().equalsIgnoreCase("true");
		String encodingAesKey = properties.getProperty("encodingAesKey");
		if(encryptMsg&&isBlank(encodingAesKey))
			throw new RuntimeException("encodingAesKey can not be null if you've set encryptMsg true");
		return config(token, appId, appSecret, encryptMsg, encodingAesKey);
	}
	
	public Config loadPropertiesFile(String fileName) {
		return loadPropertiesFile(fileName, "UTF-8");
	}
	
	public Config loadPropertiesFile(String fileName,String encoding) {
		Properties properties = null;
		InputStream inputStream = null;
		try {
			inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			if (inputStream == null)
				throw new IllegalArgumentException("Properties file '"+fileName+"' could not be found in classpath.");
			properties = new Properties();
			properties.load(new InputStreamReader(inputStream, encoding));
		} catch (IOException e) {
			throw new RuntimeException("Error loading properties file '"+fileName+"'", e);
		}
		finally {
			if (inputStream != null) try {inputStream.close();} catch (IOException e) {e.printStackTrace();}
		}
		return loadProperties(properties);
	}

	private static boolean isBlank(String str) {
		return str==null||str.trim().equals("");
	}

	public String getToken() {
		return token;
	}

	public Config setToken(String token) {
		if(isBlank(token))
			throw new IllegalArgumentException("token can not be blank.");
		this.token = token;
		return this;
	}

	public String getAppId() {
		return appId;
	}

	public Config setAppId(String appId) {
		if(isBlank(appId))
			throw new IllegalArgumentException("appId can not be blank.");
		this.appId = appId;
		return this;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public Config setAppSecret(String appSecret) {
		if(isBlank(appSecret))
			throw new IllegalArgumentException("appSecret can not be blank.");
		this.appSecret = appSecret;
		return this;
	}

	public boolean encryptMsg() {
		return encryptMsg;
	}

	public Config setEncryptMsg(boolean encryptMsg) {
		this.encryptMsg = encryptMsg;
		return this;
	}

	public String getEncodingAesKey() {
		return encodingAesKey;
	}

	public Config setEncodingAesKey(String encodingAesKey) {
		if(encryptMsg&&isBlank(encodingAesKey))
			throw new IllegalArgumentException("encodingAesKey can not be blank if encryptMsg is set true.");
		this.encodingAesKey = encodingAesKey;
		return this;
	}

}
