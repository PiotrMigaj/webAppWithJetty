package pl.migibud;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

	private HibernateUtil(){}

	public static SessionFactory getSessionFactory(){
		return SESSION_FACTORY;
	}

	private static SessionFactory buildSessionFactory() {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			return new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			StandardServiceRegistryBuilder.destroy( registry );
			throw e;
		}
	}

	public static void close(){
		if (SESSION_FACTORY!=null){
			SESSION_FACTORY.close();
		}
	}
}
