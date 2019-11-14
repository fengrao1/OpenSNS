package com.edu.freemarker;

import java.util.List;

//用于存储测试结果
public class Result {
	private String testName; //测试方法名
    private String className; //测试类名
//    private String caseName;
//    private String params; //测试用参数
//    private String description; //测试描述
//    private List<String> output; //Reporter Output
//    private Throwable throwable; //测试异常原因
//    private String throwableTrace;
      private int status; //状态
      private String duration;
 
//    private boolean success;
      
      
     public Result(String testName,String className, int status,String duration) {
    	 this.testName=testName;
    	 this.className=className;
    	 this.status=status;
    	 this.duration=duration;
     }
 
    //测试方法名
    public String getTestName() {
        return testName;
    }
 
    public void setTestName(String testName) {
        this.testName = testName;
    }
 
    //测试类名   
    public String getClassName() {
        return className;
    }
 
    public void setClassName(String className) {
        this.className = className;
    }
 
    //
//    public String getCaseName() {
//        return caseName;
//    }
// 
//    public void setCaseName(String caseName) {
//        this.caseName = caseName;
//    }
    
 //测试用参数
//    public String getParams() {
//        return params;
//    }
// 
//    public void setParams(String params) {
//        this.params = params;
//    }
// 
    //测试描述
//    public String getDescription() {
//        return description;
//    }
// 
//    public void setDescription(String description) {
//        this.description = description;
//    }
 
    //
//    public List<String> getOutput() {
//        return output;
//    }
// 
//    public void setOutput(List<String> output) {
//        this.output = output;
//    }
 
    //
//    public Throwable getThrowable() {
//        return throwable;
//    }
// 
//    public void setThrowable(Throwable throwable) {
//        this.throwable = throwable;
//        this.throwableTrace = ExceptionUtil.getStackTrace(throwable);
//    }
 
    //状态
    public int getStatus() {
        return status;
    }
 
    public void setStatus(int status) {
        this.status = status;
    }
 
    //运行时间
    public String getDuration() {
        return duration;
    }
 
    public void setDuration(String duration) {
        this.duration = duration;
    }
 
//    public boolean isSuccess() {
//        return success;
//    }
// 
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
 
//    public String getThrowableTrace() {
//        return throwableTrace;
//    }
// 
//    public void setThrowableTrace(String throwableTrace) {
//        this.throwableTrace = throwableTrace;
//    }
}
