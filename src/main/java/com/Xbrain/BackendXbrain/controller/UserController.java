package com.Xbrain.BackendXbrain.controller;


import com.Xbrain.BackendXbrain.bussiness.UserBusiness;
import com.Xbrain.BackendXbrain.dto.UserDTO;
import com.Xbrain.BackendXbrain.entity.UserEntity;

import com.Xbrain.BackendXbrain.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


    @RestController
    @CrossOrigin
    @RequestMapping("/api")
    public class UserController {

        private final UserBusiness userBusiness;

        private final UserService userService;

        public UserController(UserBusiness userBusiness, UserService userService) {
            this.userBusiness = userBusiness;
            this.userService = userService;
        }

        @PostMapping("/register")
        public ResponseEntity<Object> register(@RequestBody UserDTO userDTO){

            Object response = userBusiness.register(userDTO,userDTO.getRole());

            return  ResponseEntity.ok(response);
        }

        @PutMapping("/{userId}")
        public ResponseEntity<UserEntity> updateUser(@RequestBody UserDTO userDTO,@PathVariable Long userId){
            UserEntity response = userService.updateUser(userDTO, userId);
            return  ResponseEntity.ok(response);
        }

        @PostMapping("/login")
        public ResponseEntity<UserDTO> Login(@RequestBody UserDTO userDTO){

            UserDTO userByEmail = userService.getUserByEmail(userDTO.getEmail(), userDTO.getPassword());
            ResponseEntity login = userBusiness.login(userByEmail);

            return login;




        }

        @GetMapping("/{userId}")
        public UserDTO getUserById(@PathVariable Long userId){
            UserDTO userById = userService.getUserById(userId);
            return  userById;
        }

    //    @GetMapping("/")
    //    public ResponseEntity<List<UserDTO>> getAllusers(){
    //        List<UserDTO> allusers = userService.getAllusers();
    //        return  ResponseEntity.ok(allusers);
    //    }




    //    // upload profile
    //    @PostMapping("/user/image/upload/{userId}")
    //    public ResponseEntity<UserEntity> uploadImage(@RequestParam("image")MultipartFile image,@PathVariable Long userId) throws IOException {
    //            String fileName = fileService.uploadImage(path, image);
    //            UserDTO userDTO = this.userService.getUserById(userId);
    //            userDTO.setImg(fileName);
    //        UserEntity updateUser = userService.updateUser(userDTO, userId);
    //        return ResponseEntity.ok(updateUser);
    //    }
    //
    //    //get image
    //    @GetMapping("user/image/{imageName}")




    //    @RequestMapping(value="/uploadImage2",method = RequestMethod.POST)
    //    public @ResponseBody String uploadImage2(@RequestParam("imageValue") String imageValue, HttpServletRequest request)
    //    {
    //        try
    //        {
    //            //This will decode the String which is encoded by using Base64 class
    //            byte[] imageByte= Base64.decodeBase64(imageValue);
    //
    //            String directory=servletContext.getRealPath("/")+"images/sample.jpg";
    //
    //            new FileOutputStream(directory).write(imageByte);
    //            return "success ";
    //        }
    //        catch(Exception e)
    //        {
    //            return "error = "+e;
    //        }

        }








