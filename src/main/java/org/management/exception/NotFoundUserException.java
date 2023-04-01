package org.management.exception;

import org.management.enums.ExceptionResponse;

public class NotFoundUserException extends RuntimeException {

    public NotFoundUserException(){
        super(ExceptionResponse.STUDENT_NOT_FOUND.getMessage());
    }

}
