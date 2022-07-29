package com.ssafy.rent.util;

import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import com.ssafy.rent.model.dto.HomeDeal;

/**
 *  HomeDealHistory.xml 파일에서 주택 거래 정보를 읽어 파싱하는 핸들러 클래스 
 */
public class HomeDealSAXHandler extends DefaultHandler {
	// complete code #08
	// APTDealSAXHandler Class 를 참조하여, 주택 거래 정보에 맞도록 전체 코드를 작성하세요. 단, 아래 코드를 이용하여 완성하세요.
	public void startElement(String uri, String localName, String qName, Attributes att ){}
	public void endElement(String uri, String localName, String qName){}
	public void characters(char[]ch, int start, int length){}
	public List<HomeDeal> getHomes() { return null; }
	public void setHomes(List<HomeDeal> homes) {}
}





