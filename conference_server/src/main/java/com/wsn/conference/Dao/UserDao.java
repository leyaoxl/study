package com.wsn.conference.Dao;

import com.wsn.conference.Bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    //查询注册用户
    User selectRegisteredUser(String username);
    //注册用户
    boolean register(User user);
    //测试数据库连接
    User selectUser();

    //更新密码
    boolean updatePassword(@Param("username") String username,@Param("password") String password);
    //查询密码更新用户
    User selectUpdatePasswordUser(@Param("username") String username,@Param("password") String password);


}
