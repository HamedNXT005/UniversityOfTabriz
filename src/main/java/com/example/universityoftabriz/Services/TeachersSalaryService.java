package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.TeachersSalary;
import com.example.universityoftabriz.Repository.TeachersSalaryRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TeachersSalaryService {
    @Autowired
    private TeachersSalaryRepository teachersSalaryRepository;

    public void updateTeacherSalary(TeachersSalary teacherSalary ) {
        teachersSalaryRepository.save(teacherSalary);
    }

    public List<TeachersSalary> getTeachersSalaryByUid(long user_id){
        return teachersSalaryRepository.findByUserId(user_id);
    }

    public List<TeachersSalary> getTeachersSalaryByDate(int year_ed, int semester){
        return teachersSalaryRepository.findByYearEdAndSemester(year_ed,semester);
    }
}
