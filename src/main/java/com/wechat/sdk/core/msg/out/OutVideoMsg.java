/**
 * Copyright (c) 2011-2015import com.wechat.sdk.core.msg.in.InMsg;
ail.com).
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
 * OutVideoMsg for sending video message to user
 * <xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[fromUser]]></FromUserName>
		<CreateTime>12345678</CreateTime>
		<MsgType><![CDATA[video]]></MsgType>
			<Video>
				<MediaId><![CDATA[media_id]]></MediaId>
				<Title><![CDATA[title]]></Title>
				<Description><![CDATA[description]]></Description>
			</Video>
 *</xml>
 * @author 帮杰
 *
 */
public class OutVideoMsg extends OutMsg {
	
	private String mediaId;
	private String title;		// not necessary
	private String description;	// not necessary
	
	public OutVideoMsg() {
		this.msgType = "video";
	}
	
	public OutVideoMsg(InMsg inMsg) {
		super(inMsg);
		this.msgType = "video";
	}
	
	public String getMediaId() {
		return mediaId;
	}
	
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		String t = "<xml><ToUserName><![CDATA[toUserName]]></ToUserName><FromUserName><![CDATA[fromUserName]]></FromUserName><CreateTime>createTime</CreateTime><MsgType><![CDATA[video]]></MsgType><Video><MediaId><![CDATA[mediaId]]></MediaId><Title><![CDATA[title]]></Title><Description><![CDATA[description]]></Description></Video></xml>";
		t = t.replace("toUserName", toUserName)
			 .replace("fromUserName", fromUserName)
			 .replace("createTime", ""+createTime)
			 .replace("mediaId", mediaId)
			 .replace("title", title==null?"":title)
			 .replace("description", description==null?"":title);
		return t;
	}
}







