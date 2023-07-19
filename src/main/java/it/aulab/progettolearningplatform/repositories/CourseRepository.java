package it.aulab.progettolearningplatform.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.progettolearningplatform.models.Course;

public interface CourseRepository extends JpaRepository<Course , Long>{
    
    List<Course> findByName(String name);

    List<Course> findByDescription(String description);
}
