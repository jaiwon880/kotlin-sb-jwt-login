package com.example.jwt.member.domain

import com.example.jwt.common.domain.BaseEntity
import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "lovers")
data class Lover(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, columnDefinition = "유저 정보 FK")
    var userId: User,

    @Column(name = "deleted_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var deletedAt: LocalDateTime? = null,

) : BaseEntity()
