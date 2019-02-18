package da;

import entities.Task;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DataAccessConfig {
    private DataAccessConfig(){}

    private static final StandardServiceRegistry registry =
            new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

    private static SessionFactory sessionFactory = new MetadataSources( registry )
            .addAnnotatedClass(Task.class)
            .buildMetadata()
            .buildSessionFactory();

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
