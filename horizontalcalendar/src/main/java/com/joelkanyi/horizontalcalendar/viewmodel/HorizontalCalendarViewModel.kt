package com.joelkanyi.horizontalcalendar.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.joelkanyi.horizontalcalendar.util.getTodaysDate

class HorizontalCalendarViewModel : ViewModel() {

    private val _selectedDate = mutableStateOf(getTodaysDate())
    val selectedDate: State<String> = _selectedDate

    fun setSelectedDateState(value: String) {
        _selectedDate.value = value
    }
}
