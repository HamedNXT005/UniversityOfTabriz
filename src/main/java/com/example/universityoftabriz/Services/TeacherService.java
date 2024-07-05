package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.Teacher;
import com.example.universityoftabriz.Repository.TeacherRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public void updateTeacher(Teacher teacher ) {
        teacherRepository.save(teacher);
    }

    public Optional<Teacher> getTeacherByID(Long id){
        return teacherRepository.findById(id);
    }


    public Optional<Teacher> getTeacherByUserName(String userName){
        return teacherRepository.findByUserName(userName);
    }

    public Optional<Teacher> getTeacherByNameFAndNameL(String nameF, String nameL){
        return teacherRepository.findByNameFAndNameL(nameF,nameL);
    }

    public List<Teacher> getTeachersByFaculty(String faculty){
        return teacherRepository.findByFaculty(faculty);
    }

    public Optional<Teacher> getTeacherByNationalCode(String nationalCode){
        return teacherRepository.findByNationalCode(nationalCode);
    }

    public List<Teacher> getTeachersByStatus(String status){
        return teacherRepository.findByStatus(status);
    }

    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }

    public Teacher getLastTeacher(){
        return teacherRepository.findLastTeacher();
    }
}
