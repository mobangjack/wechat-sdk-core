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
package com.wechat.sdk.core.msg.in.event;

import java.util.Map;

import com.wechat.sdk.core.msg.in.InMsg;

/**
 * In event message from WeChat server
 * @author 帮杰
 *
 */
public class InEvent extends InMsg {

	public static final String EVENT_SUBSCRIBE = "subscribe";
	public static final String EVENT_UNSUBSCRIBE = "unsubscribe";
	public static final String EVENT_LOCATION = "LOCATION";
	public static final String EVENT_CLICK = "CLICK";
	public static final String EVENT_VIEW = "VIEW";
	public static final String EVENT_SCAN = "SCAN";
	
	private String event;

	public InEvent(Map<String, String> xmlMap) {
		super(xmlMap);
		event = xmlMap.get("Event");
	}
	
	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

}
