package dev.indie.app.moa.batch.common.exception.models

import dev.indie.app.common.libraries.exception.models.DynamicException

/**
 * 배치 관련 최상위 예외
 */
@Suppress("unused")
open class BatchException(
    override val message: String? = null,
    override val cause: Throwable? = null,
    override val param: Any? = null,
) : DynamicException(
    message = message,
    cause = cause,
    param = param,
)
