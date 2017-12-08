package com.utils;

import java.io.IOException;
import java.util.ArrayList;

import com.bean.Hero;
import com.bean.HerosData;
import com.bean.JsonData;
import com.bean.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//处理JSON数据的类
public class Json_Utile {
	// 创建一个解析JSON数据的方法
	public static JsonData jsonData = null;
	public static HerosData herosData = null;
	public static HerosData buyherosData = null;
	// 处理JsonData 数据，传进一个字符串参数
	public static JsonData getJsonData(String json) {
		jsonData = new JsonData();
		JSONObject jsonObject = JSONObject.fromObject(json);
		jsonData.setResult(jsonObject.getBoolean("result"));
		jsonData.setCount(jsonObject.getInt("count"));
		jsonData.setMessage(jsonObject.getString("message"));
		String dataStr = jsonObject.getString("datas");
		JSONArray dataArray = JSONArray.fromObject(dataStr);
		ArrayList<User> datas = new ArrayList<>();
		for (Object object : dataArray) {
			JSONObject obj = (JSONObject) object;
			// 创建一个User对象
			User user = new User(obj.getInt("balance"), obj.getInt("id"), obj.getString("userName"),
					obj.getString("passWord"), obj.getInt("level"));
			// 把user对象装到ArrayLIst集合中
			datas.add(user);
		}
		jsonData.setDatas(datas);
		return jsonData;
	}
	
	public static HerosData getHeroData(String json){
		herosData =new HerosData();
		JSONObject heroObject = JSONObject.fromObject(json);
		herosData.setCount(heroObject.getInt("count"));
		herosData.setResult(heroObject.getString("result"));
		String dataStr = heroObject.getString("datasHero");
		JSONArray dataArray = JSONArray.fromObject(dataStr);
		ArrayList<Hero>  data= new ArrayList<>();
		for (Object object : dataArray) {
			JSONObject obje = (JSONObject) object;
			Hero hero = new Hero(obje.getInt("heroType_id"), obje.getString("typeName"), obje.getString("heroName"),
					obje.getString("heroTitle"), obje.getString("heroContry"), obje.getString("heroLines"),
					obje.getInt("heroPrice"), obje.getString("imgURL"));
			data.add(hero);
		}
		herosData.setDatasHero(data);
		return herosData;
		
	}

	// 处理Hero的JSON数据，传进一个整型数据
	public static ArrayList<Hero> getHero(int id) throws IOException {
		String heroURL = HttpUtil.URL_BASE + "getHero&user_id=" + id;
		// 获取JsonData中的集合，再获得集合中的第一个User对象的ID
		String heroJson = OkHttpUtiles.getJsonData(heroURL);
		if (heroJson.indexOf("false") == -1) {
			heroJson = heroJson.substring(54, heroJson.length() - 1);
			JSONArray dataArray = JSONArray.fromObject(heroJson);
			ArrayList<Hero> datas = new ArrayList<>();
			for (Object object : dataArray) {
				JSONObject obje = (JSONObject) object;
				Hero hero = new Hero(obje.getInt("heroType_id"), obje.getString("typeName"), obje.getString("heroName"),
						obje.getString("heroTitle"), obje.getString("heroContry"), obje.getString("heroLines"),
						obje.getInt("heroPrice"), obje.getString("imgURL"));
				datas.add(hero);
			}
			return datas;
		} else { // 该用户没有用户
			return null;
		}
	}
	public static ArrayList<Hero> buyHeros() throws IOException{
		String buyheros= HttpUtil.URL_BASE + "heros";
		String heroJson = OkHttpUtiles.getJsonData(buyheros);
		buyherosData =Json_Utile.getHeroData(heroJson);
		JSONObject heroObject = JSONObject.fromObject(buyherosData);
		herosData.setCount(heroObject.getInt("count"));
		herosData.setResult(heroObject.getString("result"));
		String dataStr = heroObject.getString("datasHero");
		JSONArray dataArray = JSONArray.fromObject(dataStr);
		ArrayList<Hero>  data= new ArrayList<>();
		for (Object object : dataArray) {
			JSONObject obje = (JSONObject) object;
			Hero hero = new Hero(obje.getInt("heroType_id"), obje.getString("typeName"), obje.getString("heroName"),
					obje.getString("heroTitle"), obje.getString("heroContry"), obje.getString("heroLines"),
					obje.getInt("heroPrice"), obje.getString("imgURL"));
			data.add(hero);
		}
		herosData.setDatasHero(data);
		return (ArrayList<Hero>) herosData.getDatasHero();
	}
}
