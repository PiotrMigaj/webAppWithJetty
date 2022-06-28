package pl.migibud;

import org.hibernate.SessionFactory;
import pl.migibud.model.User;
import pl.migibud.model.UserRepository;

public class App {
	public static void main(String[] args) {

		UserRepository userRepository = new UserRepository();
//		User anna = new User("Anna","Migaj",true);
//		User basia = new User("Basia","Migaj",false);
//		userRepository.addUserToDatabase(anna);
//		userRepository.addUserToDatabase(basia);

		userRepository.updateIsAdultInDatabase(1,false);

		HibernateUtil.close();
	}
}
