package pl.migibud;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public enum HibernateConnect {

	SESSION_FACTORY;

	private final SessionFactory sessionFactory;

	HibernateConnect() {
		this.sessionFactory = buildSessionFactory();
	}

	public SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}

	private SessionFactory buildSessionFactory() {
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

	public void close(){
		SESSION_FACTORY.close();
	}


}
