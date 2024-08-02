package com.example.jwt.common.domain

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

@MappedSuperclass
abstract class BaseEntity {
    @Column(name = "created_at", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var createdAt: LocalDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS)

    @Column(name = "updated_at", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var updatedAt: LocalDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS)

    @PrePersist
    fun onPrePersist() {
        createdAt = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS)
    }

    @PreUpdate
    fun onPreUpdate() {
        updatedAt = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS)
    }
}
