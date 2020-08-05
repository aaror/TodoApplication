package com.symb.task.todo;

public class Todo_task {
   private long Id;
    private String content;
    private String date;


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    Todo_task(){  }
    Todo_task(String content , String date){
    this.content=content;
    this.date=date;

    }
    Todo_task(long id,String content , String date){
        this.Id=id;
        this.content=content;
        this.date=date;

    }


}


