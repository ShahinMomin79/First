package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class studentFindDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	public static void OpenConnection() {
		factory=Persistence.createEntityManagerFactory("hibernate");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
	}
	public static void CloseConnection() {
		if (factory!=null) {
			factory.close();
		}if (manager!=null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	public static void main(String[] args) {
		OpenConnection();
		transaction.begin();
		
		studentDAO studentDAO=manager.find(studentDAO.class, 1);
		System.out.println(studentDAO);
		
		transaction.commit();
		CloseConnection();
	}

}
