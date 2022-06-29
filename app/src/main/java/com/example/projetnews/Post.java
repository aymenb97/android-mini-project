package com.example.projetnews;

public class Post
{
    private  String Title;
    private  String Content;
    public  Post(){

    }

    @Override
    public String toString() {
        return "Post{" +
                "Title='" + Title + '\'' +
                ", Content='" + Content + '\'' +
                '}';
    }

    public Post(String title, String content) {
        Title = title;
        Content = content;
    }

    public String getTitle() {
        return Title;
    }

    public String getContent() {
        return Content;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setContent(String content) {
        Content = content;
    }
}
