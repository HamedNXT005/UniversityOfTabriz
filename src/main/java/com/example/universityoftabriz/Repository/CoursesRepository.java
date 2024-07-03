package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CoursesRepository extends JpaRepository<Courses, Long> {


    Optional<Courses> findByName(String name);

    List<Courses> findByFaculty(String faculty);

    List<Courses> findByMajor(String major);
}
