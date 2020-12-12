package com.cqie.graduation.mrms.base.handle;


import com.cqie.graduation.mrms.base.bean.Response;
import com.cqie.graduation.mrms.base.exception.CustomErrorCode;
import com.cqie.graduation.mrms.base.exception.CustomException;
import com.cqie.graduation.mrms.base.util.CommonStatic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xd
 */
@Slf4j
@Component
@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    Object handleControllerException(HttpServletRequest request, Throwable ex, Model model, HttpServletResponse response) {
        HttpStatus status = getStatus(request);
        log.error("{}", (Object[]) ex.getStackTrace());
        ex.printStackTrace();
        if (CommonStatic.ContentType.APPLICATION_JSON.equals(request.getContentType())) {
            if (ex instanceof CustomException) {
                return new Response().error((CustomException) ex);
            } else {
                return new Response().error(CustomErrorCode.SYS_ERROR);
            }
        } else {
            if (ex instanceof CustomException) {
                model.addAttribute("message", ex.getMessage());
            } else {
                model.addAttribute("message", CustomErrorCode.SYS_ERROR.getMessage());
            }
        }
        return new Response().error("hhi");
    }


    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}