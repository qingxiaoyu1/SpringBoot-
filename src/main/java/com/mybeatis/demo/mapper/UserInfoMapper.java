package com.mybeatis.demo.mapper;



import com.mybeatis.demo.bean.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 李伟
 * @Date: 2020/06/16/16:08
 * @Description:
 */
public interface UserInfoMapper {
    /**
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    public UserInfo getUserById(Integer id);

    /**
     * @param name
     * @return
     */
    @Select("select * from user where name=#{name}")
    public List<UserInfo> getUserByName(String name);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user(name,password) values(#{name}, #{password})")
    public int addUserInfo(UserInfo userInfo);


//    @Options(useGeneratedKeys = true,keyProperty = "id")
//    @Insert("insert into user(id,name) values(#{userInfo.getId()}, #{userInfo.getName()})")
//    public UserInfo addUserInfo(UserInfo userInfo);
}
