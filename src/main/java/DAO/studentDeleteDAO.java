package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class studentDeleteDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	public static void OpenConnection() {
		factory=Persistence.createEntityManagerFactory("hibernate");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
	}
	
	public static void main(String[]args) {
	     OpenConnection();
	     transaction.begin();
	     studentDAO dao=manager.find(studentDAO.class,1);
	     manager.remove(dao);
	     System.out.println("removed sucessfully");
	     
	     transaction.commit();
	     CloseConnection();
	}

	private static void CloseConnection() {
		if (factory!=null) {
			factory.close();
		}if (manager!=null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();;
		}
		
	}

}
