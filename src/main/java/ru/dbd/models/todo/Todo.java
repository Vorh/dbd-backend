package ru.dbd.models.todo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vorh on 4/3/17.
 */

@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
    @Column(name = "id")
    private int id;

    @Column(name = "caption")
    private String caption;
    @Column(name = "content")
    private String content;
    @Column(name = "date")
    private Date date;
    @Column(name = "type")
    private int type;
    @Column(name = "complete")
    private boolean isComplete;


    @Column(name = "user_id")
    private int userID;


    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", caption='" + caption + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", type=" + type +
                ", isComplete=" + isComplete +
                ", userID=" + userID +
                '}';
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
