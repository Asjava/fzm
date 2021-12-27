package com.fxs.fzm.security.controller.globalExceptionHandler;

import com.fxs.fzm.common.base.exception.ImageCodeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Title: 全局异常处理类
 * Description:
 * Copyright: Copyright (c) 2020-09-17
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
@ControllerAdvice
public class GlobalExceptionHandler {


//    @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ResultModel> exceptionHandler(Exception e)
//    {
//        e.printStackTrace();
//        ResultModel resultModel = new ResultModel(2,"系统出小差了，让网站管理员来处理吧 ಥ_ಥ");
//        return new ResponseEntity<>(resultModel, HttpStatus.OK);
//    }

    @ResponseBody
    @ExceptionHandler(ImageCodeException.class)
    public String exceptionHandler(ImageCodeException e)
    {
        e.printStackTrace();
        return "错误验证码";
    }
}
