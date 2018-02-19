package com.base.wang.service.impl;

import com.avaje.ebean.OrderBy;
import com.avaje.ebean.Query;
import com.avaje.ebean.jaxrs.MarshalOptions;
import com.avaje.ebean.jaxrs.UriOptions;
import com.base.wang.common.QueryParam;
import com.base.wang.service.EntityService;
import com.base.wang.util.EbeanUtil;
import com.base.wang.util.IOUtil;
import com.base.wang.util.LoggerUtil;
import com.base.wang.util.PageReturn;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("entityService")
public class EntityServiceImpl implements EntityService {
    private static LoggerUtil log= LoggerUtil.getLogger(EntityServiceImpl.class);

    protected String defaultFindAllOrderBy;
    public PageReturn findById(String uri, String id, QueryParam queryParam) {
        String className=interceptClassName(uri);
        String uriOptions=interceptUriOptions(uri);
        Class c;
        try{
            c=Class.forName("com.base.wang.model."+className);
        }catch (ClassNotFoundException e){
            throw new RuntimeException("Class not found : ["+className+"]");
        }
        Query query= EbeanUtil.find(c).setId(id);
        if (!EbeanUtil.applyUriOptions(uriOptions, query)) {
            configDefaultFindAllQuery(query);
        }
        EbeanUtil.configQueryParam(query,queryParam);
        if (defaultFindAllOrderBy != null){
            OrderBy orderBy = query.orderBy();
            if (orderBy.isEmpty()){
                query.orderBy(defaultFindAllOrderBy);
            }
        }
        List list=query.findList();
        return PageReturn.successData(list);
    }

    public PageReturn findAll(String uri, QueryParam queryParam) {
        String className=interceptClassName(uri);
        String uriOptions=interceptUriOptions(uri);
        Class c;
        try {
            c = Class.forName("com.base.wang.model."+className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class not found : ["+className+"]");
        }
        Query query = EbeanUtil.find(c);
        if (!applyUriOptions(uriOptions, query)) {
            configDefaultFindAllQuery(query);
        }
        EbeanUtil.configQueryParam(query,queryParam);
        if (defaultFindAllOrderBy != null){
            OrderBy orderBy = query.orderBy();
            if (orderBy.isEmpty()){
                query.orderBy(defaultFindAllOrderBy);
            }
        }
        int rowCount = 0;
        try{
            rowCount = query.findRowCount();
        }catch(Exception e){
            e.printStackTrace();
        }
        return PageReturn.successData(query.findList(),rowCount);
    }

    /**
     * 截取类名
     * @param uri
     * @return
     */
    private String interceptClassName(String uri){
        if(uri.contains(":")){
            return uri.substring(0,uri.indexOf(":"));
        }else{
            return uri;
        }
    }

    /**
     * 截取url参数
     * @param uri
     * @return
     */
    private String interceptUriOptions(String uri){
        if(uri.contains(":")){
            return uri.substring(uri.indexOf(":"));
        }else{
            return "";
        }
    }

    /**
     * Configure the "Find By Id" query.
     * <p>
     * This is only used when no PathProperties where set via UriOptions.
     * </p>
     * <p>
     * This effectively controls the "default" query used to render this bean.
     * </p>
     */
    protected void configDefaultFindByIdQuery(Query query) {

    }

    /**
     * Configure the "Find All" query.
     * <p>
     * This is only used when no PathProperties where set via UriOptions.
     * </p>
     * <p>
     * This effectively controls the "default" query used with the find all
     * query.
     * </p>
     */
    protected void configDefaultFindAllQuery(Query query) {

    }
    /**
     * Return true if PathProperties has been applied.
     */
    protected boolean applyUriOptions(String uriOptions, Query<?> query) {

        UriOptions options = UriOptions.parse(uriOptions);
        return applyUriOptions(options, query);
    }
    /**
     * Apply PathProperties, sort etc from UriOptions to the query.
     * <p>
     * This returns true if the PathProperties where set. In this case the
     * default query configuration should not be used.
     * </p>
     */
    protected boolean applyUriOptions(UriOptions options, Query<?> query) {

        if (!options.isEmpty()) {
            options.apply(query);
            MarshalOptions.setPathProperties(options.getPathProperties());
            return options.hasPathProperties();
        }
        return false;
    }
    private String toErrorString(Throwable e,String debug){
        if(debug.equals("Y"))return IOUtil.getErrorStackTrace(e);
        else return e.getClass().getName();
    }
}
