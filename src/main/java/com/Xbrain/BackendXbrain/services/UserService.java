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


        TeacherEntity.TeacherBuilder teacherBuilder =  new TeacherEntity.TeacherBuilder() ;


        teacherBuilder.setName(userDTO.getName());
        teacherBuilder.setEmail(userDTO.getEmail());
        teacherBuilder.setPassword(userDTO.getPassword());
        teacherBuilder.setNickname(userDTO.getNickname());
        teacherBuilder.setSchool(userDTO.getSchool());
        teacherBuilder.setPhone(userDTO.getPhone());
        teacherBuilder.setLine(userDTO.getLine());
        teacherBuilder.setSex(userDTO.getSex());
        teacherBuilder.setStatus(userDTO.getStatus());
        teacherBuilder.setIntro(userDTO.getIntro());
        teacherBuilder.setRole(userDTO.getRole());
        TeacherEntity employee = teacherBuilder
                .build() ;

        if (role.startsWith("t")) {
            teacher.setName(userDTO.getName());
            teacher.setEmail(userDTO.getEmail());
            teacher.setPassword(userDTO.getPassword());
            teacher.setNickname(userDTO.getNickname());
            teacher.setSchool(userDTO.getSchool());
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
            student.setSchool(userDTO.getSchool());
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
        user1.setSchool(userDTO.getSchool());
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
        user.setSchool(userDTO.getSchool());
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
        userDTO.setSchool(user.getSchool());
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
