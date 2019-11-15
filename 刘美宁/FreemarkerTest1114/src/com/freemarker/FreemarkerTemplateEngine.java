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
    	//创建一个对象，直接new一个对象，构造方法的参数是freemarker对应的版本号
    	Configuration configuration = new Configuration(Configuration.getVersion());
		// 第二步：设置模板文件所在的路径。
		configuration
				.setDirectoryForTemplateLoading(new File("conf"));
		// 第三步：设置模板文件使用的字符集。一般就是utf-8.
		configuration.setEncoding(Locale.CHINA, "UTF-8");
		// 第四步：加载一个模板，创建一个模板对象。
		Template template = configuration.getTemplate("freemarker.ftl");
		// 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map
		// 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
		Writer out = new FileWriter(new File("conf/testreport.html"));//E:\\project--three\\test
		// 第七步：调用模板对象的process方法输出文件。
		template.process(context, out);
		return out.toString();
		// 第八步：关闭流。
		//out.close();
    }   
}
   

