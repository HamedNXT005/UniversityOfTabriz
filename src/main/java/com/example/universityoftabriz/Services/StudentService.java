package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.Student;
import com.example.universityoftabriz.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

}
