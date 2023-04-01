package org.management.enums;


import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionResponse {

    STUDENT_NOT_FOUND(404, "User not found!");

    private final int code;
    private final String message;



}
