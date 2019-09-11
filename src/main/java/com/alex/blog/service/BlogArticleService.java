package com.alex.blog.service;

import com.alex.blog.base.BaseService;
import com.alex.blog.mapper.BlogArticleMapper;
import com.alex.blog.model.BlogArticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文章表 Service
 *
 * @author alex
 * @date 2019-09-11 20:42:22
 */
@Service("blogArticleService")
public class BlogArticleService extends BaseService<BlogArticle> {
    private static final Logger logger = LoggerFactory.getLogger(BlogArticleService.class);
    @Autowired
    private BlogArticleMapper mapper;

    @Override
    public BlogArticleMapper getMapper(){
        return mapper;
    }
}
