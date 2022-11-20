package com.Xbrain.XbrainBackend.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Xbrain.XbrainBackend.service.UserService;
import com.Xbrain.XbrainBackend.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registrationStudent")
public class StudentRegistrationController {
    
    private UserService userService;

    public StudentRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }
    
    @ModelAttribute("user")
    public UserRegistrationDto studentRegistrationDto(){
        return new UserRegistrationDto();
    }
    
    @GetMapping
    public String showRegistrationForm2(){
        return "registrationStudent";
    }

    @PostMapping
    public String registerStudentAccount(@ModelAttribute("user") UserRegistrationDto registrationDto){
        String result = "redirect:/registrationStudent?error1";
        if(registrationDto.getPassword().equals(registrationDto.getCpassword())){      
            if(registrationDto.getPassword().equals(null)){
                result= "redirect:/registrationStudent?error1";
            }else{
                try {
                    userService.save2(registrationDto);
                    result= "redirect:/registrationStudent?success";
                } catch (Exception e) {
                    result= "redirect:/registrationStudent?error2";
                }
            }
        }
        return result;
    }
}
