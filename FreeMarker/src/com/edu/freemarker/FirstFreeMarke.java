package com.edu.freemarker;

 
 import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
 import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
 import java.util.HashMap;
 import java.util.Map;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
 import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
public class FirstFreeMarke {
	public String run(Map data) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
//		Map<String,String> data = new HashMap<String,String>();
//		data.put("username", "小谢");//准备数据
		
		Configuration cfg =  new Configuration();//Configuration读取模板文件
		
			cfg.setDirectoryForTemplateLoading(new File("freemarker"));//制定模板文件的目录
		    Template template = cfg.getTemplate("webpage.ftl");//Template模板
		    Writer Fwriter = new FileWriter(new File("test-output/lsh/freemarker.html"));//产生的文件
		 
		    Writer Swriter =new StringWriter();
		   	template.process(data, Fwriter);//将模板和数据产生
		 	template.process(data, Swriter);
//		   System.out.println(Swriter.toString());
		  return Swriter.toString();
		 
	}
}
