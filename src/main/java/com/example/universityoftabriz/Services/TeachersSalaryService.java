package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.TeachersSalary;
import com.example.universityoftabriz.Repository.TeachersSalaryRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeachersSalaryService {
    @Autowired
    private TeachersSalaryRepository teachersSalaryRepository;

    public void updateTeacherSalary(TeachersSalary teacherSalary, Logger logger) {
        teachersSalaryRepository.save(teacherSalary);
        logger.info("Resource with id: {} updated successfully.",teacherSalary.getId());
    }

}
