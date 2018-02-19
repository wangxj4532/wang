package com.base.wang.controller;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/entity/{uri}")
public class EntityController {
    @Autowired
    EntityService entityService;

    public EntityController() {
    }
    @ResponseBody
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public PageReturn findById(@PathVariable("uri")String uri, @PathVariable("id") String id,QueryParam queryParam) {
        return entityService.findById(uri,id,queryParam);
    }
    @ResponseBody
    @RequestMapping(method= RequestMethod.GET)
    public PageReturn findAll( @PathVariable("uri")String uri,QueryParam queryParam) {
        return entityService.findAll(uri,queryParam);
    }

}
