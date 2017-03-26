package com.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import codeGenerate.def.FtlDef;
import codeGenerate.factory.CodeGenerateFactory;
/**
 * 
 * @author lintu5.com
 *
 */

public class CodeUtil {

	public static void main(String[] args) {

		config();
	
	}

	private static void config() {
		
		/** 此处修改成你的 表名 和 中文注释***/
		 String keyType = FtlDef.KEY_TYPE_02;//主键生成方式 01:UUID  02:自增
		 List<Map<String,String>> list = new ArrayList<Map<String,String>>();
//		 //商圈
//		 Map<String,String> map1 = new HashMap<String,String>();
//		 map1.put("tableName", "tb_business_district");//英文表名
//		 map1.put("codeName", "商圈");//中文注释  当然你用英文也是可以的 
//		 map1.put("entityPackage", "BusinessDistrict");//实体包
//		 map1.put("keyType", keyType);
//		 list.add(map1);
//		 
//		 //镇街
//		 Map<String,String> map2 = new HashMap<String,String>();
//		 map2.put("tableName", "tb_street");//英文表名
//		 map2.put("codeName", "镇街");//中文注释  当然你用英文也是可以的 
//		 map2.put("entityPackage", "Street");//实体包
//		 map2.put("keyType", keyType);
//		 list.add(map2);
//		 
//		 //房源
//		 Map<String,String> map3 = new HashMap<String,String>();
//		 map3.put("tableName", "tb_house_resource");//英文表名
//		 map3.put("codeName", "房源");//中文注释  当然你用英文也是可以的 
//		 map3.put("entityPackage", "HouseResource");//实体包
//		 map3.put("keyType", keyType);
//		 list.add(map3);
		 
		 //后续在这里添加表
//		 //群发信息
//		 Map<String,String> map4 = new HashMap<String,String>();
//		 map4.put("tableName", "tb_group_msg");//英文表名
//		 map4.put("codeName", "群发信息");//中文注释  当然你用英文也是可以的 
//		 map4.put("entityPackage", "GroupMsg");//实体包
//		 map4.put("keyType", keyType);
//		 list.add(map4);
//		 //图文消息
		 Map<String,String> map5 = new HashMap<String,String>();
		 map5.put("tableName", "tb_customerproperty");//英文表名
		 map5.put("codeName", "客户业务设置");//中文注释  当然你用英文也是可以的 
		 map5.put("entityPackage", "Customerproperty");//实体包
		 map5.put("keyType", keyType);
		 list.add(map5);
		 
		 //遍历生成代码
		 for(Map<String,String> map : list){
			 CodeGenerateFactory.codeGenerate(map.get("tableName"), 
					 map.get("codeName"), 
					 map.get("entityPackage"),
					 map.get("keyType"));
		 }
	}
	
	/*private static void config2() {
		//此处修改成你的 表名 和 中文注释
		 String tableName="tb_business_district"; //
		 String codeName ="商圈";//中文注释  当然你用英文也是可以的 
		 String entityPackage ="BusinessDistrict";//实体包
		 String keyType = FtlDef.KEY_TYPE_02;//主键生成方式 01:UUID  02:自增
		 
		CodeGenerateFactory.codeGenerate(tableName, 
				codeName, 
				entityPackage,
				keyType);
	}*/
}
