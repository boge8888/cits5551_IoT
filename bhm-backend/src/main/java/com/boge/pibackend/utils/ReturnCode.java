package com.boge.pibackend.utils;

public enum ReturnCode {
    //成功
    SUCCESS(200),

    //失败
    FAIL(400),

//    //错误
//    FALSE(404),

    //内部错误
    ERROR(500),

    //找不到
    NOTFOUND(404);

    private int code;

    private ReturnCode(Integer code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
