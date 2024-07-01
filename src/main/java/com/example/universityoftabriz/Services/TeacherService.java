package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.Resources;
import com.example.universityoftabriz.Objects.Teacher;
import com.example.universityoftabriz.Repository.TeacherRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public void updateTeacher(Teacher teacher, Logger logger) {
        teacherRepository.save(teacher);
        logger.info("Teacher with id: {} updated successfully.",teacher.getId());
    }
}
