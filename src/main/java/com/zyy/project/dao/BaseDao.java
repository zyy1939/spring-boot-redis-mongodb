package com.zyy.project.dao;

/**
 * Created by zhaoyangyang on 2018/3/5.
 */
public class BaseDao<T> {
    /**
     * 查询所有数据集合
     */
    List<User> findAll();

    /**
     * 根据条件查询列表
     *
     * @param user
     */
    List<User> findAll(User user);

    /**
     * 根据条件分页查询列表
     *
     * @param user
     * @param pageNo
     * @param pageSize
     */
    List<User> findAll(User user, int pageNo, int pageSize);

    /**
     * 查询总数量
     *
     * @param user
     */
    Long cont(User user);

    /**
     * 根据条件查询单条数据
     *
     * @param user
     */
    User findOne(User user);

    /**
     * 插入数据
     *
     * @param user
     */
    Integer insert(User user);

    /**
     * 修改数据
     *
     * @param user
     */
    Integer update(User user);

    /**
     * 删除数据
     *
     * @param id
     */
    Integer delete(String id);
}
