package com.alex.blog.service;

import com.alex.blog.base.BaseService;
import com.alex.blog.mapper.BlogUserAttentionMapper;
import com.alex.blog.model.BlogUserAttention;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户关注信息表 Service
 *
 * @author alex
 * @date 2019-09-11 20:42:23
 */
@Service("blogUserAttentionService")
public class BlogUserAttentionService extends BaseService<BlogUserAttention> {
    private static final Logger logger = LoggerFactory.getLogger(BlogUserAttentionService.class);
    @Autowired
    private BlogUserAttentionMapper mapper;

    @Override
    public BlogUserAttentionMapper getMapper(){
        return mapper;
    }
}
