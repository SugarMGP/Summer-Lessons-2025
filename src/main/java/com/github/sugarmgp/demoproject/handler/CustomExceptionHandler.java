package com.github.sugarmgp.demoproject.handler;

import com.github.sugarmgp.demoproject.exception.ApiException;
import com.github.sugarmgp.demoproject.result.AjaxResult;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author SugarMGP
 */
@ControllerAdvice
@Order(50)
public class CustomExceptionHandler {
    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public AjaxResult<Object> handleApiException(ApiException e) {
        return AjaxResult.fail(e.getErrorCode(), e.getErrorMsg());
    }
}
