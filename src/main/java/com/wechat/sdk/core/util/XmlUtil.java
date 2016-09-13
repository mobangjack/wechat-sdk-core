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
package com.wechat.sdk.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * XML tool
 * 
 */
public class XmlUtil {

	public static String read(InputStream inputStream) throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		StringBuffer sb = new StringBuffer();
		String str = null;
		while((str=bufferedReader.readLine())!=null){
			sb.append(str);
		}
		bufferedReader.close();
		bufferedReader = null;
		inputStreamReader.close();
		inputStreamReader = null;
		return sb.toString();
	}

	public static Map<String, String> xmlToMap(String xml) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		StringReader sr = new StringReader(xml);
		InputSource is = new InputSource(sr);
		Document document = db.parse(is);

		Map<String, String> xmlMap = new HashMap<String, String>();
		Element root = document.getDocumentElement();
		NodeList nodeList = root.getChildNodes();
		for(int i=0;i<nodeList.getLength();i++){
			xmlMap.put(nodeList.item(i).getNodeName(), nodeList.item(i).getTextContent());
		}
		return xmlMap;
	}
	
}
