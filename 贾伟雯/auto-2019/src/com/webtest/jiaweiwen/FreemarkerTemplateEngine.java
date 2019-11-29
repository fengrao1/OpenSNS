package com.webtest.jiaweiwen;

import java.io.File;
import java.io.StringWriter;
import java.util.Locale;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

//FreeMarker模板引擎
public class FreemarkerTemplateEngine {
	//模板路径
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
        //加载模板文件
        cfg.setDirectoryForTemplateLoading(new File(getTemplatePath())); 
        //编码方式
        cfg.setEncoding(Locale.CHINA, "UTF-8");
        // 设置模板检索数据模型的方式
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