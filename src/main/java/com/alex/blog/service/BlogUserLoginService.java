package com.alex.blog.service;

import com.alex.blog.base.BaseService;
import com.alex.blog.mapper.BlogUserLoginMapper;
import com.alex.blog.model.BlogUserLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登陆信息表 Service
 *
 * @author alex
 * @date 2019-09-11 20:42:23
 */
@Service("blogUserLoginService")
public class BlogUserLoginService extends BaseService<BlogUserLogin> {
    private static final Logger logger = LoggerFactory.getLogger(BlogUserLoginService.class);
    @Autowired
    private BlogUserLoginMapper mapper;

    @Override
    public BlogUserLoginMapper getMapper(){
        return mapper;
    }
}
