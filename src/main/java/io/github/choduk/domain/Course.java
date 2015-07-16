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
@Table(name = "COURSE")
public class Course {
    @Id
    @GeneratedValue
    @Column(name = "COURSE_ID")
    private Long id;

    private String className;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<RegistCourse> registCourseList = new ArrayList<>();
}
