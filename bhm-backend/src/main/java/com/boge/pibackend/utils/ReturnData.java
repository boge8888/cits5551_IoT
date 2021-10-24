package com.boge.pibackend.utils;

import com.boge.pibackend.entity.*;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: BG
 * @create: 2021-04-09 12:51
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnData implements Serializable {

    private Long userId;
    //If the login is successful, 1 will be returned; otherwise, 0 will be returned
    //登录是否成功，成功返回1，否则返回0
    private Integer isLoginSuccess;
    //注册是否成功，成功返回1，否则返回0
    private Integer isRegisterSuccess;
    //删除是否成功，成功返回1，否则返回0
    private Integer isDeleteSuccess;
    //查询是否有用户名，有返回1，否则返回0
    private Integer hasAccountName;
    //创建是否成功，成功返回1，否则返回0
    private Integer isCreateSuccess;
    //更新是否成功，有返回1，否则返回0
    private Integer isUpdateSuccess;
    //是否有关注，有返回1，否则返回0
    private Integer isFollow;
    //邮件是否发送成功，有返回1，否则返回0
    private Integer isSend;
    //用户信息
    private User user;
    //创意列表
    private List<User> users;
    private List<Algorithm> algorithms;
    private List<Bridge> bridges;
    private List<Data> data;
    private List<Bridgetowerdata> bridgetowerdata;
    private List<Bridgecabledata> bridgecabledata;
    private List<Device> devices;
    private List<Log> logs;
//    //创意列表
//    private List<Idea> ideas;

    public List<Algorithm> getAlgorithms() {
        return algorithms;
    }

    public void setAlgorithms(List<Algorithm> algorithms) {
        this.algorithms = algorithms;
    }

    public List<Bridge> getBridges() {
        return bridges;
    }

    public void setBridges(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public List<Bridgetowerdata> getBridgetowerdata() { return bridgetowerdata; }

    public void setBridgetowerdata(List<Bridgetowerdata> bridgetowerdata) { this.bridgetowerdata = bridgetowerdata; }

    public List<Bridgecabledata> getBridgecabledata() { return bridgecabledata; }

    public void setBridgecabledata(List<Bridgecabledata> bridgecabledata) { this.bridgecabledata = bridgecabledata; }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public Integer getIsCreateSuccess() {
        return isCreateSuccess;
    }

    public void setIsCreateSuccess(Integer isCreateSuccess) {
        this.isCreateSuccess = isCreateSuccess;
    }

    public Integer getIsUpdateSuccess() {
        return isUpdateSuccess;
    }

    public void setIsUpdateSuccess(Integer isUpdateSuccess) {
        this.isUpdateSuccess = isUpdateSuccess;
    }

    public Integer getIsDeleteSuccess() {
        return isDeleteSuccess;
    }

    public void setIsDeleteSuccess(Integer isDeleteSuccess) {
        this.isDeleteSuccess = isDeleteSuccess;
    }

    public Integer getIsFollow() {
        return isFollow;
    }

    public void setIsFollow(Integer isFollow) {
        this.isFollow = isFollow;
    }

    public Integer getIsSend() { return isSend; }

    public void setIsSend(Integer isSend) { this.isSend = isSend; }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

