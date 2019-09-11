package com.alex.blog.service;

import com.alex.blog.base.BaseService;
import com.alex.blog.mapper.BlogTagMapper;
import com.alex.blog.model.BlogTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文章标签管理表 Service
 *
 * @author alex
 * @date 2019-09-11 20:42:23
 */
@Service("blogTagService")
public class BlogTagService extends BaseService<BlogTag> {
    private static final Logger logger = LoggerFactory.getLogger(BlogTagService.class);
    @Autowired
    private BlogTagMapper mapper;

    @Override
    public BlogTagMapper getMapper(){
        return mapper;
    }
}
