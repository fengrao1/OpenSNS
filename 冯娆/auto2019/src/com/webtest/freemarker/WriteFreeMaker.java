package com.webtest.freemarker;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class WriteFreeMaker {
	public static String writeFree(Map<String, Object> emailContent) throws Exception 
    {
		Configuration cfg = new Configuration();   
        cfg.setDirectoryForTemplateLoading(   
                new File("D:/eclipse/sour/auto2019/freemak/"));   
        cfg.setEncoding(Locale.CHINA, "UTF-8");
        cfg.setObjectWrapper(new DefaultObjectWrapper());              
        cfg.setCacheStorage(new freemarker.cache.MruCacheStorage(20, 250));                      
        Template temp = cfg.getTemplate("sample.ftl");    
        StringWriter out = new StringWriter();   
        temp.process(emailContent, out);   
        //System.out.print(out.toString());
        return out.toString();

//        //读取模板文件的所在目录
//        Configuration configuration = new Configuration();
//        configuration.setDirectoryForTemplateLoading(new File("D:/eclipse/sour/auto2019/freemak/"));
//        //读取模板文件
//        Template template = configuration.getTemplate("sample.ftl","utf-8");
//        //数据
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.putAll(emailContent);
//     //输出方式
//        StringWriter out = new StringWriter(); 
//        Writer out1 = new FileWriter(new File("D:\\eclipse\\sour\\auto2019\\hello.html"));
//        //将模板转换并输出
//       
//        template.process(map, out);
////        template.process(map, out1);
//        //使用了流之后，记得要关掉
//        out.close();
////        out1.close();

//        return out1.toString();
    }
}
