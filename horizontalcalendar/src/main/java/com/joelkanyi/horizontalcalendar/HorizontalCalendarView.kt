package com.joelkanyi.horizontalcalendar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.joelkanyi.horizontalcalendar.component.HorizontalCalendarComponent
import com.joelkanyi.horizontalcalendar.model.Day
import com.joelkanyi.horizontalcalendar.paging.DayPagingSource
import com.joelkanyi.horizontalcalendar.viewmodel.HorizontalCalendarViewModel

@Composable
fun HorizontalCalendarView(
    modifier: Modifier = Modifier,
    onDayClick: (Day) -> Unit,
    selectedCardColor: Color,
    unSelectedCardColor: Color,
    selectedTextColor: Color,
    unSelectedTextColor: Color,
) {

    val viewModel: HorizontalCalendarViewModel = viewModel()

    val days = Pager(
        config = PagingConfig(enablePlaceholders = false, pageSize = 10),
        pagingSourceFactory = {
            DayPagingSource()
        }
    ).flow

    HorizontalCalendarComponent(
        modifier = modifier,
        days = days,
        isDaySelected = { fullDate ->
            viewModel.selectedDate.value == fullDate
        },
        onClickDay = { day ->
            if (day.fullDate != viewModel.selectedDate.value) {
                viewModel.setSelectedDateState(day.fullDate)
                onDayClick(day)
            }
        },
        selectedCardColor = selectedCardColor,
        unSelectedCardColor = unSelectedCardColor,
        selectedTextColor = selectedTextColor,
        unSelectedTextColor = unSelectedTextColor
    )
}
