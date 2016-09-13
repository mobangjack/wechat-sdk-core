/**
 * Copyright (c) 2011-2015import java.util.ArrayList;
import java.util.List;

import com.wechat.sdk.core.msg.in.InMsg;
rsion 2.0 (the "License");
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

import java.util.ArrayList;
import java.util.List;

import com.wechat.sdk.core.msg.in.InMsg;

/**
 * OutNewsMsg for sending news message to user
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
public class OutNewsMsg extends OutMsg {
	
	private List<Article> articles = new ArrayList<Article>();
	
	public OutNewsMsg() {
		this.msgType = "news";
	}
	
	public OutNewsMsg(InMsg inMsg) {
		super(inMsg);
		this.msgType = "news";
	}
	
	public Integer getArticleCount() {
		return articles.size();
	}
	
	public List<Article> getArticles() {
		return articles;
	}
	
	public void setArticles(List<Article> articles) {
		if (articles != null)
			this.articles = articles;
	}
	
	public OutNewsMsg addNews(List<Article> articles) {
		if (articles != null)
			this.articles.addAll(articles);
		return this;
	}
	
	public OutNewsMsg addNews(String title, String description, String picUrl, String url) {
		this.articles.add(new Article(title, description, picUrl, url));
		return this;
	}
	
	public OutNewsMsg addNews(Article article) {
		this.articles.add(article);
		return this;
	}
	
	@Override
	public String toString() {
		String t = "<xml><ToUserName><![CDATA[toUserName]]></ToUserName><FromUserName><![CDATA[fromUserName]]></FromUserName><CreateTime>createTime</CreateTime><MsgType><![CDATA[news]]></MsgType><ArticleCount>articleCount</ArticleCount><Articles>";
		t = t.replace("toUserName", toUserName)
			 .replace("fromUserName", fromUserName)
			 .replace("createTime", ""+createTime)
			 .replace("articleCount",""+articles.size());
		for(Article article:articles){
			t+=article;
		}
		t+="</Articles></xml>";
		return t;
	}
}








