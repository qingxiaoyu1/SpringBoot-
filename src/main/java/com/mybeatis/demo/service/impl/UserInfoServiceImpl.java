package com.mybeatis.demo.service.impl;

import ch.qos.logback.classic.Logger;
import com.mybeatis.demo.bean.Department;
import com.mybeatis.demo.bean.UserInfo;
import com.mybeatis.demo.mapper.DepartmentMapper;
import com.mybeatis.demo.mapper.UserInfoMapper;
import com.mybeatis.demo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: liwei
 * @Date: 2020/06/16/16:39
 * @Description:
 */
@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 通过id获取departMent信息
     * @param
     * @return
     */
    @Override
    public UserInfo getUserInfo(Integer id) {
        UserInfo userInfo = userInfoMapper.getUserById(id);
        return userInfo;
    }

    /**
     * 插入一条user信息
     * @param
     * @return 返回1才是新增用户成功 其他的全部失败
     */

    @Override
    public Integer addUserInfo(UserInfo user) {


        // 用户名查询
        try {
            List<UserInfo>  getUser = userInfoMapper.getUserByName(user.getName());
            if (0 < getUser.size() ){
                log.error("用户已存在,新增用户失败");
                return 0;
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return 0;
        }

        // 新增用户
        try {
            System.out.println(user.getName());
            System.out.println(user.getPassword());
            int isSuccess = userInfoMapper.addUserInfo(user);
            if(0 == isSuccess) {
                log.error("新增用户失败");
                return 0;
            }
        } catch (Exception e) {

            log.error("新增用户失败");
            System.out.println(11111);
            log.error(e.getMessage(),e);
            return 0;
        }
        return 1;

    }


}
