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
 * abstract OutMsg
 * <xml>
	<ToUserName><![CDATA[toUser]]></ToUserName>
	<FromUserName><![CDATA[fromUser]]></FromUserName>
	<CreateTime>12345678</CreateTime>
	<MsgType><![CDATA[text]]></MsgType>
	<Content><![CDATA[你好]]></Content>
 *</xml>
 * @author 帮杰
 *
 */
public abstract class OutMsg {
	
	protected String toUserName;
	protected String fromUserName;
	protected Integer createTime;
	
	/**
	 * 被动响应消息类型
	 * 1：text 文本消息
	 * 2：image 图片消息
	 * 3：voice 语音消息
	 * 4：video 视频消息
	 * 5：music 音乐消息
	 * 6：news 图文消息
	 */
	protected String msgType;
	
	/**
	 * 用接收到的消息初始化要发出去的消息，关键在于两者 toUserName 与 fromUserName 相反
	 */
	public OutMsg(InMsg inMsg) {
		this.toUserName = inMsg.getFromUserName();
		this.fromUserName = inMsg.getToUserName();
		this.createTime = now();
	}
	
	public OutMsg() {
		
	}
	
	private Integer now() {
		return (int)(System.currentTimeMillis() / 1000);
	}
	
	public String getToUserName() {
		return toUserName;
	}
	
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	
	public String getFromUserName() {
		return fromUserName;
	}
	
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	
	public Integer getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	
	public String getMsgType() {
		return msgType;
	}
	
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	@Override
	public String toString() {
		if (this instanceof OutImageMsg) {
			return ((OutImageMsg)this).toString();
		}
		else if (this instanceof OutMusicMsg) {
			return ((OutMusicMsg)this).toString();
		}
		else if (this instanceof OutNewsMsg) {
			return ((OutNewsMsg)this).toString();
		}
		else if (this instanceof OutTextMsg) {
			return ((OutTextMsg)this).toString();
		}
		else if (this instanceof OutVideoMsg) {
			return ((OutVideoMsg)this).toString();
		}
		else if (this instanceof OutVoiceMsg) {
			return ((OutVoiceMsg)this).toString();
		}else {
			return super.toString();
		}
		
	}
	
}
