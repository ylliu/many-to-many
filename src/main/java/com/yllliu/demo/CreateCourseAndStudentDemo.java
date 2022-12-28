package com.yllliu.demo;

import com.yllliu.entity.Course;
import com.yllliu.entity.Review;
import com.yllliu.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateCourseAndStudentDemo {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Course course1 = new Course("Course5 for many to many");
        entityManager.persist(course1);

        Student student1 = new Student("Lily", "John", "ahsdjagd@11.com");
        Student student2 = new Student("Lucy", "John", "lucy.john@11.com");

        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
