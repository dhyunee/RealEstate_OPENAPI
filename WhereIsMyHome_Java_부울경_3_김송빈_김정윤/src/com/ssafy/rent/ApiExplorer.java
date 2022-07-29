package com.ssafy.rent;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Open API瑜� �넻�빐 �뜲�씠�� 異붿텧
 *
 */
public class ApiExplorer {
	public static void main(String[] args) throws IOException {
		// StringBuilder urlBuilder = new
		// StringBuilder("http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTrade");
		// /*�븘�뙆�듃 留ㅻℓ URL*/
		// StringBuilder urlBuilder = new
		// StringBuilder("http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcRHTrade");
		// /*�뿰由� �떎�꽭�� 留ㅻℓ URL*/
//        StringBuilder urlBuilder = new StringBuilder("http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptRent"); /*�븘�뙆�듃 �쟾�썡�꽭  URL*/
//    	StringBuilder urlBuilder = new StringBuilder("http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcRHRent"); /*�뿰由� �떎�꽭�� �쟾�썡�꽭URL*/
//        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=VhV%2BKsNjBo0fEzXZKe%2Bvg%2B5ma5V6yRBggE7g%2BeUGz0SrYsZ%2FvVr7Kv70RHPzPJGqga%2Fk0DerMNhOzmPbSdd57g%3D%3D"); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("LAWD_CD","UTF-8") + "=" + URLEncoder.encode("11110", "UTF-8")); /*�룞肄붾뱶 寃��깋*/
//        urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD","UTF-8") + "=" + URLEncoder.encode("201912", "UTF-8")); /*嫄곕옒 �뀈�썡 寃��깋*/

		Path file = Paths.get("C:" + File.separator + "test.xml");
		try {
			if (!Files.exists(file)) {
				Files.createFile(file);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String serviceUrl = "http://apis.data.go.kr/6260000/EnvironmentalNosie/getNoiseInfo";
		String seriveKey = "=SrtntpXj3c3ur1ed1qBp1pP6hZnss%2FtuiVcEBVNJNFpymvfK0g3JnCpWqyo%2BZpZGhPuC5hiUZpPfKIm4aqLHdQ%3D%3D";

		StringBuilder urlBuilder = new StringBuilder(serviceUrl);
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + seriveKey);
		urlBuilder.append("&" + URLEncoder.encode("numOfROWs", "UTF-8") + "="
				+ URLEncoder.encode("10", "UTF-8")); /* �룞肄붾뱶 寃��깋 */
		urlBuilder.append(
				"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 嫄곕옒 �뀈�썡 寃��깋 */

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
		// StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			Files.write(file, line.getBytes(), StandardOpenOption.APPEND);
			Files.write(file, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
		}
		rd.close();
		conn.disconnect();
//		System.out.println(sb.toString());
	}
}