package com.iti.sakila.bussiness.dtos;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;
@XmlRootElement
public class ListResponse<T> {
    private int page;
    private Message message;
    private List<T> items;

    public ListResponse() {
    }

    public ListResponse(int page, List<T> items, Message message) {
        this.page = page;
        this.items = items;
        this.message = message;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ListResponse{" +
                "page=" + page +
                ", items=" + items +
                ", message=" + message +
                '}';
    }
}
