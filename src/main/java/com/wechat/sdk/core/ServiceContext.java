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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * WeChat service context.
 * @author 帮杰
 *
 */
public class ServiceContext {

	private Config config;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	public ServiceContext() {
	}

	public ServiceContext(Config config,HttpServletRequest request,HttpServletResponse response) {
		this.config = config;
		this.request = request;
		this.response = response;
	}
	
	public Config getWechatApiConfig() {
		return config;
	}

	void setWechatApiConfig(Config config) {
		this.config = config;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	void setResponse(HttpServletResponse response) {
		this.response = response;
	}

}
