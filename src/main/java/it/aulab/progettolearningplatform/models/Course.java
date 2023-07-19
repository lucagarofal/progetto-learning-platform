package it.aulab.progettolearningplatform.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;





import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(length = 250 , nullable = false)
    public String name;

    @Column(length = 1000)
    public String description;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(
            name = "firstname",
            column = @Column(name = "teacher_firstname", length = 100, nullable = false)
        ),
         @AttributeOverride(
            name = "lastname",
            column = @Column(name = "teacher_lastname", length = 100, nullable = false)),

    })
    public Person teacher;

@Column(columnDefinition = "date")
public LocalDate date;

@ManyToMany
@JoinTable(
        name = "courses_students",
        joinColumns = @JoinColumn(name = "course_id", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "student_id", nullable = false)
    )

    
public List<Student> students = new ArrayList<Student>();

@OneToMany(mappedBy = "course")
public List<Lesson> lessons = new ArrayList<Lesson>();

public Course() {
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public Person getTeacher() {
    return teacher;
}

public void setTeacher(Person teacher) {
    this.teacher = teacher;
}

public LocalDate getDate() {
    return date;
}

public void setDate(LocalDate date) {
    this.date = date;
}

public List<Student> getStudents() {
    return students;
}

public void setStudents(List<Student> students) {
    this.students = students;
}

public List<Lesson> getCourses() {
    return lessons;
}

public void setCourses(List<Lesson> courses) {
    this.lessons = courses;
}


public String getTeacherFirstName(){
    return this.getTeacher().getFirstname();
}


        







   
   
   
   
    
    






    
}
