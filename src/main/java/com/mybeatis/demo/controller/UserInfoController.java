package com.mybeatis.demo.controller;


import com.mybeatis.demo.bean.UserInfo;
import com.mybeatis.demo.commons.RestApiErrorResult;
import com.mybeatis.demo.commons.RestApiResult;
import com.mybeatis.demo.commons.enums.ResultCodeEnum;
import com.mybeatis.demo.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 李伟
 * @Date: 2020/06/16/15:53
 * @Description: 用户信息操作
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api("用户操作接口")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @ApiOperation(value = "新增用户  用户注册")
    @RequestMapping(value="/add",method= RequestMethod.POST)
    public RestApiResult addUserInfo(UserInfo userInfo){
        try {
            // 新增
            Integer isScuess = userInfoService.addUserInfo(userInfo);
            System.out.println(isScuess);
            if(1 == isScuess){
                return RestApiResult.createSuccessResult(userInfo);
            }else{
                return RestApiResult.createFailedResult(new RestApiErrorResult(isScuess,"新增用户失败"));
            }

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return RestApiResult.createFailedResult(new RestApiErrorResult(ResultCodeEnum.ERROR.getCode(),"系统异常"));
        }
    }

    @ApiOperation(value = "通过id获取用户", httpMethod = "GET")
    @RequestMapping(value="/get/{id}")
    public RestApiResult getUserInfo(@PathVariable("id") int id){
        System.out.println(id);
        try {
            UserInfo getUserInfo = userInfoService.getUserInfo(id);
            return RestApiResult.createSuccessResult(getUserInfo);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return RestApiResult.createFailedResult(new RestApiErrorResult(ResultCodeEnum.ERROR.getCode(),"系统异常"));
        }
    }

}
