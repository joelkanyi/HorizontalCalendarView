package com.joelkanyi.horizontalcalendar.util

import java.text.SimpleDateFormat
import java.util.*

fun getTodaysDate(): String {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy")
    val today = Calendar.getInstance().time
    return dateFormat.format(today)
}