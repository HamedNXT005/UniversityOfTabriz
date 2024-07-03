package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.HistorySalary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface HistorySalaryRepository extends JpaRepository<HistorySalary, Long> {

    List<HistorySalary> findByUserId(Long userId);

    List<HistorySalary> findByYearEdAndSemester(Date yearEd, int semester);
}
