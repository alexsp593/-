package com.alex.blog.service;

import com.alex.blog.base.BaseService;
import com.alex.blog.mapper.BlogArticleCommentMapper;
import com.alex.blog.model.BlogArticleComment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文章评论表 Service
 *
 * @author alex
 * @date 2019-09-11 20:42:23
 */
@Service("blogArticleCommentService")
public class BlogArticleCommentService extends BaseService<BlogArticleComment> {
    private static final Logger logger = LoggerFactory.getLogger(BlogArticleCommentService.class);
    @Autowired
    private BlogArticleCommentMapper mapper;

    @Override
    public BlogArticleCommentMapper getMapper(){
        return mapper;
    }
}
