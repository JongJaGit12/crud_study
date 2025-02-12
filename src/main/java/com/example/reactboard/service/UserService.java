package com.example.reactboard.service;

import com.example.reactboard.db.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public List<Map<String, Object>> selectUserList() {
        return userMapper.selectUserList();
    }

    public int insertUser(Map<String, Object> param) {
        return userMapper.insertUser(param);
    }

    public Map<String, Object> selectUserDetail(Integer idx) {
        return userMapper.selectUserDetail(idx);
    }

    public int updateUser(Map<String, Object> param) {
        return userMapper.updateUser(param);
    }

    public int deleteUser(Map<String, Object> param) {
        return userMapper.deleteUser(param);
    }
}
