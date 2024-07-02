package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.Student;
import com.example.universityoftabriz.Repository.StudentRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(long id){
        return  studentRepository.findById(id);
    }

    public void updateStudent(Student student, Logger logger) {
        studentRepository.save(student);
        logger.info("Student with id: {} updated successfully.",student.getId());
    }

}
