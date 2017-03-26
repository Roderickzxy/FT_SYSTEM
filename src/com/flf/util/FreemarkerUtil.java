package com.flf.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import freemarker.template.Configuration;
//import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
//使用流程
////1.创建数据模型
//Map<String,Object> root=new HashMap<String,Object>();
////2.为数据模型添加值
//root.put("username", "joie");
////3.将数据模型和模板组合的数据添加到控制台
//fu.print("01.ftl",root);
//fu.fprint("02.ftl", root, "02.html");
public class FreemarkerUtil {
	static String  encoding="UTF-8";
	public static Template getTemplate(String name, String basePath) {
		try {
			Configuration cfg = new Configuration();
//			cfg.setObjectWrapper(new DefaultObjectWrapper());
			cfg.setDefaultEncoding(encoding);
			// 设置去哪里找模板文件
			// cfg.setClassForTemplateLoading(this.getClass(), basePath);
			System.out.println("basePath=" + basePath);
			cfg.setDirectoryForTemplateLoading(new File(basePath));
			
			// 在模板文件中找名称为name的文件
			Template temp = cfg.getTemplate(name);
			temp.setEncoding(encoding);
			return temp;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
/**
 * 打印创建文件内容
 * @param name
 * @param root
 * @param bathPath
 */
	public static void print(String name, Map<String, Object> root, String bathPath) {
		// 通过Template 可以将模板文件输出到相应的流
		Template temp = FreemarkerUtil.getTemplate(name, bathPath);
		try {
			temp.process(root, new PrintWriter(System.out));
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
 * 创建文件，保存至指定目录
 * @param ftlName 模板文件名
 * @param root 模板存入对象
 * @param FilePath 创建文件路径
 * @param bathFtlPath 模板文件路径
 */
	public static void fprint(String ftlName, Map<String, Object> root,
			String FilePath, String bathFtlPath) {
		FileWriter out = null;
		try {
			File targetFile = new File(FilePath);
			// 文件路径不存在就创建
			if (!targetFile.getParentFile().exists()) {
				targetFile.getParentFile().mkdirs();
			}
			out = new FileWriter(targetFile);
			Template temp = FreemarkerUtil.getTemplate(ftlName, bathFtlPath);
			temp.setEncoding(encoding);
			temp.process(root, out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	/**
	 * 获取classes目录下的模板文件
	 * @param name
	 * @param basePath
	 * @return
	 */
	public static Template getClassTemplate(String name) {
		try {
			Configuration cfg = new Configuration();
			cfg.setClassForTemplateLoading(FreemarkerUtil.class, "/");
			cfg.setDefaultEncoding(encoding);
			
			Template temp = cfg.getTemplate(name);
			temp.setEncoding(encoding);
			return temp;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 创建文件，保存至指定目录
	 * @param ftlName 模板文件名 "/aa/aa.ftl"
	 * @param root 模板存入对象	 root.put("username", "joie");
	 * @param FilePath 创建文件路径  c:/.../webapps/aa/upload/a.html
	 */
		public static void fprintByClassName(String ftlName, Map<String, Object> root,
				String FilePath) {
			FileWriter out = null;
			try {
				File targetFile = new File(FilePath);
				// 文件路径不存在就创建
				if (!targetFile.getParentFile().exists()) {
					targetFile.getParentFile().mkdirs();
				}
				out = new FileWriter(targetFile);
				Template temp = FreemarkerUtil.getClassTemplate(ftlName);
				temp.setEncoding(encoding);
				temp.process(root, out);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TemplateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (null != out) {
					try {
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	
	
	
}
