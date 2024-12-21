package org.example.webhookreceiver.model;

import java.util.Map;


public class LogPayload {
    private int userId;
    private double total;
    private  String title;
    private Map<String, Object> meta;
    private boolean completed;

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId=userId;
    }

    public double getTotal(){
        return total;
    }

    public void setTotal(double total){
        this.total=total;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public Map<String,Object> getMeta(){
        return meta;
    }

    public void setMeta(Map<String,Object> meta){
        this.meta=meta;
    }

    public boolean isCompleted(){
        return completed;
    }

    public  void setCompleted(boolean completed){
        this.completed=completed;
    }

}
