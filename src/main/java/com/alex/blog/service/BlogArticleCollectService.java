package com.alex.blog.service;

import com.alex.blog.base.BaseService;
import com.alex.blog.mapper.BlogArticleCollectMapper;
import com.alex.blog.model.BlogArticleCollect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文章收藏表 Service
 *
 * @author alex
 * @date 2019-09-11 20:42:23
 */
@Service("blogArticleCollectService")
public class BlogArticleCollectService extends BaseService<BlogArticleCollect> {
    private static final Logger logger = LoggerFactory.getLogger(BlogArticleCollectService.class);
    @Autowired
    private BlogArticleCollectMapper mapper;

    @Override
    public BlogArticleCollectMapper getMapper(){
        return mapper;
    }
}
