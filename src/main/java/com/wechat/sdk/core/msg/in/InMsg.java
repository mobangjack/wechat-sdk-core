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
 * In abstract message from WeChat server.
 * <xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[fromUser]]></FromUserName> 
		<CreateTime>1348831860</CreateTime>
		<MsgType><![CDATA[text]]></MsgType>
			<Content><![CDATA[this is a test]]></Content>
			<MsgId>1234567890123456</MsgId>
 *</xml>
 * @author 帮杰
 *
 */
public class InMsg {
	
	// 开发者微信号
	protected String toUserName;
	
	// 发送方帐号（一个OpenID）
	protected String fromUserName;
	
	// 消息创建时间 （整型）
	protected Integer createTime;
	
	/**
	 * 消息类型
	 * <br>1：text 文本消息
	 * <br>2：image 图片消息
	 * <br>3：voice 语音消息
	 * <br>4：video 视频消息
	 * <br>5：location 地址位置消息
	 * <br>6：link 链接消息
	 * <br>7：event 事件
	 */
	protected String msgType;
	
	public InMsg(Map<String, String> xmlMap) {
		toUserName = xmlMap.get("ToUserName");
		fromUserName = xmlMap.get("FromUserName");
		createTime = Integer.parseInt(xmlMap.get("CreateTime"));
		msgType = xmlMap.get("MsgType");
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
	
	/**
	 * 获取消息类型
	 * <br>1：text 文本消息
	 * <br>2：image 图片消息
	 * <br>3：voice 语音消息
	 * <br>4：video 视频消息
	 * <br>5：location 地址位置消息
	 * <br>6：link 链接消息
	 * <br>7：event 事件
	 */
	public String getMsgType() {
		return msgType;
	}
	
	/**
	 * 设置消息类型
	 * <br>1：text 文本消息
	 * <br>2：image 图片消息
	 * <br>3：voice 语音消息
	 * <br>4：video 视频消息
	 * <br>5：location 地址位置消息
	 * <br>6：link 链接消息
	 * <br>7：event 事件
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

}







