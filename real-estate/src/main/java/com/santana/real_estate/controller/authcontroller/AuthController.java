package com.santana.real_estate.controller.authcontroller;

import com.santana.real_estate.dto.userdto.LoginRequestDTO;
import com.santana.real_estate.dto.userdto.RegisterRequestDTO;
import com.santana.real_estate.dto.userdto.UserResponseDTO;
import com.santana.real_estate.service.userservice.UserService;
import jakarta.validation.Valid;
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
    public ResponseEntity login(@RequestBody @Valid LoginRequestDTO data) {
        userService.login(data);
        return new ResponseEntity(HttpStatus.OK);

    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody RegisterRequestDTO data) {

        return new ResponseEntity<>(userService.register(data), HttpStatus.OK);
    }
}
