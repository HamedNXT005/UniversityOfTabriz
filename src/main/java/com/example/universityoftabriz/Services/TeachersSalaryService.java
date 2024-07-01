package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.TeachersSalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeachersSalaryService {
    @Autowired
    private TeachersSalaryRepository teachersSalaryRepository;

}
