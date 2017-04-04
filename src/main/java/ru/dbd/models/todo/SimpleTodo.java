package ru.dbd.models.todo;

import javax.persistence.*;

/**
 * Created by vorh on 4/3/17.
 */

@Entity
@Table(name = "todo")
public class SimpleTodo implements Todo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "caption")
    private String caption;
    @Column(name = "body")
    private String body;


    public TypeTodo getType() {
        return null;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
