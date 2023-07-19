package it.aulab.progettolearningplatform.repositories;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.progettolearningplatform.models.Lesson;

public interface LessonRepository extends JpaRepository<Lesson , Long>{

    List<Lesson> findByDate(LocalDate date);
    
}
