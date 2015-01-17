package com.zcc.doms;

import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTestOne {

	public static void main(String[] args) {
		// 创建一个对象
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse("books.xml");
			NodeList boookList = document.getElementsByTagName("book");
			System.out.println("一共有" + boookList.getLength());
			Node item = null;
			for (int index = 0; index < boookList.getLength(); index++) {
				item = boookList.item(index);
//				NamedNodeMap attributes = item.getAttributes();
//				System.out.println("第" + (index + 1) + "本书的" + attributes.getLength());
//				for (int two = 0; two < attributes.getLength(); two++) {
//					Node node = attributes.item(two);
//					String nodeName = node.getNodeName();
//					String nodeValue = node.getNodeValue();
//					System.out.print(nodeName);
//					System.out.println(nodeValue);
//
//				}
				item.getAttributes();
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
