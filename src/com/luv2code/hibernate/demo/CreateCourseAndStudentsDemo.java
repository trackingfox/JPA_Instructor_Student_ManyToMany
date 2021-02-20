package com.luv2code.hibernate.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
//			// create a course
//			Course tempCourse = new Course("Pacman - How To Score One Million Points");
//						
//			// save the course
//			System.out.println("\nSaving the course ...");
//			session.save(tempCourse);
//			System.out.println("Saved the course: " + tempCourse);
//			
//			// create the students
//			Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
//			Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
//						
//			// add students to the course
//			tempCourse.addStudent(tempStudent1);
//			tempCourse.addStudent(tempStudent2);
//			
//			// save the students
//			System.out.println("\nSaving students ...");
//			session.save(tempStudent1);
//			session.save(tempStudent2);
//			System.out.println("Saved students: " + tempCourse.getStudents());
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
//		}

		// using persistance.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Instructor_Student2");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// create a course
		Course tempCourse = new Course("Pacman - How To Score One Million Points");

		// save the course
		System.out.println("\nSaving the course ...");
		em.persist(tempCourse);
		System.out.println("Saved the course: " + tempCourse);

		// create the students
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");

		// add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		// save the students
		System.out.println("\nSaving students ...");
		em.persist(tempStudent1);
		em.persist(tempStudent2);
		System.out.println("Saved students: " + tempCourse.getStudents());

		// commit transaction
		em.getTransaction().commit();

		System.out.println("Done!");

		em.close();
		emf.close();
	}

}
