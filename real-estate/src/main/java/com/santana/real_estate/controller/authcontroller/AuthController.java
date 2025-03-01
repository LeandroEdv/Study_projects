package com.santana.real_estate.controller.authcontroller;

import com.santana.real_estate.dto.userdto.LoginRequestDTO;
import com.santana.real_estate.dto.userdto.RegisterRequestDTO;
import com.santana.real_estate.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        return new ResponseEntity(HttpStatus.OK);

    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO data){

        return new ResponseEntity(userService.save(data),HttpStatus.OK);
    }
}
