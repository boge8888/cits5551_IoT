package com.boge.pibackend.service;

import com.boge.pibackend.entity.User;
import com.boge.pibackend.utils.ReturnData;

import java.util.Map;

public interface UserService {

    ReturnData verifyUserName(String accountName);
    ReturnData register(Map<String, Object> params);
    ReturnData login(Map<String, Object> params);
    ReturnData getUserDetails(Map<String, Object> params);

    User logout(Map<String, Object> params);
    ReturnData update(Map<String, Object> params);
    User setPass(Map<String, Object> params);
    User setAvatar(Map<String, Object> params);
}
