package com.example.jwt.member.domain

import com.example.jwt.common.domain.BaseEntity
import com.example.jwt.common.status.ProviderName
import com.example.jwt.common.status.UserRole
import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(
    name = "users",
    uniqueConstraints = [
        UniqueConstraint(name = "unique_email", columnNames = ["email"]),
        UniqueConstraint(name = "unique_nickname", columnNames = ["nickname"])
    ]
)
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lover_id", columnDefinition = "연인 정보 FK")
    var loverId: Lover?,

    @Column(nullable = false, unique = true, columnDefinition = "이메일")
    val email: String = "",

    @Column(nullable = false, unique = true, columnDefinition = "별명(중복불가)")
    val nickname: String = "",

    @Column(nullable = false, columnDefinition = "이름(실명)")
    val username: String = "",

    @Column(nullable = false, columnDefinition = "비밀번호")
    val password: String = "",

    @Column(name = "user_role", nullable = false, columnDefinition = "유저 등급")
    val userRole: UserRole = UserRole.NORMAL,

    @Column(name = "phone_number", nullable = false, columnDefinition = "전화번호")
    val phoneNumber: String = "",

    @Column(name = "profile_image", nullable = false)
    val profileImage: String = "기본프로필사진.jpg",

    @Column(name = "provider_name", columnDefinition = "회원가입/로그인 유형: EMAIL | KAKAO | GOOGLE")
    val providerName: ProviderName? = null,

    @Column(name = "provider_token", columnDefinition = "회원가입/로그인 유형 별 토큰")
    val providerToken: String? = null,

    @Column(name = "is_in_relationship", nullable = false, columnDefinition = "연인 매칭 여부")
    val isInRelationship: Boolean = false,

    @Column(name = "deleted_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var deletedAt: LocalDateTime? = null,

) : BaseEntity()
