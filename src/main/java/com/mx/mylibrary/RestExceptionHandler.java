package com.mx.mylibrary;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.IOException;

@ControllerAdvice
public class RestExceptionHandler {

    @Autowired
    ErrorAttributes errorAttributes;

    /* 400 (Bad Request) */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<MessageExceptionHandler> bindException(BindException ex, WebRequest webRequest) {
        MessageExceptionHandler response = new MessageExceptionHandler();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setMessage(ex.getMessage());
        response.setAttributes(errorAttributes.getErrorAttributes(webRequest,true));
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<MessageExceptionHandler> httpMessageNotReadableException(HttpMessageNotReadableException ex, WebRequest webRequest) {
        MessageExceptionHandler response = new MessageExceptionHandler();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setMessage(ex.getMessage());
        response.setAttributes(errorAttributes.getErrorAttributes(webRequest,true));
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageExceptionHandler> methodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest webRequest) {
        MessageExceptionHandler response = new MessageExceptionHandler();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setMessage(ex.getMessage());
        response.setAttributes(errorAttributes.getErrorAttributes(webRequest,true));
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<MessageExceptionHandler> missingServletRequestParameterException(MissingServletRequestParameterException ex, WebRequest webRequest) {
        MessageExceptionHandler response = new MessageExceptionHandler();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setMessage(ex.getMessage());
        response.setAttributes(errorAttributes.getErrorAttributes(webRequest,true));
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestPartException.class)
    public ResponseEntity<MessageExceptionHandler> missingServletRequestParameterException(MissingServletRequestPartException ex, WebRequest webRequest) {
        MessageExceptionHandler response = new MessageExceptionHandler();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setMessage(ex.getMessage());
        response.setAttributes(errorAttributes.getErrorAttributes(webRequest,true));
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TypeMismatchException.class)
    public ResponseEntity<MessageExceptionHandler> typeMismatchException(TypeMismatchException ex, WebRequest webRequest) {
        MessageExceptionHandler response = new MessageExceptionHandler();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setMessage(ex.getMessage());
        response.setAttributes(errorAttributes.getErrorAttributes(webRequest,true));
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServletRequestBindingException.class)
    public ResponseEntity<MessageExceptionHandler> servletRequestBindingException(ServletRequestBindingException ex, WebRequest webRequest) {
        MessageExceptionHandler response = new MessageExceptionHandler();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setMessage(ex.getMessage());
        response.setAttributes(errorAttributes.getErrorAttributes(webRequest,true));
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
    /* 400 (Bad Request) */

    /* 405 (Method Not Allowed) */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<MessageExceptionHandler> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex, WebRequest webRequest) {
       MessageExceptionHandler response = new MessageExceptionHandler();
       response.setCode(HttpStatus.METHOD_NOT_ALLOWED.value());
       response.setMessage(ex.getMessage());
       response.setAttributes(errorAttributes.getErrorAttributes(webRequest,true));
       return new ResponseEntity<>(response,HttpStatus.METHOD_NOT_ALLOWED);
    }
    /* 405 (Method Not Allowed) */

    /* 406 (Not Acceptable) */
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<MessageExceptionHandler> httpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException ex, WebRequest webRequest) {
        MessageExceptionHandler response = new MessageExceptionHandler();
        response.setCode(HttpStatus.NOT_ACCEPTABLE.value());
        response.setMessage(ex.getMessage());
        response.setAttributes(errorAttributes.getErrorAttributes(webRequest,true));
        return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
    }
    /* 406 (Not Acceptable) */

    /* 415 (Unsupported Media Type) */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<MessageExceptionHandler> httpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex, WebRequest webRequest) {
        MessageExceptionHandler response = new MessageExceptionHandler();
        response.setCode(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
        response.setMessage(ex.getMessage());
        response.setAttributes(errorAttributes.getErrorAttributes(webRequest,true));
        return new ResponseEntity<>(response,HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }
    /* 415 (Unsupported Media Type) */

    /* 500 (Internal Server Error) */
    @ExceptionHandler(ConversionNotSupportedException.class)
    public ResponseEntity<MessageExceptionHandler> conversionNotSupportedException(ConversionNotSupportedException ex, WebRequest webRequest) {
        MessageExceptionHandler response = new MessageExceptionHandler();
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage(ex.getMessage());
        response.setAttributes(errorAttributes.getErrorAttributes(webRequest,true));
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMessageNotWritableException.class)
    public ResponseEntity<MessageExceptionHandler> httpMessageNotWritableException(HttpMessageNotWritableException ex, WebRequest webRequest) {
        MessageExceptionHandler response = new MessageExceptionHandler();
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage(ex.getMessage());
        response.setAttributes(errorAttributes.getErrorAttributes(webRequest,true));
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<MessageExceptionHandler> missingPathVariableException(MissingPathVariableException ex, WebRequest webRequest) {
        MessageExceptionHandler response = new MessageExceptionHandler();
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage(ex.getMessage());
        response.setAttributes(errorAttributes.getErrorAttributes(webRequest,true));
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<MessageExceptionHandler> runtimeException(RuntimeException ex, WebRequest webRequest) {
        MessageExceptionHandler response = new MessageExceptionHandler();
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage(ex.getMessage());
        response.setAttributes(errorAttributes.getErrorAttributes(webRequest,true));
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageExceptionHandler> exception(Exception ex, WebRequest webRequest) {
        MessageExceptionHandler response = new MessageExceptionHandler();
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage(ex.getMessage());
        response.setAttributes(errorAttributes.getErrorAttributes(webRequest,true));
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    /* 500 (Internal Server Error) */

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MessageExceptionHandler> noHandlerFoundException(NoHandlerFoundException ex, WebRequest webRequest) {
        MessageExceptionHandler response = new MessageExceptionHandler();
        response.setCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(ex.getMessage());
        response.setAttributes(errorAttributes.getErrorAttributes(webRequest,true));
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AsyncRequestTimeoutException.class)
    public ResponseEntity<MessageExceptionHandler> asyncRequestTimeoutException(AsyncRequestTimeoutException ex, WebRequest webRequest) {
        MessageExceptionHandler response = new MessageExceptionHandler();
        response.setCode(HttpStatus.SERVICE_UNAVAILABLE.value());
        response.setMessage(ex.getMessage());
        response.setAttributes(errorAttributes.getErrorAttributes(webRequest,true));
        return new ResponseEntity<>(response,HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<MessageExceptionHandler> ioexception(IOException ex, WebRequest webRequest) {
        MessageExceptionHandler response = new MessageExceptionHandler();
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage(ex.getMessage());
        response.setAttributes(errorAttributes.getErrorAttributes(webRequest,true));
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<MessageExceptionHandler> customException(CustomException ex, WebRequest webRequest) {
        MessageExceptionHandler response = new MessageExceptionHandler();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setMessage(ex.getMessage());
        response.setAttributes(errorAttributes.getErrorAttributes(webRequest,true));
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> customNotFoundException(CustomNotFoundException ex, WebRequest webRequest) {
        MessageExceptionHandler response = new MessageExceptionHandler();
        response.setCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(ex.getMessage());
        response.setAttributes(errorAttributes.getErrorAttributes(webRequest,true));
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
