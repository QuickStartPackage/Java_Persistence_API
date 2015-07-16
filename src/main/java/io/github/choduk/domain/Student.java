package io.github.choduk.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author choduk88@gmail.com
 */

@Getter
@Setter
@Entity
@Table(name = "STUDENT")
public class Student {

    @Id @GeneratedValue
    @Column(name = "STUDENT_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<RegistCourse> registCourseList = new ArrayList<>();
}
