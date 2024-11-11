package org.github.h4de5ing

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.github.h4de5ing.bean.Bean

fun main() {
    val bean = Bean("张三", 12)
    val json = Json.encodeToString(bean)
    println("Hello Kotlin/Native!${json}")
}