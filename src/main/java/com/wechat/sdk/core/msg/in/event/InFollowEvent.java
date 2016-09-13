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
 * In follow/unfollow event message from WeChat server
 * <xml>
		<ToUserName><![CDATA[gh_e21b62f685f4]]></ToUserName>
		<FromUserName><![CDATA[o5Ljujn78A_S0uk_WvAM_fKFEXm4]]></FromUserName>
		<CreateTime>1411785252</CreateTime>
		<MsgType><![CDATA[event]]></MsgType>
			<Event><![CDATA[subscribe]]></Event>
			<EventKey><![CDATA[]]></EventKey>
 *</xml>
 * @author 帮杰
 *
 */
public class InFollowEvent extends InEvent {
	
	public InFollowEvent(Map<String, String> xmlMap) {
		super(xmlMap);
	}
	
}






