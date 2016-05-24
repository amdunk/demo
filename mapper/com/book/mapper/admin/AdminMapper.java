package com.book.mapper.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.model.admin.Admin;

public interface AdminMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    Admin selectByUsernameAndPassword(@Param("username")String username, @Param("password")String password);
}