package com.example.reactboard.controller;

import com.example.reactboard.domain.ApiResult;
import com.example.reactboard.domain.ApiResultCode;
import com.example.reactboard.service.UserService;
import io.swagger.annotations.Api;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    //유저 리스트

    @GetMapping("/userList")
    public ResponseEntity<List<Map<String , Object>>> getUserList() {

        log.info("List 인입 : " );
        List<Map<String, Object>> userList = new ArrayList<>();

        userList = userService.selectUserList();

        log.info("userLsit : " + userList);
        if(userList != null) {
            return new ResponseEntity<>(userList , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(userList , HttpStatus.NOT_FOUND);
        }
    }

    // 회원 가입
    @PostMapping(value = "/insertUser")
    public ResponseEntity<ApiResult<Map<String , Object>>> insertUser(@RequestBody Map<String , Object> param) throws Exception {

        log.info("insert param " + param);
        if (param == null || param.isEmpty()) {
            return new ResponseEntity<>(new ApiResult<>(ApiResultCode.failed), HttpStatus.NOT_FOUND);
        }
        int insertCnt = userService.insertUser(param);

        if (insertCnt > 0) {
            return new ResponseEntity<>(new ApiResult<>(ApiResultCode.succeed, "회원 가입 성공"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResult<>(ApiResultCode.failed), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/user/{idx}")
    public ResponseEntity<Map<String,Object>> selectUserDetail (@PathVariable Integer idx)throws Exception {
        log.info("detailUserList @@");

        Map<String , Object> userDetail = new HashMap<String , Object>();

        userDetail =  userService.selectUserDetail(idx);

        if(userDetail == null || userDetail.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(userDetail , HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/user/update")
    public ResponseEntity<ApiResult<Map<String,Object>>> updateUser(@RequestParam Map<String , Object> param) throws Exception {
        log.info("update param " + param);
        if (param == null || param.isEmpty()) {
            return new ResponseEntity<>(new ApiResult<>(ApiResultCode.failed), HttpStatus.NOT_FOUND);
        }
        int resultCnt = userService.updateUser(param);

        if(resultCnt > 0) {
            return new ResponseEntity<>(new ApiResult<>(ApiResultCode.succeed) , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResult<>(ApiResultCode.failed), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ApiResult<ApiResult<Map<String, Object>>> deleteUser(@RequestParam Map<String,Object> param) throws Exception {
        log.info("delete param " + param);

        if (param == null || param.isEmpty()) {
            return new ResponseEntity<>(new ApiResult<>(ApiResultCode.failed), HttpStatus.NOT_FOUND);
        }
        int resulrcnt = userService.deleteUser(param);
        if(resulrcnt > 0) {
            return new ResponseEntity<>(new ApiResult<>(ApiResultCode.succeed) , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResult<>(ApiResultCode.failed), HttpStatus.NOT_FOUND);
        }
    }

}
