package com.alex.blog.base;

import java.util.List;

/**
 * 公共数据层
 *
 * @author alex
 * @date 2019-09-09
 */
public interface BaseMapper<T> {

    /**
     * 保存记录
     *
     * @param var1
     * @return
     */
    boolean save(T var1);

    /**
     * 批量保存记录
     *
     * @param var1
     * @return
     */
    Integer saveBatch(List<T> var1);

    /**
     * 修改记录
     *
     * @param var1
     * @return
     */
    Integer update(T var1);

    /**
     * 修改记录，只修改只不为空的字段
     *
     * @param var1
     * @return
     */
    Integer updateSelective(T var1);

    /**
     * 删除记录
     *
     * @param var1
     * @return
     */
    boolean delete(Object var1);

    /**
     * 按id批量删除记录
     *
     * @param var1
     * @return
     */
    boolean deleteBatchIds(Object[] var1);

    /**
     * 按条件批量删除记录
     *
     * @param var1
     * @return
     */
    Integer deleteBatch(T var1);

    /**
     * 通过Id获取记录
     *
     * @param var1
     * @return
     */
    T queryId(Object var1);

}
