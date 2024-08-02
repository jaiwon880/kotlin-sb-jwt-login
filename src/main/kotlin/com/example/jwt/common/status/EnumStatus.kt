package com.example.jwt.common.status

enum class UserRole(val desc: String) {
    NORMAL("일반"),
    VIP("VIP"),
    ADMIN("관리자")
}

enum class ProviderName(val desc: String) {
    EMAIL("이메일"),
    KAKAO("카카오"),
    GOOGLE("구글")
}
