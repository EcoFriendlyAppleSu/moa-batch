package dev.indie.app.common.libraries.exception.models

/**
 * 서비스 내부에서 동적으로 발생하는 예외를 처리하기 위한 Exception
 */
open class DynamicException(
    override val message: String?,
    override val cause: Throwable?,
    override val param: Any?,
): RuntimeException(), ExceptionPrintable {
    /**
     * 오류를 검사하기 위한 메소드
     *
     * @return 오류의 내용에 따른 메시지
     */
    override fun toString(): String {
        return printException()
    }
}
