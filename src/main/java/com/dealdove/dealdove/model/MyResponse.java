package com.dealdove.dealdove.model;

public class MyResponse {
    private String status;
    private String message;

    public MyResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getter and Setter
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message= message;
    }

}
