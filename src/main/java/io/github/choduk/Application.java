package io.github.choduk;

import io.github.choduk.domain.Course;
import io.github.choduk.domain.RegistCourse;
import io.github.choduk.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author choduk88@gmail.com
 */
public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("h2dbconnect");
        EntityManager em = emfactory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            Student student = new Student();
            student.setName("Student1");
            em.persist(student);

            Course course = new Course();
            course.setClassName("Computer Science");
            em.persist(course);

            RegistCourse regist = new RegistCourse();
            regist.setRelation(student, course);
            em.persist(regist);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            em.close();
            emfactory.close();
        }

    }
}
