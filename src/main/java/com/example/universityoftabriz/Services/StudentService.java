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

    public Optional<Student> getStudentByUserName(String userName){
        return studentRepository.findByUserName(userName);
    }

    public void updateStudent(Student student ) {
        studentRepository.save(student);
    }

    public List<Student> getStudentsByFaculty(String faculty){
        return studentRepository.findByFaculty(faculty);
    }

    public List<Student> getStudentsByMajor(String major){
        return studentRepository.findByMajor(major);
    }

    public Optional<Student> getStudentByNameFAndNameL(String nameF, String nameL){
        return studentRepository.findByNameFAndNameL(nameF, nameL);
    }

    public Optional<Student> getStudentByNationalCode(String nationalCode){
        return studentRepository.findByNationalCode(nationalCode);
    }

    public List<Student> getStudentsByGpaTotalGreaterThan(float gpaTotal){
        return studentRepository.findByGpaTotalGreaterThan(gpaTotal);
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }
}
