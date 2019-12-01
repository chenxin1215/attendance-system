package com.attendance.dao;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Mapper公共基类，自动生成请勿修改
 * @param <Model> 数据库表对应的实体类
 * @param <PK> 主键类型
 */
public interface BaseMapper<Model, PK extends Serializable> {
    /**
     * 根据主键删除数据
     */
    int deleteByPrimaryKey(PK id);

    /**
     * 插入数据<br>
     * record中为null的值将在数据库中被明确的设置为null
     */
    int insert(Model record);

    /**
     * 插入数据<br>
     * record中为null的值将被忽略，不在insert语句中出现
     */
    int insertSelective(Model record);

    /**
     * 根据主键查询数据
     */
    Model selectByPrimaryKey(PK id);

    /**
     * 根据主键更新数据<br>
     * 仅更新有值的列<br>
     * record中为null的值将被忽略，不在update语句中出现，不做修改
     */
    int updateByPrimaryKeySelective(Model record);

    int updateByPrimaryKey(Model record);
}