package org.test.recruitment.rickandmorty.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class BaseExceptionAdvice {

    private static final Logger logger = LoggerFactory.getLogger(BaseExceptionAdvice.class);

    void errorLogging(HttpServletRequest httpServletrequest, Throwable t) {
    	String msg = t.toString();
    	logger.error(msg);
        logger.error("* Exception {} Mapped to {} for {}", t.getClass(), this.getClass(), t.getMessage());
        logger.error("* Method : {}", httpServletrequest.getMethod());
        logger.error("* Request URL : {}", httpServletrequest.getRequestURL());
        logger.error("* Headers : {}", httpServletrequest.getHeaderNames());
        logger.error("* Query String : {}", httpServletrequest.getQueryString());
    }
}
