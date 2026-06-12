package ma.projet.util;

import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Properties props = new Properties();
            props.load(HibernateUtil.class.getClassLoader().getResourceAsStream("application.properties"));

            Configuration configuration = new Configuration();
            configuration.setProperties(props);
            configuration.addAnnotatedClass(Employe.class);
            configuration.addAnnotatedClass(Projet.class);
            configuration.addAnnotatedClass(Tache.class);
            configuration.addAnnotatedClass(EmployeTache.class);

            sessionFactory = configuration.buildSessionFactory();
        } catch (IOException e) {
            throw new RuntimeException("Erreur chargement application.properties", e);
        } catch (Exception e) {
            System.err.println("Erreur initialisation SessionFactory : " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
