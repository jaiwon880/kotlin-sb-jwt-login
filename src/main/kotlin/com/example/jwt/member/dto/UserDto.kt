package com.example.jwt.member.dto

import com.example.jwt.member.domain.Lover

data class UserRequestDto(
    val nickname: String,
    val username: String,
    val email: String,
    val phoneNumber: String,
    val password: String,
    val loverId: Lover? = null
)

data class UserResponseDto(
    val nickname: String,
    val username: String,
    val email: String,
    val phoneNumber: String,
    val password: String,
    val loverId: Lover? = null
)
