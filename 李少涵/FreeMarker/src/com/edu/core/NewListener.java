package com.edu.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.edu.core.MailUtil;
import com.edu.freemarker.FirstFreeMarke;
import com.edu.freemarker.Result;
import com.edu.utils.Log;
import com.edu.utils.ReadPro;

import freemarker.template.Configuration;

import com.edu.utils.ReadPro;

public class NewListener extends TestListenerAdapter {


		FirstFreeMarke ft=new FirstFreeMarke();
		public NewListener() {
			super();
		}
		private String writeResultToMail()
		{
			ITestNGMethod method[]=this.getAllTestMethods();//得到所有运行的方法
			List failedList=this.getFailedTests();//运行失败的方法
			List passedList=this.getPassedTests();//运行成功的方法
			List failedList1=new ArrayList();
			List passedList1=new ArrayList();
			String duration;
			//-----------------------------------------------------------------------
			Map data =new HashMap<>();
			List<Result>resultList =new ArrayList<>();	
			for(int j=0;j<failedList.size();j++)//循环运行失败的方法
			{
				ITestResult tr=(ITestResult) failedList.get(j);			
				duration=tr.getEndMillis()-tr.getStartMillis()+"";
				//
				
				resultList.add(new Result(tr.getTestClass().getName(),tr.getName(),2,duration));
				//
			}
			for(int j=0;j<passedList.size();j++)
			{
				ITestResult tr=(ITestResult) passedList.get(j);	
				duration=tr.getEndMillis()-tr.getStartMillis()+"";
				passedList1.add(tr);
				System.out.println(tr.getName());
				System.out.println(tr.getTestClass().getName());
				//
				resultList.add(new Result(tr.getTestClass().getName(),tr.getName(),1,duration));
				//
			}
			

			
			data.put("resultList", resultList);
			data.put("date", new Date().toString());
			data.put("failedList",failedList);   
			data.put("passedList",passedList1); 
			data.put("casesize",passedList.size()+failedList.size()); 
			data.put("failedcasesize",failedList.size());
			data.put("passedcasesize",passedList.size());


	        try {
	        	String datas =ft.run(data);
//	        	System.out.println(datas);
				return datas;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		public void onFinish(ITestContext testContext){
			// TODO Auto-generated method stub
			super.onFinish(testContext);
			if(System.getProperty("os.name").contains("dow"))
			{
				//return;
			}
			if(ReadPro.getPropValue("enable_email").equals("true"))
			{
				String emailContent=this.writeResultToMail();
				String emailTitle=ReadPro.getPropValue("mail_title")+"----"+this.getTime();
				String toMail=ReadPro.getPropValue("to_mail");
				try {
					if(this.getFailedTests()!=null&&this.getFailedTests().size()>0)
					{
						MailUtil.sendEmail(toMail,emailTitle, emailContent);
						Log.info("email send to "+toMail+" success");
					}else
					{
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
//		  @Override
//		  public void onTestSuccess(ITestResult tr) {
//			  Log.info(tr.getInstance()+"-"+tr.getName()+"运行成功");
//		  }
//		  @Override
//		  public void onTestFailure(ITestResult tr) {
//			  
//			  Log.error(tr.getInstance()+"-"+tr.getName()+"运行失败");
//		  }

	

}
