package com.sanshao.SpringBootDemo.exceptions;

import com.sanshao.SpringBootDemo.model.ResultData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class SimpleExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultData exceptionData(Exception exception) {
        ResultData resultData = new ResultData();
        resultData.setMsg(exception.getMessage());
        resultData.setData("this is exception");
        resultData.setResult(false);
        return resultData;
    }

    @ExceptionHandler(SimpleException.class)
    public ResultData simpleExceptionData(SimpleException simpleException) {
        ResultData resultData = new ResultData();
        resultData.setCode(simpleException.getCode());
        resultData.setMsg(simpleException.getMsg());
        resultData.setData("this is simpleException");
        resultData.setResult(false);
        return resultData;
    }
}
