package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface ResourcesRepository extends JpaRepository<Resources, Long> {


    Optional<Resources> findByYearEdAndSemester(int year_ed, int semester);

    @Query(value = "SELECT TOP 1 * FROM resources ORDER BY id DESC", nativeQuery = true)
    Resources findLastRecord();
}
