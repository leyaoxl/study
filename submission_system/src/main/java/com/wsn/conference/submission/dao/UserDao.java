package com.wsn.conference.submission.dao;

import com.wsn.conference.submission.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author leyao
 * @version 2018-7-12
 */
@Mapper
public interface UserDao {
    void addUser(User user);

    Integer isAccountRepeated(@Param("account") String account);

    Long getUserId(@Param("account") String account);

    User getUser(User user);

    void resetPassword(User user);
}
