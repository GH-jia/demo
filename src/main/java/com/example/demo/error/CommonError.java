package com.example.demo.error;

public interface CommonError {
    public int getErrCode();
    public String getErrMsg();
    public CommonError setMsg(String msg);
}
