package com.alex.blog.service;

import com.alex.blog.base.BaseService;
import com.alex.blog.mapper.BlogArticleTagLinkMapper;
import com.alex.blog.model.BlogArticleTagLink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文章标签关联表 Service
 *
 * @author alex
 * @date 2019-09-11 20:42:23
 */
@Service("blogArticleTagLinkService")
public class BlogArticleTagLinkService extends BaseService<BlogArticleTagLink> {
    private static final Logger logger = LoggerFactory.getLogger(BlogArticleTagLinkService.class);
    @Autowired
    private BlogArticleTagLinkMapper mapper;

    @Override
    public BlogArticleTagLinkMapper getMapper(){
        return mapper;
    }
}
