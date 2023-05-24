package DTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DAO.studentDAO;

public class studentDTO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	public static void openConnection() {
		factory=Persistence.createEntityManagerFactory("hibernate");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
	}
	public static void closeConnection() {
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
		openConnection();
		transaction.begin();
		studentDAO studentDAO=new studentDAO();
		studentDAO.setId(1);
		studentDAO.setName("shahin");
		studentDAO.setEmail("shahin@gmail.com");
		studentDAO.setCity("pune");
		manager.persist(studentDAO);
		transaction.commit();
		closeConnection();
	}

}
