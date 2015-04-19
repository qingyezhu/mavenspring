package com.wangzhu.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class XMLUtils {

	public static String createXML(String rootName, Map<String, String> map) {
		Element root = new Element(rootName);
		Document doc = new Document(root);
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			Element child = new Element(key);
			child.addContent(value);
			root.addContent(child);
		}
		XMLOutputter output = new XMLOutputter(Format.getPrettyFormat()
				.setEncoding("GBK"));
		String xmlStr = output.outputString(doc);
		return xmlStr;
	}

	public static String readFromXml(String xmlStr, String key) {
		if (!xmlStr.startsWith("<?xml")) {
			return null;
		}
		SAXBuilder saxBuilder = new SAXBuilder();
		try {
			Document doc = saxBuilder.build(new ByteArrayInputStream(xmlStr
					.getBytes("GBK")));
			Element root = doc.getRootElement();
			Element child = root.getChild(key);
			if (child != null) {
				return child.getText();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
