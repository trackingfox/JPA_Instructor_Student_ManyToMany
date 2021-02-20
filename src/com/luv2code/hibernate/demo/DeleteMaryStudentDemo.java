package com.luv2code.hibernate.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteMaryStudentDemo {

	public static void main(String[] args) {

//		// create session factory
//		SessionFactory factory = new Configuration()
//								.configure("hibernate.cfg.xml")
//								.addAnnotatedClass(Instructor.class)
//								.addAnnotatedClass(InstructorDetail.class)
//								.addAnnotatedClass(Course.class)
//								.addAnnotatedClass(Review.class)
//								.addAnnotatedClass(Student.class)
//								.buildSessionFactory();
//		
//		// create session
//		Session session = factory.getCurrentSession();
//		
//		try {			
//			
//			// start a transaction
//			session.beginTransaction();
//				
//			// get the student from database
//			int studentId = 2;
//			Student tempStudent = session.get(Student.class, studentId);
//			
//			System.out.println("\nLoaded student: " + tempStudent);
//			System.out.println("Courses: " + tempStudent.getCourses());		
//		
//			// delete student
//			System.out.println("\nDeleting student: " + tempStudent);
//			session.delete(tempStudent);
//			
//			// commit transaction
//			session.getTransaction().commit();
//			
//			System.out.println("Done!");
//		}
//		finally {
//			
//			// add clean up code
//			session.close();
//			
//			factory.close();

		// using persistance.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Instructor_Student2");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// get the student from database
		int studentId = 2;
		Student tempStudent = em.find(Student.class, studentId);

		System.out.println("\nLoaded student: " + tempStudent);
		System.out.println("Courses: " + tempStudent.getCourses());

		// delete student
		System.out.println("\nDeleting student: " + tempStudent);
		em.remove(tempStudent);

		// commit transaction
		em.getTransaction().commit();

		System.out.println("Done!");

		em.close();
		emf.close();

	}

}
