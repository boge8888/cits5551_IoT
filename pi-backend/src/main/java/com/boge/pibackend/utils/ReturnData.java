package com.boge.pibackend.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @description:
 * @author: RG
 * @create: 2021-04-09 12:51
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnData implements Serializable {

    private Integer userId;
    //登录是否成功，成功返回1，否则返回0
    private Integer isLoginSuccess;
    //注册是否成功，成功返回1，否则返回0
    private Integer isRegisterSuccess;
    //查询是否有用户名，有返回1，否则返回0
    private Integer hasAccountName;
    //创建是否成功，有返回1，否则返回0
    private Integer isCreateIdea;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHasAccountName() {
        return hasAccountName;
    }

    public void setHasAccountName(Integer hasAccountName) {
        this.hasAccountName = hasAccountName;
    }

    public Integer getIsLoginSuccess() {
        return isLoginSuccess;
    }

    public void setIsLoginSuccess(Integer isLoginSuccess) {
        this.isLoginSuccess = isLoginSuccess;
    }

    public Integer getIsRegisterSuccess() {
        return isRegisterSuccess;
    }

    public void setIsRegisterSuccess(Integer isRegisterSuccess) {
        this.isRegisterSuccess = isRegisterSuccess;
    }

    public Integer getIsCreateIdea() {
        return isCreateIdea;
    }

    public void setIsCreateIdea(Integer isCreateIdea) {
        this.isCreateIdea = isCreateIdea;
    }
}

