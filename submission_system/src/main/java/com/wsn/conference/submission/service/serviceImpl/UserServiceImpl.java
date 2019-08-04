package com.wsn.conference.submission.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.wsn.conference.submission.dao.UserDao;
import com.wsn.conference.submission.dao.UserInfoDao;
import com.wsn.conference.submission.entity.Email;
import com.wsn.conference.submission.entity.User;
import com.wsn.conference.submission.entity.UserInfo;
import com.wsn.conference.submission.service.UserService;
import com.wsn.conference.submission.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.management.relation.RoleUnresolved;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author leyao
 * @version 2018-7-12
 */
@Service
public class UserServiceImpl implements UserService {
    private Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
    private SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");

    @Value("${cookie.max.age}")
    private String cookieMaxAge;

    @Value("${cookie.path}")
    private String cookiePath;

    @Value("${host.address}")
    private String hostAddress;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    MailUtil mailUtil;

    @Autowired
    AESUtil aesUtil;

    /**
     * 用户注册
     *
     * @param account
     * @param password
     * @param prefix
     * @param username
     * @param degree
     * @param email
     * @param country
     * @param city
     * @param address
     * @param postalCode
     * @param phone
     * @return
     */
    @Override
    @Transactional
    public JSONObject register(String account, String password, String prefix, String username, String degree, String email, String country, String city, String school, String address, String postalCode, String phone) throws Exception {
        logger.info("===== start register ===== " + this.getClass().getName() + " ===== leyao =====");
        /*
        验证参数合法性
         */
        if (!PatternUtil.pattern("ACCOUNT", account))
            throw new RuntimeException("请注意用户名形式规范，以英文字母开头（大小写均可），整体由英文字母、数字和下划线（_）组成，最多64个字符");
        if (!PatternUtil.pattern("PASSWORD", password))
            throw new RuntimeException("请注意密码形式规范，整体由字母（大小写均可）和数字组合组成，8-16位");
        if (!PatternUtil.pattern("EMAIL", email))
            throw new RuntimeException("请注意邮箱形式规范");
        /*
        将参数封装进对象中
         */
        User user = new User();
        user.setAccount(account);
        user.setPassword(aesUtil.encrypt(password));
        UserInfo userInfo = new UserInfo();
        userInfo.setPrefix(prefix);
        userInfo.setUsername(username);
        if (degree != null) userInfo.setDegree(degree);
        userInfo.setEmail(email);
        userInfo.setCountry(country);
        userInfo.setCity(city);
        userInfo.setSchool(school);
        userInfo.setAddress(address);
        userInfo.setPostalCode(postalCode);
        if (postalCode != null) userInfo.setPhone(phone);

        logger.info("===== user ===== " + user + " ===== leyao =====");
        logger.info("===== userInfo ===== " + userInfo + " ===== leyao =====");

        /*
        验证邮箱是否注册过
         */
        logger.info("===== start isEmailRepeated ===== leyao =====");
        int emailCounts = userInfoDao.isEmailRepeated(userInfo.getEmail());
        logger.info("===== emailCounts ===== " + emailCounts + " ===== leyao =====");
        if (emailCounts != 0) {
            throw new RuntimeException("该邮箱已注册，请勿重复注册");
        }
        logger.info("===== end isEmailRepeated ===== leyao =====");

        /*
        验证用户名是否注册过
         */
        logger.info("===== start isAccountRepeated ===== leyao =====");
        int accountCounts = userDao.isAccountRepeated(user.getAccount());
        logger.info("===== usernameCounts ===== " + accountCounts + " ===== leyao =====");
        if (accountCounts != 0) {
            throw new RuntimeException("该用户名已注册，请勿重复注册");
        }
        logger.info("===== end isAccountRepeated ===== leyao =====");

        /*
        写入user表
         */
        logger.info("===== start addUser ===== leyao =====");
        userDao.addUser(user);
        int userCounts = userDao.isAccountRepeated(user.getAccount());
        logger.info("===== userCounts ===== " + userCounts + " ===== leyao =====");
        if (userCounts != 1) {
            throw new RuntimeException("user表写入信息数量异常，注册失败");
        }
        logger.info("===== end addUser ===== leyao =====");

        /*
        查询user_id
         */
        logger.info("===== start getUserId ===== leyao =====");
        long userId = userDao.getUserId(user.getAccount());
        logger.info("===== end getUserId ===== leyao =====");

        /*
        写入user_info表
         */
        logger.info("===== start addUserInfo ===== leyao =====");
        userInfo.setUserId(userId);
        logger.info("===== userInfo with userId ===== " + userInfo + " ===== leyao =====");
        userInfoDao.addUserInfo(userInfo);
        int userInfoCounts = userInfoDao.isEmailRepeated(userInfo.getEmail());
        logger.info("===== userInfoCounts ===== " + userInfoCounts + " ===== leyao =====");
        if (userInfoCounts != 1) {
            throw new RuntimeException("user_info表写入信息数量异常，注册失败");
        }
        logger.info("===== end addUserInfo ===== leyao =====");

        logger.info("===== end register ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "注册成功");
    }

    /**
     * 用户登录
     *
     * @param response
     * @param account
     * @param password
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject login(HttpServletResponse response, String account, String password) throws Exception {
        logger.info("===== start login ===== " + this.getClass().getName() + " ===== leyao =====");
        if (account == null || password == null) ReturnUtil.returnUtil(200, false, "账号或密码不能为空");
        User user = new User();
        user.setAccount(account);
        user.setPassword(aesUtil.encrypt(password));
        logger.info("===== user ===== " + user + " ===== leyao =====");

        /*
        验证user表account与password
         */
        User returnUser = userDao.getUser(user);
        logger.info("===== returnUser ===== " + returnUser + " ===== leyao =====");
        if (returnUser == null)
            return ReturnUtil.returnUtil(200, false, "用户名或密码错误，登录失败");

        /*
        将user_id存放至Cookie
         */
        String userId = returnUser.getId() + "";
        Cookie cookie1 = new Cookie("userId", userId);
        logger.info("===== cookie1 ===== " + cookie1 + " ===== leyao =====");
        //指定cookie可以在同一服务器内共享
        cookie1.setPath(cookiePath);
        cookie1.setMaxAge(Integer.parseInt(cookieMaxAge));
        response.addCookie(cookie1);

        /*
        将username存放至Cookie
         */
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(returnUser.getId());
        userInfo = userInfoDao.getUserInfo(userInfo);
        logger.info("===== returnUserInfo ===== " + userInfo + " ===== leyao =====");
        String username = userInfo.getUsername();
        Cookie cookie2 = new Cookie("username", username);
        logger.info("===== cookie2 ===== " + cookie2 + " ===== leyao =====");
        cookie2.setPath(cookiePath);
        cookie2.setMaxAge(Integer.parseInt(cookieMaxAge));
        response.addCookie(cookie2);

        /*
        将role存放至Cookie
         */
        String role = userInfo.getRole();
        Cookie cookie3 = new Cookie("role", role);
        logger.info("===== cookie3 ===== " + cookie3 + " ===== leyao =====");
        cookie3.setPath(cookiePath);
        cookie3.setMaxAge(Integer.parseInt(cookieMaxAge));
        response.addCookie(cookie3);
        logger.info("===== end login ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "登陆成功");
    }

    /**
     * 用户注销
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    public JSONObject logout(HttpServletRequest request, HttpServletResponse response) {
        logger.info("===== start logout ===== " + this.getClass().getName() + " ===== leyao =====");
        /*
        获取Cookie,并注销
        测试发现，每次登录返回的Cookie只有一条，故直接设置有效期为0即可
        Path必须和设置Cookie时的Path保持一致
         */
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return ReturnUtil.returnUtil(200, false, "当前无Cookie存在");
        }
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        logger.info("===== end logout ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "注销成功");
    }

