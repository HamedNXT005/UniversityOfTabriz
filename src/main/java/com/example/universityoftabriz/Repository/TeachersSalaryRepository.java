package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.TeachersSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TeachersSalaryRepository extends JpaRepository<TeachersSalary, Long> {

    TeachersSalary findByUserId(long user_id);
    List<TeachersSalary> findByYearEdAndSemester(int year_ed,int semester);


}
