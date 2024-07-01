package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student , Long> {

}
