package ru.dbd.models.todo;

/**
 * Created by vorh on 4/3/17.
 */
public enum  TypeTodo {
    NONE(0),
    SIMPLE(1),
    TIME(2);

    private int id;

    TypeTodo(int i) {
        id = i;
    }

    public static TypeTodo getEnum(int id){
        for (TypeTodo typeTodo : values()) {
            if (id == typeTodo.getId()){
                return typeTodo;
            }
        }
        throw new IllegalArgumentException("Enum not found");
    }

    public int getId() {
        return id;
    }
}
