//package com.shafi.practice.service;
//
//import java.util.List;
//
//import org.hibernate.Transaction;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.shafi.practice.config.persistence.HibernateConfig;
//import com.shafi.practice.model.Student;
//
//
//
//
//
//@Service
//public class StudentService {
//	
//	private final HibernateConfig hibernateConfig;
//
//	@Autowired
//	public StudentService(HibernateConfig hibernateConfig) {
//		
//		this.hibernateConfig = hibernateConfig;
//	}
//	
//	public void addCourse(Student student) {	
//		var session = hibernateConfig.getSession();
//		var transection = session.beginTransaction();
//		//checkStudentInDb(student);
//		student.setName(student.getName());
//		student.setAge(student.getAge());
//		session.save(student);
//		transection.commit();
//	}
//
//	/*
//	 * private void checkStudentInDb(Student student) {
//	 * 
//	 * }
//	 */
//	
//	public List<Student> getAllStudents(){
//		
//		var session = hibernateConfig.getSession();
//		Transaction tx = session.getTransaction();
//		if (!tx.isActive())
//			tx = session.beginTransaction();
//		
//  		var query = session.getEntityManagerFactory().createEntityManager().createQuery("select c from Student c ", Student.class);
//		var studentList =  query.getResultList();
//		
//		return studentList;
//
//		
//	}
//	
//	
//}
