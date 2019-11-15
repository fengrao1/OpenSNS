package com.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkerTemplateEngine {
   
    public String run(Map context) throws Exception{   
    	return executeFreemarker(context); 
    }   
    
    private String executeFreemarker(Map context)throws Exception{  
    	//����һ������ֱ��newһ�����󣬹��췽���Ĳ�����freemarker��Ӧ�İ汾��
    	Configuration configuration = new Configuration(Configuration.getVersion());
		// �ڶ���������ģ���ļ����ڵ�·����
		configuration
				.setDirectoryForTemplateLoading(new File("conf"));
		// ������������ģ���ļ�ʹ�õ��ַ�����һ�����utf-8.
		configuration.setEncoding(Locale.CHINA, "UTF-8");
		// ���Ĳ�������һ��ģ�壬����һ��ģ�����
		Template template = configuration.getTemplate("freemarker.ftl");
		// ���岽������һ��ģ��ʹ�õ����ݼ���������pojoҲ������map��һ����Map
		// ������������һ��Writer����һ�㴴��һFileWriter����ָ�����ɵ��ļ�����
		Writer out = new FileWriter(new File("conf/testreport.html"));//E:\\project--three\\test
		// ���߲�������ģ������process��������ļ���
		template.process(context, out);
		return out.toString();
		// �ڰ˲����ر�����
		//out.close();
    }   
}
   

