package com.example.jwt.member.service

import com.example.jwt.member.domain.User
import com.example.jwt.member.dto.UserRequestDto
import com.example.jwt.member.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    /**
     * 회원 가입
     */
    fun signUp(userRequestDto: UserRequestDto): String {
        // 이메일 중복 검사
        var user: User? = userRepository.findByEmail(userRequestDto.email)
        if (user != null) {
            return "이미 등록된 이메일 입니다."
        }

        // 별명 중복 검사
        user = userRepository.findByNickname(userRequestDto.nickname)
        if (user != null) {
            return "이미 등록된 별명입니다."
        }

        user = User(
            email = userRequestDto.email,
            nickname = userRequestDto.nickname,
            username = userRequestDto.username,
            password = userRequestDto.password,
            phoneNumber = userRequestDto.phoneNumber,
            loverId = userRequestDto.loverId
        )
        userRepository.save(user)
        return "회원 가입이 완료되었습니다."
    }
}
