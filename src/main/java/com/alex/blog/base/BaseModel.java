package com.alex.blog.base;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 公共实体类
 *
 * @author alex
 * @date 2019-09-09
 */
public class BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
