package com.it.controller;

import com.it.exception.BusinessException;
import com.it.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex){
        //记录日志
        //发送信息给运维
        //发送邮件给开发人员
        return new Result(ex.getCode(),null,ex.getMessage());
    }
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex){
        return new Result(ex.getCode(),null,ex.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex){
        return new Result(Code.SYSTEM_UNKNOW_ERR,null,"系统繁忙。请稍后再试");
    }
}
