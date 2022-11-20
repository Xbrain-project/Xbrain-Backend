package com.Xbrain.XbrainBackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Xbrain.XbrainBackend.model.User;
import com.Xbrain.XbrainBackend.service.CustomUserDetails;
import com.Xbrain.XbrainBackend.service.UserService;

@Controller
public class MainController {
    
	@Autowired
	private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
	@GetMapping("/")
	public String home(@AuthenticationPrincipal CustomUserDetails loggerUser,Model model) {
		String email = loggerUser.getUsername();
		User user = userService.getByEmail(email);
		model.addAttribute("user", user);
		return "index";
	}
    @GetMapping("/registration")
	public String registration() {
		return "registration";
	}
	@GetMapping("/profile")
	public String viewDetails(@AuthenticationPrincipal CustomUserDetails loggerUser,Model model) {
		String email = loggerUser.getUsername();
		User user = userService.getByEmail(email);
		model.addAttribute("user", user);
		return "profile";
	}
	@PostMapping("/profile/update")
	public String updateDetails( @AuthenticationPrincipal CustomUserDetails loggerUser, @ModelAttribute("user") User user 
	,Model model){
		String email = loggerUser.getUsername();
		System.out.println(email);
		System.out.println(loggerUser.getUsername());
		User EXuser = userService.getByEmail(email);
		EXuser.setEmail(email);
		EXuser.setFirstName(user.getFirstName());
		EXuser.setLastName(user.getLastName());

		userService.updateDetails(EXuser);
		return "redirect:/profile?success";
	}
}
