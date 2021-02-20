package com.luv2code.hibernate.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
//		SessionFactory factory = new Configuration()
//								.configure("hibernate.cfg.xml")
//								.addAnnotatedClass(Instructor.class)
//								.addAnnotatedClass(InstructorDetail.class)
//								.addAnnotatedClass(Course.class)
//								.addAnnotatedClass(Review.class)
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
//			
//			// create a course
//			Course tempCourse = new Course("Pacman - How To Score One Million Points");
//			
//			// add some reviews
//			tempCourse.addReview(new Review("Great course ... loved it!"));
//			tempCourse.addReview(new Review("Cool course, job well done"));
//			tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));
//						
//			// save the course ... and leverage the cascade all :-)
//			System.out.println("Saving the course");
//			System.out.println(tempCourse);
//			System.out.println(tempCourse.getReviews());
//			
//			session.save(tempCourse);
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

		// add some reviews
		tempCourse.addReview(new Review("Great course ... loved it!"));
		tempCourse.addReview(new Review("Cool course, job well done"));
		tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

		// save the course ... and leverage the cascade all :-)
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		em.persist(tempCourse);

		// commit transaction
		em.getTransaction().commit();

		System.out.println("Done!");

		em.close();
		emf.close();
	}

}
