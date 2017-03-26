package com.flf.util;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import net.sf.json.JSONObject;

public class LngAndLatUtil {
	
	public static Map<String,Double> getLngAndLat(String city,String address){
		Map<String, Double> map = new HashMap<String, Double>();
		String url = "http://api.map.baidu.com/geocoder/v2/?ak="
				+ Const.BAIDU_MAP_AK
				+ "&output=json&address=" + address
				+ "&city=" + city;
		String json = loadJSON(url);
		JSONObject obj = JSONObject.fromObject(json);
		if (obj.get("status").toString().equals("0")) {
			double lng = obj.getJSONObject("result").getJSONObject("location")
					.getDouble("lng");
			double lat = obj.getJSONObject("result").getJSONObject("location")
					.getDouble("lat");
			map.put("lng", lng);
			map.put("lat", lat);
			System.out.println("经度："+lng+"---纬度："+lat);
		} else {
			System.out.println("未找到相匹配的经纬度！");
		}
		return map;
	}
	
	 public static String loadJSON (String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                                        yc.getInputStream()));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return json.toString();
    }
	
	 public static void main(String[] args) {
		 String city="广州市";
		 String address="广州市天河区天河北路高科大厦";
		 getLngAndLat(city,address);
	 }
}