package com.Xbrain.XbrainBackend.web.dto;

public class UserRegistrationDto {
    private String email;
    private String password;
    private String cpassword;
    
    public UserRegistrationDto(){}
    
    public UserRegistrationDto(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getCpassword() {
        return cpassword;
    }
    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

}
