package com.iti.sakila.bussiness.dtos;

public class Message {
    private int code;
    private String message;
    private String messageDesc;

    public Message() {
    }

    public Message(int code, String message, String messageDesc) {
        this.code = code;
        this.message = message;
        this.messageDesc = messageDesc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageDesc() {
        return messageDesc;
    }

    public void setMessageDesc(String messageDesc) {
        this.messageDesc = messageDesc;
    }

    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", messageDesc='" + messageDesc + '\'' +
                '}';
    }
}
