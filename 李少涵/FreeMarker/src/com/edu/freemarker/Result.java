package com.edu.freemarker;

import java.util.List;

//���ڴ洢���Խ��
public class Result {
	private String testName; //���Է�����
    private String className; //��������
//    private String caseName;
//    private String params; //�����ò���
//    private String description; //��������
//    private List<String> output; //Reporter Output
//    private Throwable throwable; //�����쳣ԭ��
//    private String throwableTrace;
      private int status; //״̬
      private String duration;
 
//    private boolean success;
      
      
     public Result(String testName,String className, int status,String duration) {
    	 this.testName=testName;
    	 this.className=className;
    	 this.status=status;
    	 this.duration=duration;
     }
 
    //���Է�����
    public String getTestName() {
        return testName;
    }
 
    public void setTestName(String testName) {
        this.testName = testName;
    }
 
    //��������   
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
    
 //�����ò���
//    public String getParams() {
//        return params;
//    }
// 
//    public void setParams(String params) {
//        this.params = params;
//    }
// 
    //��������
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
 
    //״̬
    public int getStatus() {
        return status;
    }
 
    public void setStatus(int status) {
        this.status = status;
    }
 
    //����ʱ��
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
