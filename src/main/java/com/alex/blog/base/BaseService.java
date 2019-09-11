package com.alex.blog.base;

import java.util.List;

/**
 * 公共服务层
 *
 * @author alex
 * @date 2019-09-11
 */
public abstract class BaseService<T> {
    public BaseService() {
    }

    public abstract BaseMapper<T> getMapper();

    public boolean insert(T entity) {
        return this.getMapper().save(entity);
    }

    public Integer saveBatch(List<T> entitys) {
        return this.getMapper().saveBatch(entitys);
    }

    public void update(T entity) {
        this.getMapper().update(entity);
    }

    public void updateSelective(T entity) {
        this.getMapper().updateSelective(entity);
    }

    public boolean delete(Object id) {
        return this.getMapper().delete(id);
    }

    public Integer deleteBatch(T entity) {
        return this.getMapper().deleteBatch(entity);
    }

    public boolean deleteBatchIds(Object... ids) {
        return this.getMapper().deleteBatchIds(ids);
    }

    public T queryId(Object id) {
        return this.getMapper().queryId(id);
    }


}