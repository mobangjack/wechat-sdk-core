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
package com.wechat.sdk.core.msg.in;

import java.util.Map;

/**
 * In location message from WeChat server.
 * <xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[fromUser]]></FromUserName>
		<CreateTime>1351776360</CreateTime>
		<MsgType><![CDATA[location]]></MsgType>
			<Location_X>23.134521</Location_X>
			<Location_Y>113.358803</Location_Y>
			<Scale>20</Scale>
			<Label><![CDATA[位置信息]]></Label>
			<MsgId>1234567890123456</MsgId>
 *</xml>
 * @author 帮杰
 *
 */
public class InLocationMsg extends InMsg {
	private String location_X;
	private String location_Y;
	private String scale;
	private String label;
	private String msgId;
	
	public InLocationMsg(Map<String, String> xmlMap) {
		super(xmlMap);
		location_X = xmlMap.get("Location_X");
		location_Y = xmlMap.get("Location_Y");
		scale = xmlMap.get("Scale");
		label = xmlMap.get("Label");
		msgId = xmlMap.get("MsgId");
	}
	
	public String getLocation_X() {
		return location_X;
	}
	
	public void setLocation_X(String location_X) {
		this.location_X = location_X;
	}
	
	public String getLocation_Y() {
		return location_Y;
	}
	
	public void setLocation_Y(String location_Y) {
		this.location_Y = location_Y;
	}
	
	public String getScale() {
		return scale;
	}
	
	public void setScale(String scale) {
		this.scale = scale;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
}




