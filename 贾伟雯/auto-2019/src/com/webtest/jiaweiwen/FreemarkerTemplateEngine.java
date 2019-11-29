package com.webtest.jiaweiwen;

import java.io.File;
import java.io.StringWriter;
import java.util.Locale;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

//FreeMarkerģ������
public class FreemarkerTemplateEngine {
	//ģ��·��
	private static final String DEFAULT_TEMPLATE = "test-output/jww/demo.html";   
    public String getTemplatePath() {   
        return "";   
    }   
 
       
    public String run(Map context) throws Exception{   
    	return executeFreemarker(context); 
    }   
    
    private String executeFreemarker(Map context)throws Exception{   
    	String content="";
        Configuration cfg = new Configuration();   
        //����ģ���ļ�
        cfg.setDirectoryForTemplateLoading(new File(getTemplatePath())); 
        //���뷽ʽ
        cfg.setEncoding(Locale.CHINA, "UTF-8");
        // ����ģ���������ģ�͵ķ�ʽ
        cfg.setObjectWrapper(new DefaultObjectWrapper());              
        cfg.setCacheStorage(new freemarker.cache.MruCacheStorage(20, 250));                      
        Template temp = cfg.getTemplate(getTemplate());    
        StringWriter out = new StringWriter();   
        temp.process(context, out);   
        System.out.print(out.toString());
        return out.toString();
    }   
  
    public String getTemplate() {   
        // TODO Auto-generated method stub   
        return DEFAULT_TEMPLATE;   
    }
    
}