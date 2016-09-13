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
package com.wechat.sdk.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wechat.sdk.core.msg.in.InImageMsg;
import com.wechat.sdk.core.msg.in.InLinkMsg;
import com.wechat.sdk.core.msg.in.InLocationMsg;
import com.wechat.sdk.core.msg.in.InMsg;
import com.wechat.sdk.core.msg.in.InTextMsg;
import com.wechat.sdk.core.msg.in.InVideoMsg;
import com.wechat.sdk.core.msg.in.InVoiceMsg;
import com.wechat.sdk.core.msg.in.event.InEvent;
import com.wechat.sdk.core.msg.in.event.InFollowEvent;
import com.wechat.sdk.core.msg.in.event.InLocationEvent;
import com.wechat.sdk.core.msg.in.event.InMenuEvent;
import com.wechat.sdk.core.msg.in.event.InQrCodeEvent;
import com.wechat.sdk.core.msg.out.OutMsg;
import com.wechat.sdk.core.util.XmlUtil;
import com.wechat.sdk.core.util.encrypt.EncryptUtil;

/**
 * WeChat Handler.
 * @author 帮杰
 *
 */
public abstract class Handler {

	public static final String IN_TEXT_MSG = "text";
	public static final String IN_LINK_MSG = "link";
	public static final String IN_LOCATION_MSG = "location";
	public static final String IN_IMAGE_MSG = "image";
	public static final String IN_VOICE_MSG = "voice";
	public static final String IN_VIDEO_MSG = "shortvideo";
	public static final String IN_EVENT_MSG = "event";
	
	private String inXml;
	private Map<String, String> inXmlMap;
	private ServiceContext serviceContext;
	
	public Handler() {}
	
	public void handle(ServiceContext serviceContext) throws IOException{
		this.serviceContext = serviceContext;
		HttpServletRequest request = serviceContext.getRequest();
		HttpServletResponse response = serviceContext.getResponse();
		inXml = XmlUtil.read(request.getInputStream());
		Config config = serviceContext.getWechatApiConfig();
		if (config.encryptMsg()) {
			inXml = EncryptUtil.decryptMsg(config, inXml, request.getParameter("timestamp"), request.getParameter("nonce"));
		}
		String outXml = handle(inXml);
		if (config.encryptMsg()) {
			outXml = EncryptUtil.encryptMsg(config, outXml, request.getParameter("timestamp"), request.getParameter("nonce"));
		}
		if (!response.isCommitted()) {
			response.setContentType("text/xml");
			PrintWriter writer = response.getWriter();
			writer.write(outXml);
			writer.flush();
			writer.close();
			writer = null;
		}
	}
	
	private String handle(String inXml) {
		try {
			inXmlMap = XmlUtil.xmlToMap(inXml);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		OutMsg outMsg = null;
		String msgType = inXmlMap.get("MsgType");
		if(msgType.equals(IN_TEXT_MSG)) {
			InTextMsg inTextMsg = new InTextMsg(inXmlMap);
			outMsg = handleInTextMsg(inTextMsg);
		}else if(msgType.equals(IN_VOICE_MSG)) {
			InVoiceMsg inVoiceMsg = new InVoiceMsg(inXmlMap);
			outMsg = handleInVoiceMsg(inVoiceMsg);
		}else if(msgType.equals(IN_IMAGE_MSG)) {
			InImageMsg inImageMsg = new InImageMsg(inXmlMap);
			outMsg = handleInImageMsg(inImageMsg);
		}else if(msgType.equals(IN_VIDEO_MSG)) {
			InVideoMsg inVideoMsg = new InVideoMsg(inXmlMap);
			outMsg = handleInVideoMsg(inVideoMsg);
		}else if(msgType.equals(IN_LINK_MSG)) {
			InLinkMsg inLinkMsg = new InLinkMsg(inXmlMap);
			outMsg = handleInLinkMsg(inLinkMsg);
		}else if(msgType.equals(IN_LOCATION_MSG)) {
			InLocationMsg inLocationMsg = new InLocationMsg(inXmlMap);
			outMsg = handleInLocationMsg(inLocationMsg);
		}else if(msgType.equals(IN_EVENT_MSG)) {
			InEvent inEvent = new InEvent(inXmlMap);
			String event = inEvent.getEvent();
			if(event.equalsIgnoreCase(InEvent.EVENT_SUBSCRIBE)||event.equalsIgnoreCase(InEvent.EVENT_UNSUBSCRIBE)) {
				InFollowEvent inFollowEvent = new InFollowEvent(inXmlMap);
				outMsg = handleInFollowEvent(inFollowEvent);
			}else if(event.equalsIgnoreCase(InEvent.EVENT_LOCATION)) {
				InLocationEvent inLocationEvent = new InLocationEvent(inXmlMap);
				outMsg = handleInLocationEvent(inLocationEvent);
			}else if(event.equalsIgnoreCase(InEvent.EVENT_CLICK)||event.equalsIgnoreCase(InEvent.EVENT_VIEW)) {
				InMenuEvent inMenuEvent = new InMenuEvent(inXmlMap);
				outMsg = handleInMenuEvent(inMenuEvent);
			}else if(event.equalsIgnoreCase(InEvent.EVENT_SCAN)) {
				InQrCodeEvent inQrCodeEvent = new InQrCodeEvent(inXmlMap);
				outMsg = handleInQrCodeEvent(inQrCodeEvent);
			}
		}else {
			System.err.println("Handler:Unrecognized msg type:"+inXml);
			InMsg inMsg = new InMsg(inXmlMap);
			outMsg = handleInUnknownTypeMsg(inMsg);
		}
		
		return outMsg==null?"":outMsg.toString();
		
	}
	
	public String getInXml() {
		return inXml;
	}
	
	public Map<String, String> getInXmlMap() {
		return inXmlMap;
	}

	public ServiceContext getServiceContext() {
		return serviceContext;
	}

	protected abstract OutMsg handleInTextMsg(InTextMsg inTextMsg);
	protected abstract OutMsg handleInVoiceMsg(InVoiceMsg inVoiceMsg);
	protected abstract OutMsg handleInImageMsg(InImageMsg inImageMsg);
	protected abstract OutMsg handleInVideoMsg(InVideoMsg inVideoMsg);
	protected abstract OutMsg handleInLinkMsg(InLinkMsg inLinkMsg);
	protected abstract OutMsg handleInLocationMsg(InLocationMsg inLocationMsg);
	protected abstract OutMsg handleInFollowEvent(InFollowEvent inFollowEvent);
	protected abstract OutMsg handleInLocationEvent(InLocationEvent inLocationEvent);
	protected abstract OutMsg handleInMenuEvent(InMenuEvent inMenuEvent);
	protected abstract OutMsg handleInQrCodeEvent(InQrCodeEvent inQrCodeEvent);
	protected abstract OutMsg handleInUnknownTypeMsg(InMsg inMsg);
	
}
