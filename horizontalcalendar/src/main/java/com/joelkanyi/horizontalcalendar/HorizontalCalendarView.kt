package com.joelkanyi.horizontalcalendar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun HorizontalCalendarView(
    modifier: Modifier = Modifier,
    onDayClick: (String) -> Unit,
    selectedCardColor: Color,
    unSelectedCardColor: Color,
    selectedTextColor: Color,
    unSelectedTextColor: Color,
) {

    val viewModel = HorizontalCalendarViewModel()

    val days = Pager(
        config = PagingConfig(enablePlaceholders = false, pageSize = 10),
        pagingSourceFactory = {
            DayPagingSource()
        }
    ).flow

    HorizontalCalendarComponent(
        modifier = modifier,
        days = days.collectAsLazyPagingItems(),
        isDaySelected = { fullDate ->
            viewModel.selectedDate.value == fullDate
        },
        onClickDay = { fullDate ->
            viewModel.setSelectedDateState(fullDate)
            onDayClick(fullDate)
        },
        selectedCardColor = selectedCardColor,
        unSelectedCardColor = unSelectedCardColor,
        selectedTextColor = selectedTextColor,
        unSelectedTextColor = unSelectedTextColor
    )
}