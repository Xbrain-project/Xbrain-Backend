package com.Xbrain.XbrainBackend.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Xbrain.XbrainBackend.service.UserService;
import com.Xbrain.XbrainBackend.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registrationTeacher")
public class TeacherRegistrationController {
    
    private UserService userService;

    public TeacherRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }
    
    @ModelAttribute("user")
    public UserRegistrationDto teacherRegistrationDto(){
        return new UserRegistrationDto();
    }
    
    @GetMapping
    public String showRegistrationForm1(){
        return "registrationTeacher";
    }

    @PostMapping
    public String registerTeacherAccount(@ModelAttribute("user") UserRegistrationDto registrationDto){
        String result = "redirect:/registrationTeacher?error1";
        if(registrationDto.getPassword().equals(registrationDto.getCpassword())){      
            if(registrationDto.getPassword().equals(null)){
                result= "redirect:/registrationTeacher?error1";
            }else{
                try {
                    userService.save1(registrationDto);
                    result= "redirect:/registrationTeacher?success";
                } catch (Exception e) {
                    result= "redirect:/registrationTeacher?error2";
                }
            }
        }
        return result;
    }
}
