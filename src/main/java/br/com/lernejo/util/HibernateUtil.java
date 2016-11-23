package br.com.lernejo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Classe que gerencia a conexão com o banco de dados.
 * @author Daniel Tiago
 */
public class HibernateUtil 
{
    private static final SessionFactory sessionFactory;
    public static final String HIBERNATE_SESSION = "hibernate_session";
    
    static 
    {
        try 
        {
            System.out.println("Tentando abrir uma SF");
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry;
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            System.out.println("Session Factory criada com sucesso");
        } catch (Exception ex) 
        {
            System.out.println("Ocorreu um  erro ao iniciar a SessionFactory. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() 
    {
        return sessionFactory;
    }
    
}
