package com.wsn.conference.submission.dao;

import com.wsn.conference.submission.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author leyao
 * @version 2018-7-12
 */
@Mapper
public interface UserInfoDao {
    Integer isEmailRepeated(@Param("email") String email);

    void addUserInfo(UserInfo userInfo);

    UserInfo getUserInfo(UserInfo userInfo);

    void updateUserRole(UserInfo userInfo);

    List<UserInfo> getUserInfoList(UserInfo userInfo);
}
