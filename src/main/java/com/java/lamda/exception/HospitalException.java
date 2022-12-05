package com.java.lamda.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HospitalException extends Throwable {
    ErrorCode errorCode;
    String message;

    @Override
    public String toString() {
        if(message == null) return errorCode.getMessage();
        return String.format("%s, %s",errorCode.getMessage(), message);
    }
}
