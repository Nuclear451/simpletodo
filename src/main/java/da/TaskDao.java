package da;

import entities.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class TaskDao {
    private SessionFactory sessionFactory;

    public TaskDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Task> getAll(){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        List<Task> list = (List<Task>) session
                .createCriteria(Task.class)
                .list();

        tx.commit();
        session.close();
        return list;
    }

    public void save(String todo){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(new Task(todo));

        tx.commit();
        session.close();
    }

    public void delete(String todo){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        List taks = session.createCriteria(Task.class)
                .add(Restrictions.eq("task", todo))
                .list();
        if (taks != null && taks.size() != 0){
            session.delete(taks.get(0));
        }

        tx.commit();
        session.close();
    }
}
