package com.yllliu.demo;

import com.yllliu.entity.Course;
import com.yllliu.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddCourseForLucyDemo {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        int lucyId = 2;
        Student student = entityManager.find(Student.class, lucyId);

        Course tennis_course = new Course("Tennis course");
        Course basketball_course = new Course("Basketball course");
        tennis_course.addStudent(student);
        basketball_course.addStudent(student);

        entityManager.persist(tennis_course);
        entityManager.persist(basketball_course);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
