package com.edu.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.internal.TestResult;

import com.edu.freemarker.FreemarkerTemplateEngine;
import com.edu.utils.Log;
import com.edu.utils.ReadPro;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


public class ApiListener extends TestListenerAdapter{
	
	//引入FreemarkerTemplateEngine类
	FreemarkerTemplateEngine freemarkerTemplateEngine=new FreemarkerTemplateEngine();
	
	public ApiListener(){
		//调用父类的构造方法
		super();
	}
	
	private String writeResultToMail()
	{
		ITestNGMethod method[]=this.getAllTestMethods();
		List failedList=this.getFailedTests();
		List passedList=this.getPassedTests();
		List failedList1=new ArrayList();
		List passedList1=new ArrayList();		
		for(int j=0;j<failedList.size();j++)
		{
			
			ITestResult tr=(ITestResult) failedList.get(j);
			if(tr.getMethod().getDescription()!=null)
			{
				tr.setAttribute("name", tr.getMethod().getDescription());
			}
			else
			{
				tr.setAttribute("name", "");
			}
		
			failedList1.add(tr);
		}
		for(int j=0;j<passedList.size();j++)
		{
			ITestResult tr=(ITestResult) passedList.get(j);
			if(tr.getMethod().getDescription()!=null)
			{
				tr.setAttribute("name", tr.getMethod().getDescription());
			}
			else
			{
				tr.setAttribute("name", "");
			}
		
			passedList1.add(tr);
		}
		Map context=new HashMap();
    	context.put("date", new Date());
        context.put("failedList",failedList);   
        context.put("passedList",passedList1); 
        context.put("casesize",passedList.size()+failedList.size()); 
        context.put("failcasesize",failedList.size());
        try {
        	//加载模板，把context数据放入模板
        	String content=freemarkerTemplateEngine.run(context);
			return content;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String  mapToString(Map<String, Object> para) {
		
		StringBuilder  sBuilder =new StringBuilder();
		int size=para.size();
		for(Entry<String, Object> entry:para.entrySet()) {
			sBuilder.append(entry.getKey()+"="+entry.getValue()+"\n");
		}
		
	return  sBuilder.toString();
				
	}
	
	@Override
	public void onFinish(ITestContext testContext) {
	
		super.onFinish(testContext);
		if(System.getProperty("os.name").contains("dow"))
		{
			//return;
		}
		if(ReadPro.getPropValue("enable_email").equals("true"))
		{
			//邮件内容
			String emailContent=this.writeResultToMail();//模板的html网页作为邮件正文
			String emailTitle=ReadPro.getPropValue("mail_title")+"----"+this.getTime();
			String toMail=ReadPro.getPropValue("to_mail");
			try {
				if(this.getFailedTests()!=null&&this.getFailedTests().size()>0)
				{
					MailUtil.sendEmail(toMail,emailTitle, emailContent);
					Log.info("email send to "+toMail+" success");
				}else{
					MailUtil.sendEmail(ReadPro.getPropValue("success_to_mail"),emailTitle, emailContent);
					Log.info("email send to "+ReadPro.getPropValue("success_to_mail")+" success");
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				Log.fatal("email send fail :"+e.getMessage());
			}
		}
	}

	   public String getTime()
	    {
	    	java.util.Calendar c=java.util.Calendar.getInstance();    
	        java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");    
	       	return  f.format(c.getTime());    
	    }
//	  @Override
//	  public void onTestSuccess(ITestResult tr) {
//		  Log.info(tr.getInstance()+"-"+tr.getName()+"运行成功");
//	  }
//	  @Override
//	  public void onTestFailure(ITestResult tr) {
//		  
//		  Log.error(tr.getInstance()+"-"+tr.getName()+"运行失败");
//	  }

}

