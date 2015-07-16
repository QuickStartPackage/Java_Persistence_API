package io.github.choduk.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author choduk88@gmail.com
 */

@Getter
@Setter
@Entity
@Table(name = "REGIST_COURSE")
public class RegistCourse {

    @Id
    @GeneratedValue
    @Column(name = "REGIST_COURSE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student student;


    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private Course course;


    public void setRelation(Student student, Course course){
        this.student = student;
        this.course = course;

        student.getRegistCourseList().add(this);
        course.getRegistCourseList().add(this);
    }
}
