package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.TeachersSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TeachersSalaryRepository extends JpaRepository<TeachersSalary, Long> {

    List<TeachersSalary> findByUser_id(long user_id);
    List<TeachersSalary> findByYear_edAndSemester(Date year_ed,int semester);

}
