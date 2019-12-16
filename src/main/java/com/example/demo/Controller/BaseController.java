package com.example.demo.Controller;

import com.example.demo.error.BusinessException;
import com.example.demo.error.EmBusinessError;
import com.example.demo.respones.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object exceptionHandler(HttpServletRequest request,Exception e){

        Map<String,Object> responesData = new HashMap<>();
        if (e instanceof BusinessException){
            BusinessException businessException = (BusinessException)e;
            responesData.put("ErrCode",businessException.getErrCode());
            responesData.put("ErrMsg",businessException.getErrMsg());
        }
        else {
            responesData.put("ErrCode", EmBusinessError.UNKNOW_ERROR.getErrCode());
            responesData.put("ErrMsg",EmBusinessError.UNKNOW_ERROR.getErrMsg());
        }


        return CommonReturnType.create("fail",responesData);

    }
}
