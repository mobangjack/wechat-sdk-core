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
package com.wechat.sdk.core.msg.out;

import com.wechat.sdk.core.msg.in.InMsg;

/**
 * OutVoiceMsg for sending voice message to user
 * <xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[fromUser]]></FromUserName>
		<CreateTime>12345678</CreateTime>
		<MsgType><![CDATA[voice]]></MsgType>
			<Voice>
				<MediaId><![CDATA[media_id]]></MediaId>
			</Voice>
 *</xml>
 * @author 帮杰
 *
 */
public class OutVoiceMsg extends OutMsg {
	
	private String mediaId;
	
	public OutVoiceMsg() {
		this.msgType = "voice";
	}
	
	public OutVoiceMsg(InMsg inMsg) {
		super(inMsg);
		this.msgType = "voice";
	}
	
	public String getMediaId() {
		return mediaId;
	}
	
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	@Override
	public String toString() {
		String t = "<xml><ToUserName><![CDATA[toUserName]]></ToUserName><FromUserName><![CDATA[fromUserName]]></FromUserName><CreateTime>createTime</CreateTime><MsgType><![CDATA[voice]]></MsgType><Voice><MediaId><![CDATA[mediaId]]></MediaId></Voice></xml>";
		t = t.replace("toUserName", toUserName)
			 .replace("fromUserName", fromUserName)
			 .replace("createTime", ""+createTime)
			 .replace("mediaId", mediaId);
		return t;
	}
}













