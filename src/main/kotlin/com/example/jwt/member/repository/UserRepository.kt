package com.example.jwt.member.repository

import com.example.jwt.member.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByNickname(nickname: String): User?
    fun findByEmail(email: String): User?
}
