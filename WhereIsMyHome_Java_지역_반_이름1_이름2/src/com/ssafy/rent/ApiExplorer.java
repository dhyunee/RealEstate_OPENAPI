package com.ssafy.rent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Open API를 통해 데이타 추출
 *
 */
public class ApiExplorer {
	public static void main(String[] args) throws IOException {
		// StringBuilder urlBuilder = new
		// StringBuilder("http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTrade");
		// /*아파트 매매 URL*/
		// StringBuilder urlBuilder = new
		// StringBuilder("http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcRHTrade");
		// /*연립 다세대 매매 URL*/
//        StringBuilder urlBuilder = new StringBuilder("http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptRent"); /*아파트 전월세  URL*/
//    	StringBuilder urlBuilder = new StringBuilder("http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcRHRent"); /*연립 다세대 전월세URL*/
//        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=VhV%2BKsNjBo0fEzXZKe%2Bvg%2B5ma5V6yRBggE7g%2BeUGz0SrYsZ%2FvVr7Kv70RHPzPJGqga%2Fk0DerMNhOzmPbSdd57g%3D%3D"); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("LAWD_CD","UTF-8") + "=" + URLEncoder.encode("11110", "UTF-8")); /*동코드 검색*/
//        urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD","UTF-8") + "=" + URLEncoder.encode("201912", "UTF-8")); /*거래 년월 검색*/

		String serviceUrl = "http://apis.data.go.kr/6260000/EnvironmentalNosie/getNoiseInfo";
		String seriveKey = "=SrtntpXj3c3ur1ed1qBp1pP6hZnss%2FtuiVcEBVNJNFpymvfK0g3JnCpWqyo%2BZpZGhPuC5hiUZpPfKIm4aqLHdQ%3D%3D";

		StringBuilder urlBuilder = new StringBuilder(serviceUrl);
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + seriveKey);
		urlBuilder.append(
				"&" + URLEncoder.encode("numOfROWs", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /* 동코드 검색 */
		urlBuilder.append(
				"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 거래 년월 검색 */

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/jdson");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
	}
}