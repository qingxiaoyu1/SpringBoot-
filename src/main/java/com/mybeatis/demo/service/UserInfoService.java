package com.mybeatis.demo.service;

import com.mybeatis.demo.bean.UserInfo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: liwei
 * @Date: 2020/06/16/16:38
 * @Description:
 */
public interface UserInfoService {
    UserInfo getUserInfo(Integer id);
    Integer addUserInfo(UserInfo userInfo);
}
