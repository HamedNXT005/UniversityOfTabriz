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

    public void updateTeacherSalary(TeachersSalary teacherSalary, Logger logger) {
        teachersSalaryRepository.save(teacherSalary);
        logger.info("Resource with id: {} updated successfully.",teacherSalary.getId());
    }

    public List<TeachersSalary> getTeachersSalaryByUid(long user_id){
        return teachersSalaryRepository.findByUser_id(user_id);
    }

    public List<TeachersSalary> getTeachersSalaryByDate(Date year_ed, int semester){
        return teachersSalaryRepository.findByYear_edAndSemester(year_ed,semester);
    }
}
