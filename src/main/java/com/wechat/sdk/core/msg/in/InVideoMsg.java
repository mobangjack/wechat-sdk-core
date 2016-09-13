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
 * In video message from WeChat server
 * <xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[fromUser]]></FromUserName>
		<CreateTime>1357290913</CreateTime>
		<MsgType><![CDATA[video]]></MsgType>
			<MediaId><![CDATA[media_id]]></MediaId>
			<ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>
			<MsgId>1234567890123456</MsgId>
 *</xml>
 * @author 帮杰
 *
 */
public class InVideoMsg extends InMsg {
	
	private String mediaId;
	private String thumbMediaId;
	private String msgId;
	
	public InVideoMsg(Map<String, String> xmlMap) {
		super(xmlMap);
		mediaId = xmlMap.get("MediaId");
		thumbMediaId = xmlMap.get("ThumbMediaId");
		msgId = xmlMap.get("MsgId");
	}
	
	public String getMediaId() {
		return mediaId;
	}
	
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
}



