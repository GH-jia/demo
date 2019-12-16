package com.example.demo.error;

public class BusinessException extends Exception implements CommonError {

    private CommonError commonError;

    public BusinessException(CommonError commonError){
        super();
        this.commonError = commonError;
    }

    public BusinessException(CommonError commonError,String msg){
        super();
        this.commonError = commonError;
        this.commonError.setMsg(msg);
    }
    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setMsg(String msg) {
        this.commonError.setMsg(msg);
        return this;
    }
}
