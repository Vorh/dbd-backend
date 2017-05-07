package ru.dbd.dao.todo;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import ru.dbd.dao.AbstractDao;
import ru.dbd.models.todo.Todo;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by vorh on 4/3/17.
 */

@SuppressWarnings("JpaQlInspection")
@Repository
@Transactional
public class TodoDaoBasic extends AbstractDao implements TodoDao{

    public List<Todo> getListTodo(int userID) {
        Query query = getSession().createQuery("FROM Todo WHERE user_id =:id");
        query.setParameter("id",userID);

        return query.list();
    }

    public void saveTodo(Todo todo) {
        getSession().save(todo);
    }

    public void updateTodo(Todo todo){
        getSession().update(todo);
    }

    public void removeTodo(Todo todo) {
        getSession().delete(todo);
    }

    @Override
    public Todo getTodoById(int id) {
        Query query = getSession().createQuery("FROM Todo WHERE id = :id");
        query.setParameter("id",id);
        return (Todo) query.uniqueResult();
    }
}
