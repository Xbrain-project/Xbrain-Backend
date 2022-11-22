package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.dto.UserDTO;
import com.Xbrain.BackendXbrain.entity.StudentEntity;
import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import com.Xbrain.BackendXbrain.entity.UserEntity;
import com.Xbrain.BackendXbrain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    public UserService(UserRepository userRepo, TeacherService teacherService) {
        this.userRepo = userRepo;
        this.teacherService = teacherService;

    }

    public Object createUser(UserDTO userDTO,String role) {

        UserEntity user = this.dtoToUser(userDTO);
        UserEntity save = userRepo.save(user);
        TeacherEntity teacher = new TeacherEntity();
        StudentEntity student = new StudentEntity();

        if (role.startsWith("t")) {
            teacher.setName(userDTO.getName());
            teacher.setEmail(userDTO.getEmail());
            teacher.setPassword(userDTO.getPassword());
            teacher.setNickname(userDTO.getNickname());
            teacher.setNschool(userDTO.getNschool());
            teacher.setPhone(userDTO.getPhone());
            teacher.setLine(userDTO.getLine());
            teacher.setSex(userDTO.getSex());
            teacher.setStatus(userDTO.getStatus());
            teacher.setIntro(userDTO.getIntro());
            teacher.setRole(userDTO.getRole());


            return teacherService.addTeacher(teacher);
        }else {
            student.setName(userDTO.getName());
            student.setEmail(userDTO.getEmail());
            student.setPassword(userDTO.getPassword());
            student.setNickname(userDTO.getNickname());
            student.setNschool(userDTO.getNschool());
            student.setPhone(userDTO.getPhone());
            student.setLine(userDTO.getLine());
            student.setGrade(userDTO.getGrade());
            student.setAddress(userDTO.getAddress());
            student.setRole(userDTO.getRole());



            return studentService.addStudent(student);

        }


    }




    public  UserEntity updateUser(UserDTO userDTO, Long userId) {
        Optional<UserEntity> user = userRepo.findById(userId);

        UserEntity user1 = user.get();
        user1.setName(userDTO.getName());
        user1.setName(userDTO.getName());
        user1.setEmail(userDTO.getEmail());
        user1.setPassword(userDTO.getPassword());
        user1.setNickname(userDTO.getNickname());
        user1.setNschool(userDTO.getNschool());
        user1.setGrade(userDTO.getGrade());
        user1.setPhone(userDTO.getPhone());
        user1.setAddress(userDTO.getAddress());
        user1.setLine(userDTO.getLine());


        UserEntity save = userRepo.save(user1);

        return save;
    }


    public UserDTO getUserById(Long userId) {

        Optional<UserEntity> userById = userRepo.findById(userId);

        UserEntity user = userById.get();

        return userToDTO(user);
    }


    public UserDTO getUserByEmail(String email,String password) {

        UserEntity byEmail = userRepo.findByEmailAndPassword(email,password);

        return userToDTO(byEmail);
    }


    public List<UserDTO> getAllusers() {

        List<UserEntity> users = userRepo.findAll();

        List<UserDTO> userDTOList = users.stream().map(user -> this.userToDTO(user)).collect(Collectors.toList());



        return userDTOList;
    }


    public void deleteUser(Long userId) {

    }


    public UserEntity dtoToUser(UserDTO userDTO){
        UserEntity user = new UserEntity();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setNickname(userDTO.getNickname());
        user.setNschool(userDTO.getNschool());
        user.setGrade(userDTO.getGrade());
        user.setPhone(userDTO.getPhone());
        user.setAddress(userDTO.getAddress());
        user.setLine(userDTO.getLine());
        user.setSex(userDTO.getSex());
        user.setStatus(userDTO.getStatus());
        user.setIntro(userDTO.getIntro());
        user.setRole(userDTO.getRole());

        return user;
    }

    public UserDTO userToDTO(UserEntity user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setNickname(user.getNickname());
        userDTO.setNschool(user.getNschool());
        userDTO.setGrade(user.getGrade());
        userDTO.setPhone(user.getPhone());
        userDTO.setAddress(user.getAddress());
        userDTO.setLine(user.getLine());
        userDTO.setSex(user.getSex());
        userDTO.setStatus(user.getStatus());
        userDTO.setIntro(user.getIntro());
        userDTO.setRole(user.getRole());


        return userDTO;
    }
}
