package com.alex.blog.service;

import com.alex.blog.base.BaseService;
import com.alex.blog.mapper.BlogArticleLikeMapper;
import com.alex.blog.model.BlogArticleLike;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文章点赞表 Service
 *
 * @author alex
 * @date 2019-09-11 20:42:23
 */
@Service("blogArticleLikeService")
public class BlogArticleLikeService extends BaseService<BlogArticleLike> {
    private static final Logger logger = LoggerFactory.getLogger(BlogArticleLikeService.class);
    @Autowired
    private BlogArticleLikeMapper mapper;

    @Override
    public BlogArticleLikeMapper getMapper(){
        return mapper;
    }
}
