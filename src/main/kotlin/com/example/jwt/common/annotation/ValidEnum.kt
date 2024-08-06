package com.example.jwt.common.annotation

import kotlin.reflect.KClass

annotation class ValidEnum(
    val message: String = "유효하지 않은 값입니다.",
    val groups: Array<KClass<*>> = []
    //    val payload: Array<>
)
