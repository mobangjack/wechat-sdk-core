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


/**
 * In menu event from WeChat server
 * <xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[FromUser]]></FromUserName>
		<CreateTime>123456789</CreateTime>
		<MsgType><![CDATA[event]]></MsgType>
			<Event><![CDATA[CLICK]]></Event>
			<EventKey><![CDATA[EVENTKEY]]></EventKey>
 *</xml>
 *<xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[FromUser]]></FromUserName>
		<CreateTime>123456789</CreateTime>
		<MsgType><![CDATA[event]]></MsgType>
			<Event><![CDATA[VIEW]]></Event>
			<EventKey><![CDATA[www.qq.com]]></EventKey>
 *</xml>
 * @author 帮杰
 *
 */
public class InMenuEvent extends InEvent {
	
	private String eventKey;
	
	public InMenuEvent(Map<String, String> xmlMap) {
		super(xmlMap);
		eventKey = xmlMap.get("EventKey");
	}
	
	/**
	 * CLICK,VIEW,etc.
	 * @return
	 */
	public String getEventKey() {
		return eventKey;
	}
	
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
}



