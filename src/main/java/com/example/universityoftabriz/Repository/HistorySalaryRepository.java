package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.HistorySalary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface HistorySalaryRepository extends JpaRepository<HistorySalary, Long> {

    List<HistorySalary> findByUserId(Long userId);

    List<HistorySalary> findByYearEdAndSemester(int yearEd, int semester);

    Optional<HistorySalary> findByUserIdAndYearEdAndSemester(Long userId, int yearEd, int semester);
}
