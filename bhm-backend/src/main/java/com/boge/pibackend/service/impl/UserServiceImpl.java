package com.boge.pibackend.service.impl;

import com.boge.pibackend.dao.UserMapper;
import com.boge.pibackend.entity.User;
import com.boge.pibackend.service.UserService;
import com.boge.pibackend.utils.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ReturnData verifyUserName(String accountName) {
        return null;
    }

    @Override
    public ReturnData register(Map<String, Object> params) {
        ReturnData ret=new ReturnData();
        ret.setIsRegisterSuccess(0);
        User user=new User();
        user.setName((String)params.get("name"));
        user.setPassword((String)params.get("password"));
//        user.setTime(new java.sql.Date(new Date().getTime()));
        int flag=userMapper.insert(user);
        if (flag==1){
            User user_after = userMapper.selectByUserName((String)params.get("name"));
            ret.setUser(user_after);
            ret.setIsRegisterSuccess(1);
            return ret;
        }else {
            return ret;
        }
    }

    @Override
    public ReturnData login(Map<String, Object> params) {
        ReturnData ret=new ReturnData();
        ret.setIsLoginSuccess(0);
        String name =(String)params.get("name");
        String password = (String)params.get("password");
//        logger.info("用户登录 : "+name);
        if(!(name.equals("")||name.equals(null)||password.equals("")||password.equals(null))) {
            User user = userMapper.selectByUserName(name);
            if (user!=null&&user.getPassword().equals(password)) {
                ret.setUser(user);
                ret.setIsLoginSuccess(1);
            }
        }
        return ret;
    }

    @Override
    public ReturnData getUserDetails(Map<String, Object> params) {
        ReturnData ret=new ReturnData();
        ret.setUser(null);

        User user = userMapper.selectByPrimaryKey(Long.valueOf(params.get("id").toString()));
        ret.setUser(user);
        // 检查两者是否有关注关系
//        if (params.get("follower")!=null&&params.get("followee")!=null){
//            ret.setIsFollow(0);
//            Long user_id1=Long.valueOf(params.get("follower").toString());
//            Long user_id2=Long.valueOf(params.get("followee").toString());
////            Follow follow=new Follow();
////            follow.setFollower(user_id1);
////            follow.setFollowee(user_id2);
////            Follow follow1 = followMapper.selectByBoth(follow);
////            if (follow1!=null){
////                ret.setIsFollow(1);
////            }
//        }
        return ret;
    }

    @Override
    public User logout(Map<String, Object> params) {
        return null;
    }

    @Override
    public ReturnData update(Map<String, Object> params) {

        ReturnData ret=new ReturnData();
        ret.setIsUpdateSuccess(0);
        User user=new User();
        user.setId(Long.valueOf(params.get("id").toString()));
        user.setName((String)params.get("name"));
        user.setPhone((String)params.get("phone"));
        user.setPassword((String)params.get("password"));
        user.setAddress((String)params.get("address"));
        user.setOrganization((String)params.get("organization"));
        user.setRole((String)params.get("role"));
        user.setAvatar((String)params.get("avatar"));
        user.setEmail1((String)params.get("email1"));
        user.setEmail2((String)params.get("email2"));
        user.setDate(new java.sql.Date(new Date().getTime()));
        user.setGender((String)params.get("gender"));
        user.setToken((String)params.get("token"));
        if(userMapper.updateByPrimaryKey(user)>0) ;{
            ret.setIsUpdateSuccess(1);
            ret.setUser(userMapper.selectByPrimaryKey(Long.valueOf(params.get("user_id").toString())));
        }
        return ret;
    }

    @Override
    public User setPass(Map<String, Object> params) {
        return null;
    }

    @Override
    public User setAvatar(Map<String, Object> params) {
        return null;
    }
}
