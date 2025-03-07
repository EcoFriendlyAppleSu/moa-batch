package dev.indie.app.common.utilities.logger

import org.slf4j.LoggerFactory

/**
 * Trace 레벨로 로그를 출력한다.
 */
inline fun <reified T> T.zLogTrace(message: () -> String) {
    val logger = LoggerFactory.getLogger(T::class.java)
    if (logger.isTraceEnabled) {
        logger.trace(message())
    }
}

/**
 * Debug 레벨로 로그를 출력한다.
 */
inline fun <reified T> T.zLogDebug(message: () -> String) {
    val logger = LoggerFactory.getLogger(T::class.java)
    if (logger.isDebugEnabled) {
        logger.debug(message())
    }
}

/**
 * Info 레벨로 로그를 출력한다.
 */
inline fun <reified T> T.zLogInfo(message: () -> String) {
    val logger = LoggerFactory.getLogger(T::class.java)
    if (logger.isInfoEnabled) {
        logger.info(message())
    }
}

/**
 * Warn 레벨로 로그를 출력한다.
 */
inline fun <reified T> T.zLogWarn(message: () -> String) {
    val logger = LoggerFactory.getLogger(T::class.java)
    if (logger.isWarnEnabled) {
        logger.warn(message())
    }
}

/**
 * Error 레벨로 로그를 출력한다.
 */
inline fun <reified T> T.zLogError(message: () -> String) {
    val logger = LoggerFactory.getLogger(T::class.java)
    if (logger.isErrorEnabled) {
        logger.error(message())
    }
}

/**
 * Error 레벨로 로그를 출력하는데, 원인이 되는 예외를 stack trace로 함께 출력한다.
 */
inline fun <reified T> T.zLogError(cause: Throwable, message: () -> String) {
    val logger = LoggerFactory.getLogger(T::class.java)
    if (logger.isErrorEnabled) {
        logger.error(message(), cause)
    }
}
