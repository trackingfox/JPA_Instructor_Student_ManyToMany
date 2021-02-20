package com.luv2code.hibernate.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;

public class AddCoursesForMaryDemo {

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
//			// get the student mary from database
//			int studentId = 2;
//			Student tempStudent = session.get(Student.class, studentId);
//			
//			System.out.println("\nLoaded student: " + tempStudent);
//			System.out.println("Courses: " + tempStudent.getCourses());
//			
//			// create more courses 
//			Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
//			Course tempCourse2 = new Course("Atari 2600 - Game Development");
//						
//			// add student to courses
//			tempCourse1.addStudent(tempStudent);
//			tempCourse2.addStudent(tempStudent);
//						
//			// save the courses
//			System.out.println("\nSaving the courses ...");
//			
//			session.save(tempCourse1);
//			session.save(tempCourse2);
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

		// get the instructor from db
		int theId = 1;
		Instructor tempInstructor = em.find(Instructor.class, theId);

		// create some courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the courses
		em.persist(tempCourse1);
		em.persist(tempCourse2);

		// commit transaction
		em.getTransaction().commit();

		System.out.println("Done!");

		em.close();
		emf.close();
	}

}
