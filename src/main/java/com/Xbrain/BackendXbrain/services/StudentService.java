package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.dto.UpdateStudentReq;
import com.Xbrain.BackendXbrain.dto.UpdateTeacherReq;
import com.Xbrain.BackendXbrain.entity.StudentEntity;
import com.Xbrain.BackendXbrain.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity addStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    public StudentEntity findByEmail(String email, String password) {

        StudentEntity byEmail = studentRepository.findByEmailAndPassword(email, password);

        return byEmail;

    }

    public StudentEntity findById(Long studentId) {

        Optional<StudentEntity> student = studentRepository.findById(studentId);
            StudentEntity temp_student = student.get();
            return temp_student;


    }

    public void updateUser(UpdateStudentReq student,Long id) {
        Optional<StudentEntity> byId = this.studentRepository.findById(id);

        if(byId.isPresent()) {

            byId.get().setName(student.getName());
            byId.get().setEmail(student.getEmail());
            byId.get().setNickname(student.getNickname());
            byId.get().setPhone(student.getPhone());
            byId.get().setLine(student.getLine());
            byId.get().setAddress(student.getAddress());
            byId.get().setGrade(student.getGrade());
            byId.get().setSchool(student.getSchool());

        }else
            System.out.println("not");
        StudentEntity save = studentRepository.save(byId.get());

    }

}

