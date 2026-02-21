package com.portfolio.blog.api.ExceptionHandlers;

public class ErrorResponse {
    private final int status;
    private final String error;
    private final String message;

    ErrorResponse(int status, String error, String message){
        this.error = error;
        this.status = status;
        this.message = message;
    }

    public int getStatus(){ return status; }

    public String getError(){ return error; }

    public String getMessage(){ return message; }
}
