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
 * In image message from WeChat server.
 * <xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[fromUser]]></FromUserName>
		<CreateTime>1348831860</CreateTime>
		<MsgType><![CDATA[image]]></MsgType>
			<PicUrl><![CDATA[this is a url]]></PicUrl>
			<MediaId><![CDATA[media_id]]></MediaId>
			<MsgId>1234567890123456</MsgId>
 *</xml>
 * @author 帮杰
 *
 */
public class InImageMsg extends InMsg {
	
	private String picUrl;
	private String mediaId;
	private String msgId;
	
	public InImageMsg(Map<String, String> xmlMap) {
		super(xmlMap);
		picUrl = xmlMap.get("PicUrl");
		mediaId = xmlMap.get("MediaId");
		msgId = xmlMap.get("MsgId");
	}
	
	public String getPicUrl() {
		return picUrl;
	}
	
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
	public String getMediaId() {
		return mediaId;
	}
	
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
}





