package dev.indie.app.common.libraries.exception.models

import kotlin.math.min

/**
 * 예외 출력을 위한 인터페이스
 */
interface ExceptionPrintable {
    /**
     * 예외 메세지
     */
    val message: String?

    /**
     * 예외 원인 (Target Exception. Ex, NullPointerException..)
     */
    val cause: Throwable?

    /**
     * 예외를 발생시킨 원인
     */
    val param: Any?

    companion object {
        const val DEFAULT_PARAM_LENGTH = 256
    }

    /**
     * 예외를 조사하기 위한 param 값을 텍스트로 출력하기 위한 함수.
     *
     * @param length 출력할 문자열의 길이
     * @return param의 문자열
     */
    fun paramString(length: Int = DEFAULT_PARAM_LENGTH): String {
        return if (param == null) {
            "null"
        } else {
            val name = param!!::class.simpleName
            val value = param.toString().substring(0, min(length, param.toString().length))
            "$name($value)"
        }
    }

    /**
     * 오류를 검사하기 위한 메소드
     */
    fun printException(): String = "${this::class.simpleName}(message=$message, cause=$cause, param=${paramString()})"
}
