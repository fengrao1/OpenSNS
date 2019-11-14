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
//		data.put("username", "Сл");//׼������
		
		Configuration cfg =  new Configuration();//Configuration��ȡģ���ļ�
		
			cfg.setDirectoryForTemplateLoading(new File("freemarker"));//�ƶ�ģ���ļ���Ŀ¼
		    Template template = cfg.getTemplate("webpage.ftl");//Templateģ��
		    Writer Fwriter = new FileWriter(new File("test-output/lsh/freemarker.html"));//�������ļ�
		 
		    Writer Swriter =new StringWriter();
		   	template.process(data, Fwriter);//��ģ������ݲ���
		 	template.process(data, Swriter);
//		   System.out.println(Swriter.toString());
		  return Swriter.toString();
		 
	}
}
