package com.zyy.project.dao;

import java.util.List;

/**
 * Created by zhaoyangyang on 2018/3/5.
 */
public interface BaseDao<T> {
    /**
     * 查询所有数据集合
     */
    List<T> findAll();

    /**
     * 根据id查询
     */
    T findById(String id);

    /**
     * 插入数据
     */
    void insert(T t);

    /**
     * 修改数据
     */
    void update(T t);

    /**
     * 删除数据
     */
    void delete(String id);
}
