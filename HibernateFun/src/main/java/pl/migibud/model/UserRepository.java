package pl.migibud.model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.migibud.HibernateConnect;
import pl.migibud.HibernateUtil;

public class UserRepository {

	public void addUserToDatabase(User user){
		Session session = HibernateConnect.SESSION_FACTORY.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		session.save(user);

		transaction.commit();
		session.close();
	}

	public void deleteUserFromDatabase(Integer id){
		Session session = HibernateConnect.SESSION_FACTORY.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		User user = session.get(User.class,id);
		session.delete(user);

		transaction.commit();
		session.close();
	}

	public void updateIsAdultInDatabase(Integer id,boolean isAdult){
		Session session = HibernateConnect.SESSION_FACTORY.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		User user = session.get(User.class,id);
		user.setIs_adult(isAdult);
		session.update(user);

		transaction.commit();
		session.close();
	}
}
