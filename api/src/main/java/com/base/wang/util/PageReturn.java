package com.base.wang.util;


import java.io.Serializable;

/**
 * 页面返回
 */
public class PageReturn implements Serializable {
    /**
     * 返回结果
     */
    private Boolean result;
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

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
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
    public static PageReturn success(){
        return multiple(true,"200","成功",null,0);
    }
    public static PageReturn success(String messageText){
        return multiple(true,"200",messageText,null,0);
    }
    public static PageReturn success(String messageCode, String messageText){
        return multiple(true,messageCode,messageText,null,0);
    }
    public static PageReturn successData(Object obj){
        return multiple(true,"200","成功",obj,1);
    }
    public static PageReturn successData(Object obj,Integer total){
        return multiple(true,"200","成功",obj,total);
    }
    public static PageReturn fail(){
        return multiple(false,"500","失败",null,0);
    }
    public static PageReturn fail(String messageText){
        return multiple(false,"500",messageText,null,0);
    }
    public static PageReturn fail(String messageCode, String messageText){
        return multiple(false,messageCode,messageText,null,0);
    }
    private static PageReturn multiple(Boolean result, String messageCode, String messageText, Object data, Integer total){
        PageReturn pageReturn=new PageReturn();
        pageReturn.result=result;
        pageReturn.messageCode=messageCode;
        pageReturn.messageText=messageText;
        pageReturn.total=total;
        pageReturn.data=data;
        return pageReturn;
    }
}
