package com.alex.blog.service;

import com.alex.blog.base.BaseService;
import com.alex.blog.mapper.BlogUserMapper;
import com.alex.blog.model.BlogUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息表 Service
 *
 * @author alex
 * @date 2019-09-11 20:42:23
 */
@Service("blogUserService")
public class BlogUserService extends BaseService<BlogUser> {
    private static final Logger logger = LoggerFactory.getLogger(BlogUserService.class);
    @Autowired
    private BlogUserMapper mapper;

    @Override
    public BlogUserMapper getMapper(){
        return mapper;
    }
}
