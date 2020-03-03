package com.user.mapper;

import org.apache.ibatis.annotations.Param;

import com.user.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /**
     * 根据员工姓名，查询信息
     *
     * @param userName 员工姓名
     */
    User findByName(@Param("userName") String userName);
}