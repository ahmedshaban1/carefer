package com.ahmed.carefer.helpers

import java.text.SimpleDateFormat
import java.util.*

fun String.getDateTime(
    currentFormat: String = "yyyy-MM-dd'T'HH:mm:ss'Z'", outFormat: String = "hh:mm a"
): String? {
    val simpleCurrentFormat = SimpleDateFormat(currentFormat, Locale.getDefault())
    val simpleOutFormat = SimpleDateFormat(outFormat, Locale.getDefault())
    val date = simpleCurrentFormat.parse(this)
    return date?.let { simpleOutFormat.format(it) }
}



