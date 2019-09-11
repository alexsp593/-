package com.alex.blog.service;

import com.alex.blog.base.BaseService;
import com.alex.blog.mapper.BlogArticleCategoryMapper;
import com.alex.blog.model.BlogArticleCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文章分类表 Service
 *
 * @author alex
 * @date 2019-09-11 20:42:23
 */
@Service("blogArticleCategoryService")
public class BlogArticleCategoryService extends BaseService<BlogArticleCategory> {
    private static final Logger logger = LoggerFactory.getLogger(BlogArticleCategoryService.class);
    @Autowired
    private BlogArticleCategoryMapper mapper;

    @Override
    public BlogArticleCategoryMapper getMapper(){
        return mapper;
    }
}
