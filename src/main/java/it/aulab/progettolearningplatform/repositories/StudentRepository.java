package it.aulab.progettolearningplatform.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.progettolearningplatform.models.Student;

public interface StudentRepository extends JpaRepository<Student , Long>{

    List<Student> findByEmail(String email);
    
}
