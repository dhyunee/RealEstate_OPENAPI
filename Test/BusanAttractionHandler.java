package com.ssafy.rent.util;

import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import com.ssafy.rent.model.dto.Attraction;

public class BusanAttractionHandler extends DefaultHandler {
	/**아파트 거래 정보를 담는다 */
	private List<Attraction> attractions;
	/**파상힌 아파트 거래 정보*/
	private Attraction attractionB;
	/**태그 바디 정보를 임시로 저장*/
	private String temp;
	public BusanAttractionHandler(){
		attractions = new LinkedList<Attraction>();
	}
	public void startElement(String uri, String localName
			                           , String qName, Attributes att ){
		if(qName.equals("item")){
			// complete code #04
			// APTDealSAXHandler Class 를 참조하여, 아파트 전월세 거래 정보에 맞도록 코드를 추가하세요.
			attractionB = new Attraction(HomeSaxParser.no++);
			attractions.add(attractionB);
		}
	}
	public void endElement(String uri, String localName, String qName){
		if(qName.equals("elife06")) { 
			attractionB.setElife06(Integer.parseInt(temp));
		}else if(qName.equals("inspecQt")) { 
			attractionB.setInspecQt(Integer.parseInt(temp));
		}else if(qName.equals("elife05")) { 
			attractionB.setElife05(Integer.parseInt(temp));
		}else if(qName.equals("elife04")) {
			attractionB.setElife04(Integer.parseInt(temp));
		}else if(qName.equals("inspecKb2")) { 
			attractionB.setInspecKb2(temp.trim());
		}else if(qName.equals("elife03")) {
			attractionB.setElife03(Integer.parseInt(temp));
		}else if(qName.equals("inspecKb1")) { 
			attractionB.setInspecKb1(temp.trim());
		}else if(qName.equals("elife02")) { 
			attractionB.setElife02(Integer.parseInt(temp));
		}else if(qName.equals("elife01")) { 
			attractionB.setElife01(Integer.parseInt(temp));
		}else if(qName.equals("inspecArea")) { 
			attractionB.setInspecArea(temp.trim());
		}else if(qName.equals("inspecKb3")) { 
			attractionB.setInspecKb3(temp.trim());
		}else if(qName.equals("avgnight")) { 
			attractionB.setAvgnight(Integer.parseInt(temp));
		}else if(qName.equals("avgdaytime")) { 
			attractionB.setAvgdaytime(Integer.parseInt(temp));
		}else if(qName.equals("inspecPoint")) { 
			attractionB.setInspecPoint(temp.trim());
		}else if(qName.equals("inspecYy")) { 
			attractionB.setInspecYy(Integer.parseInt(temp));
		}
		
		
	}
	public void characters(char[]ch, int start, int length){
		temp = new String(ch, start, length);
	}
	public List<Attraction> getAttractions() {
		return attractions;
	}
	public void setAttractions(List<Attraction> attractions) {
		this.attractions = attractions;
	}
}
