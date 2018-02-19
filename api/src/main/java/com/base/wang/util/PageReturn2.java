package com.base.wang.util;


import com.avaje.ebean.Ebean;
import com.avaje.ebean.text.json.JsonContext;

/**
 * 页面返回
 */
public class PageReturn2 {
    private static JsonContext jsonContext = Ebean.createJsonContext();
    /**
     * 返回结果
     */
    private String result;
    /**
     * 编码
     */
    private String messageCode;
    /**
     * 内容
     */
    private String messageText;
    /**
     * 总记录条数
     */
    private Integer total;
    /**
     * 数据
     */
    private Object data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static PageReturn2 success(){
        return multiple("success","200","成功",null,0);
    }
    public static PageReturn2 success(String messageText){
        return multiple("success","200",messageText,null,0);
    }
    public static PageReturn2 success(String messageCode, String messageText){
        return multiple("success",messageCode,messageText,null,0);
    }
    public static String successData(Object obj){
        PageReturn2 pageReturn= multiple("success","200","成功",obj,1);
        return pageReturn.toJson();
    }
    public static String successData(Object obj,Integer total){
        PageReturn2 pageReturn= multiple("success","200","成功",obj,total);
        return pageReturn.toJson();
    }
    public static PageReturn2 fail(){
        return multiple("fail","500","失败",null,0);
    }
    public static PageReturn2 fail(String messageText){
        return multiple("fail","500",messageText,null,0);
    }
    public static PageReturn2 fail(String messageCode, String messageText){
        return multiple("fail",messageCode,messageText,null,0);
    }
    private static PageReturn2 multiple(String result, String messageCode, String messageText, Object data, Integer total){
        PageReturn2 pageReturn=new PageReturn2();
        pageReturn.result=result;
        pageReturn.messageCode=messageCode;
        pageReturn.messageText=messageText;
        pageReturn.total=total;
        pageReturn.data=data;
        return pageReturn;
    }
    public  String toJson() {
        return "{\"result\":\""+result+"\",\"messageCode\":\""+messageCode+"\",\"total\":\""+total+"\",\"messageText\":\""+messageText+"\",\"data\":"+jsonContext.toJsonString(data)+"}";
    }
}
