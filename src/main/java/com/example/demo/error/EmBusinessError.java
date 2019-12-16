package com.example.demo.error;

public enum EmBusinessError implements CommonError {
    COMMON_ERROR(10001,"common"),
    UNKNOW_ERROR(10002,"unknow")
    ;

    private int errCode;
    private String errMsg;

    EmBusinessError(int errCode,String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }


    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setMsg(String msg) {
        this.errMsg = msg;
        return this;
    }
}
