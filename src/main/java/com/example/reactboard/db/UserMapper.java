package com.example.reactboard.db;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    List<Map<String, Object>> selectUserList();

    int insertUser(Map<String, Object> param);

    Map<String, Object> selectUserDetail(Integer idx);

    int updateUser(Map<String, Object> param);

    int deleteUser(Map<String, Object> param);
}
