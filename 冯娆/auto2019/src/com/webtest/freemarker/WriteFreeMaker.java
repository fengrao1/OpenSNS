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

//        //��ȡģ���ļ�������Ŀ¼
//        Configuration configuration = new Configuration();
//        configuration.setDirectoryForTemplateLoading(new File("D:/eclipse/sour/auto2019/freemak/"));
//        //��ȡģ���ļ�
//        Template template = configuration.getTemplate("sample.ftl","utf-8");
//        //����
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.putAll(emailContent);
//     //�����ʽ
//        StringWriter out = new StringWriter(); 
//        Writer out1 = new FileWriter(new File("D:\\eclipse\\sour\\auto2019\\hello.html"));
//        //��ģ��ת�������
//       
//        template.process(map, out);
////        template.process(map, out1);
//        //ʹ������֮�󣬼ǵ�Ҫ�ص�
//        out.close();
////        out1.close();

//        return out1.toString();
    }
}
