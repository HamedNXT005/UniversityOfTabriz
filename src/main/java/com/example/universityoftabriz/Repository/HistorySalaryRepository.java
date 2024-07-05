package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.HistorySalary;
import com.example.universityoftabriz.Objects.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface HistorySalaryRepository extends JpaRepository<HistorySalary, Long> {

    List<HistorySalary> findByUserId(Long userId);

    List<HistorySalary> findByYearEdAndSemester(int yearEd, int semester);

    Optional<HistorySalary> findByUserIdAndYearEdAndSemester(Long userId, int yearEd, int semester);

    @Query(value = "SELECT TOP 1 * FROM history_salary ORDER BY id DESC", nativeQuery = true)
    HistorySalary findLastSalary();
}
