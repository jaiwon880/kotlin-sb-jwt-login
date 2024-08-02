package com.example.jwt.member.controller

import com.example.jwt.member.dto.UserRequestDto
import com.example.jwt.member.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("api/user")
@RestController
class UserController(
    private val userService: UserService
) {
    @PostMapping("/signup")
    fun signUp(@RequestBody userRequestDto: UserRequestDto): String {
        return userService.signUp(userRequestDto)
    }
}
