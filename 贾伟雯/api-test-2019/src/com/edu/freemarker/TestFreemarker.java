package com.edu.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.edu.core.ApiListener;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
@Listeners(ApiListener.class)
public class TestFreemarker{
	
	@Test
	public String freemarker1(Map data) throws IOException, TemplateException {
        Configuration conf = new Configuration();
        conf.setDirectoryForTemplateLoading(new File("flt"));
		// º”‘ÿƒ£∞Â
		Template template = conf.getTemplate("demo.ftl");
		Writer Fwrite = new FileWriter(new File("test-output/jww/freemarker.html"));
		Writer Swrite = new StringWriter();
		template.process(data, Fwrite);
		template.process(data, Swrite);
		System.out.print(Swrite.toString());
		return Swrite.toString();
	}


}
