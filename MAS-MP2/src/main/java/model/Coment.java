package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Coment implements Serializable {

    private String content;
    private String title;
    private LocalDate date;

    public Coment(String content, String title, LocalDate date) {
        this.content = content;
        this.title = title;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
