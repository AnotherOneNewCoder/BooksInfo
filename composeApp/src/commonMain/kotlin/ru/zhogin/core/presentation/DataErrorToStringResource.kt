package ru.zhogin.core.presentation

import booksinfo.composeapp.generated.resources.Res
import booksinfo.composeapp.generated.resources.disk_full
import booksinfo.composeapp.generated.resources.error_no_internet
import booksinfo.composeapp.generated.resources.error_serialization
import booksinfo.composeapp.generated.resources.error_too_many_requests
import booksinfo.composeapp.generated.resources.request_time_out
import booksinfo.composeapp.generated.resources.unknown
import ru.zhogin.core.domain.DataError

fun DataError.toUiText(): UiText {
    val stringRes = when(this) {
        DataError.Local.DISK_FULL -> Res.string.disk_full
        DataError.Local.UNKNOWN -> Res.string.unknown
        DataError.Remote.REQUEST_TIMEOUT -> Res.string.request_time_out
        DataError.Remote.TOO_MANY_REQUESTS -> Res.string.error_too_many_requests
        DataError.Remote.NO_INTERNET -> Res.string.error_no_internet
        DataError.Remote.SERVER -> Res.string.unknown
        DataError.Remote.SERIALIZATION -> Res.string.error_serialization
        DataError.Remote.UNKNOWN -> Res.string.unknown
    }
    return UiText.StringResourceId(stringRes)
}