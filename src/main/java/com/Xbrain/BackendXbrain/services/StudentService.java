package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.entity.StudentEntity;
import com.Xbrain.BackendXbrain.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity addStudent(StudentEntity student ) {
        return  studentRepository.save(student) ;
    }

    public StudentEntity findByEmail (String email, String password) {

        StudentEntity byEmail = studentRepository.findByEmailAndPassword(email,password);

        return byEmail;



    }

}
