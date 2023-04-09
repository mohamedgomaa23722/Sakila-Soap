package com.iti.sakila.utils;

import com.iti.sakila.bussiness.dtos.ListResponse;
import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.ObjectResponse;

import java.util.List;

public class ResponseGenerator {

    public static <T> ListResponse<T> ListMapper(List<T> result, int page) {
        Message message = null;
        if (result == null) {
            message = new Message(404, "Not found", "may be you try to access items and we can't found like this item");
        } else if (result.size() == 0) {
            message = new Message(200, "There is no items returned", "There is no items on this page");
        } else {
            message = new Message(200, "ok", "found successfully");
        }
        return new ListResponse<T>(page, result, message);
    }

    public static <T> ObjectResponse<T> ObjectMapper(T result) {
        Message message = null;
        if (result == null)
            message = new Message(404, "Not found", "may be you try to access items and we can't found like this item");
        else
            message = new Message(200, "ok", "found successfully");
        return new ObjectResponse<T>(result, message);
    }

    public static Message messageResponse(boolean isDone, String operation) {
        return (isDone) ?
                new Message(200, "successfully " + operation, "") :
                new Message(500, "error happened while "+operation, "May be you Enter wrong data");
    }
}
