package com.yllliu.demo;

import com.yllliu.entity.Course;
import com.yllliu.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetCourseForLucyDemo {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        int lucyId = 2;
        Student student = entityManager.find(Student.class, lucyId);

        System.out.println(student.getCourses());

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
