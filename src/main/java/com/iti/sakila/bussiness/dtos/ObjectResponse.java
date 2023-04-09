package com.iti.sakila.bussiness.dtos;

public class ObjectResponse<T> {

    private T object;

    private Message message;

    public ObjectResponse() {
    }

    public ObjectResponse(T object, Message message) {
        this.object = object;
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ObjectResponse{" +
                "object=" + object +
                ", message=" + message +
                '}';
    }
}