    /**
     * 密码重置邮件功能
     *
     * @param email
     * @return
     */
    @Override
    public JSONObject resetEmail(String email) {
        logger.info("===== start reset email ===== " + this.getClass().getName() + " ===== leyao =====");
        /*
        获取user_info
         */
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail(email);
        logger.info("===== userInfo ===== " + userInfo + " ===== leyao =====");
        logger.info("===== userInfo ===== " + userInfo.getUserId() + " ===== leyao =====");
        userInfo = userInfoDao.getUserInfo(userInfo);
        logger.info("===== userInfo ===== " + userInfo + " ===== leyao =====");
        if (userInfo == null) return ReturnUtil.returnUtil(200, false, "该用户不存在");
        String date = sdfDate.format(new Date());
        String username = userInfo.getPrefix() + userInfo.getUsername();
        Email emailObj = new Email();
        emailObj.setReciever(email);
        emailObj.setSubject("Reset Password");
        emailObj.setTemplate("resetTemplate");
        /*
        添加freemarker数据
         */
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("date", date);
            map.put("username", username);
            map.put("email", email);
            // 填入userId
            map.put("safeUserId", aesUtil.encrypt(userInfo.getUserId() + ""));
            map.put("hostAddress", hostAddress);
            emailObj.setMailMap(map);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("userId加密异常");
        }
        try {
            mailUtil.sendTemplateMail(emailObj);
            logger.info("===== end reset email ===== " + this.getClass().getName() + " ===== leyao =====");
            return ReturnUtil.returnUtil(200, true, "重置密码邮件发送成功");
        }
        catch (Exception e) {
            return ReturnUtil.returnUtil(200, false, "重置密码邮件发送失败");
        }
    }

    /**
     * 密码重置
     *
     * @param safeUserId
     * @param password
     * @return
     */
    @Override
    @Transactional
    public JSONObject reset(String safeUserId, String password) throws Exception {
        logger.info("===== start reset ===== " + this.getClass().getName() + " ===== leyao =====");
        long userId = Long.parseLong(aesUtil.decrypt(safeUserId));
        logger.info("===== userId ===== " + userId + " ===== leyao =====");
        if (userId == -1L)
            throw new RuntimeException("重置失败，请确认您的身份信息");
        User user = new User();
        user.setId(userId);
        logger.info("===== user ===== " + user + " ===== leyao =====");
        User returnUser = userDao.getUser(user);
        logger.info("===== returnUser ===== " + returnUser + " ===== leyao =====");
        if (returnUser == null)
            throw new RuntimeException("重置失败，该用户注册信息不存在");
        user.setPassword(aesUtil.encrypt(password));
        logger.info("===== user ===== " + user + " ===== leyao =====");
        userDao.resetPassword(user);
        logger.info("===== end reset ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "密码重置成功");
    }

    @Override
    @Transactional
    public JSONObject updateUserRole(UserInfo userInfo) {
        logger.info("===== start update user role ===== " + this.getClass().getName() + " ===== leyao =====");
        if (userInfo.getUserId() == 0 || userInfo.getRole() == null)
            throw new RuntimeException("更新用户角色信息失败，请查看请求参数是否完整");

        /*
        先判断数据库里是否存在对应用户信息
         */
        UserInfo tmp = userInfoDao.getUserInfo(userInfo);
        if (tmp == null)
            throw new RuntimeException("更新用户角色信息失败，不存在此用户");

        /*
        更新用户角色信息
         */
        userInfoDao.updateUserRole(userInfo);
        logger.info("===== end update user role ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "更新用户角色信息成功");
    }

    @Override
    public JSONObject getUserInfoList(UserInfo userInfo) {
        logger.info("===== start get userInfo list ===== " + this.getClass().getName() + " ===== leyao =====");
        logger.info("===== userInfo ===== " + userInfo + " ===== leyao =====");
        if (userInfo.getRole() != null && !StringUtils.isEmpty(userInfo.getRole()))
            logger.info("===== get userInfo list for " + userInfo.getRole() + " ===== leyao =====");
        else
            logger.info("===== get userInfo list for all ===== leyao =====");
        List<UserInfo> userInfoList = userInfoDao.getUserInfoList(userInfo);
        logger.info("===== userInfo list ===== " + userInfoList + " ===== leyao =====");
        logger.info("===== end get userInfo list ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "查询用户资料成功", userInfoList);
    }

    @Override
    public JSONObject getUserInfo(UserInfo userInfo) {
        logger.info("===== start get userInfo ===== " + this.getClass().getName() + " ===== leyao =====");

        logger.info("===== userInfo ===== " + userInfo + " ===== leyao =====");
        if (userInfo == null) ReturnUtil.returnUtil(200, false, "查询失败，请确保查询条件信息完整性");

        UserInfo result = userInfoDao.getUserInfo(userInfo);

        logger.info("===== end get userInfo ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "查询成功", result);
    }
}
