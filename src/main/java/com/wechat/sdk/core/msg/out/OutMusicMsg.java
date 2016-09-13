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
 * OutMusicMsg for sending music message to user
 * <xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[fromUser]]></FromUserName>
		<CreateTime>12345678</CreateTime>
		<MsgType><![CDATA[music]]></MsgType>
			<Music>
				<Title><![CDATA[TITLE]]></Title>
				<Description><![CDATA[DESCRIPTION]]></Description>
				<MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
				<HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
				<ThumbMediaId><![CDATA[media_id]]></ThumbMediaId>
			</Music>
 *</xml>
 * @author 帮杰
 *
 */
public class OutMusicMsg extends OutMsg {
	
	private String title;		// not necessary
	private String description;	// not necessary
	private String musicUrl;	// not necessary
	private String hqMusicUrl;	// not necessary
	private String thumbMediaId;
	
	public OutMusicMsg() {
		this.msgType = "music";
	}
	
	public OutMusicMsg(InMsg inMsg) {
		super(inMsg);
		this.msgType = "music";
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
	
	public String getMusicUrl() {
		return musicUrl;
	}
	
	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}
	
	public String getHqMusicUrl() {
		return hqMusicUrl;
	}
	
	public void setHqMusicUrl(String hqMusicUrl) {
		this.hqMusicUrl = hqMusicUrl;
	}
	
	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	
	@Override
	public String toString() {
		String t = "<xml><ToUserName><![CDATA[toUserName]]></ToUserName><FromUserName><![CDATA[fromUserName]]></FromUserName><CreateTime>createTime</CreateTime><MsgType><![CDATA[music]]></MsgType><Music><Title><![CDATA[title]]></Title><Description><![CDATA[description]]></Description><MusicUrl><![CDATA[musicUrl]]></MusicUrl><HQMusicUrl><![CDATA[hqMusicUrl]]></HQMusicUrl><ThumbMediaId><![CDATA[thumbMediaId]]></ThumbMediaId></Music></xml>";
		t = t.replace("toUserName", toUserName)
			 .replace("fromUserName", fromUserName)
			 .replace("createTime", createTime+"")
			 .replace("title", title==null?"":title)
			 .replace("description", description==null?"":description)
			 .replace("musicUrl", musicUrl==null?"":musicUrl)
			 .replace("hqMusicUrl", hqMusicUrl==null?"":hqMusicUrl)
			 .replace("thumbMediaId", thumbMediaId);
		return t;
	}

	
}






