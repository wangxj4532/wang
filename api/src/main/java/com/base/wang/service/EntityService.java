package com.base.wang.service;

import com.base.wang.common.QueryParam;
import com.base.wang.util.PageReturn;

public interface EntityService {
    PageReturn findById(String uri, String id, QueryParam queryParam);
    PageReturn findAll(String uri,QueryParam queryParam);
}
