package com.java.lamda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//RestControllerAdvice 어노테이션을 달아두면 Layered아키텍처의 어떤 구간에서 발생하는 에러도 이곳에서 처리가 가능하다
public class ExceptionManager {

    //@ExceptionHandler
    //모든 에러를 RestControllerAdvice에서 다 처리하지 않아도 되기 때문에
    //모든 에러를 다 처리하면 보안 취약점이될 수도있다.
    //그렇기때문에 ExceptionHandler를 통해 특정 에러만 처리한다

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeExceptionHandler(RuntimeException e) {
        //RuntimeException이 발생하면 Controller대신에 이곳에서 리턴을 해준다
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.getMessage());
        //INTERNAL_SERVER_ERROR를 상태로 리턴하고 e.getMessage를 추가한다
    }

    @ExceptionHandler(HospitalException.class)
    public ResponseEntity<?> hospitalExceptionHandler(HospitalException h) {
        return ResponseEntity.status(h.getErrorCode().getHttpStatus())
                .body(h.getErrorCode().name() + ", " + h.getMessage());
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<?> appExceptionHandler(AppException e) {
        return ResponseEntity.status(e.getErrorCode().getHttpStatus())
                .body(e.getMessage());
    }
}
