package model;

import exceptions.AttributeConstraintViolationException;
import features.EkstensjaClass;

import java.io.Serializable;
import java.time.LocalDate;

public class Comment implements Serializable {

    private String content;
    private String title;
    private LocalDate date;

    public Comment(String content, String title, LocalDate date) {
        this.setContent(content);
        this.setTitle(title);
        this.setDate(date);
        EkstensjaClass.addComment(this);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if (content == null)
            throw new AttributeConstraintViolationException("Content can not by null");
        if (content.isEmpty())
            throw new AttributeConstraintViolationException("Content can not by empty");
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null)
            throw new AttributeConstraintViolationException("Title can not by null");
        if (title.isEmpty())
            throw new AttributeConstraintViolationException("Title can not by empty");
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if (date == null)
            throw new AttributeConstraintViolationException("Date can not by null");
        this.date = date;
    }

    @Override
    public String toString() {
        return "Coment{" +
                "content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                '}';
    }
}
