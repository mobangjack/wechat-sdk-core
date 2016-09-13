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

/**
 * Article for OutNewsMsg
 * <xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[fromUser]]></FromUserName>
		<CreateTime>12345678</CreateTime>
		<MsgType><![CDATA[news]]></MsgType>
			<ArticleCount>2</ArticleCount>
			<Articles>
				<item>
					<Title><![CDATA[title1]]></Title> 
					<Description><![CDATA[description1]]></Description>
					<PicUrl><![CDATA[picurl]]></PicUrl>
					<Url><![CDATA[url]]></Url>
				</item>
				
				<item>
					<Title><![CDATA[title]]></Title>
					<Description><![CDATA[description]]></Description>
					<PicUrl><![CDATA[picurl]]></PicUrl>
					<Url><![CDATA[url]]></Url>
				</item>
			</Articles>
 *</xml>
 * @author 帮杰
 *
 */
public class Article {
	
	private String title;		// not necessary
	
	private String description;	// not necessary
	
	private String picUrl;		// not necessary
	
	private String url;			// not necessary
	
	public Article(String title, String description, String picUrl, String url) {
		this.title = title;
		this.description = description;
		this.picUrl = picUrl;
		this.url = url;
	}
	
	public Article() {
		
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
	
	public String getPicUrl() {
		return picUrl;
	}
	
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		String t = "<item><Title><![CDATA[title]]></Title> <Description><![CDATA[description]]></Description><PicUrl><![CDATA[picUrl]]></PicUrl><Url><![CDATA[url]]></Url></item>";
		t = t.replace("title", title==null?"":title)
			 .replace("description", description==null?"":description)
			 .replace("picUrl", picUrl==null?"":picUrl)
			 .replace("url", url==null?"":url);
		return t;
	}
}
