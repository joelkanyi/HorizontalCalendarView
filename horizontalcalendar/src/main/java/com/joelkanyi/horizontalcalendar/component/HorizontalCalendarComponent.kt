package com.joelkanyi.horizontalcalendar.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.joelkanyi.horizontalcalendar.model.Day
import com.joelkanyi.horizontalcalendar.viewmodel.HorizontalCalendarViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalCalendarComponent(
    modifier: Modifier,
    days: Flow<PagingData<Day>>,
    isDaySelected: (String) -> Boolean,
    onClickDay: (Day) -> Unit,
    selectedCardColor: Color,
    unSelectedCardColor: Color,
    selectedTextColor: Color,
    unSelectedTextColor: Color,
) {
    val viewModel: HorizontalCalendarViewModel = viewModel()
    val daysLazyRowState = rememberLazyListState()
    val allDays = days.collectAsLazyPagingItems()
    val coroutineScope = rememberCoroutineScope()
    val selectedDate = viewModel.selectedDate

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        val monthAndYear = remember {
            mutableStateOf("")
        }
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = monthAndYear.value,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.End
        )

        LazyRow(
            state = daysLazyRowState,
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            content = {
                itemsIndexed(
                    items = allDays,
                    key = { _, day ->
                        day.fullDate
                    }
                ) { index, day ->
                    if (remember { derivedStateOf { daysLazyRowState.firstVisibleItemIndex } }.value == index) {
                        monthAndYear.value = "${day?.monthShortName}, ${day?.year}"
                    }

                    day?.let {
                        DayItemCard(
                            modifier = modifier.animateItemPlacement(),
                            day = it,
                            isSelected = isDaySelected,
                            onClick = onClickDay,
                            selectedCardColor = selectedCardColor,
                            unSelectedCardColor = unSelectedCardColor,
                            selectedTextColor = selectedTextColor,
                            unSelectedTextColor = unSelectedTextColor
                        )
                    }
                }
            }
        )

        LaunchedEffect(allDays.itemSnapshotList.size) {
            coroutineScope.launch {
                val selectedDay = allDays.itemSnapshotList.items.find { day ->
                    day.fullDate == selectedDate.value
                }
                allDays.itemSnapshotList.items.indexOf(selectedDay).let { index ->
                    daysLazyRowState.scrollToItem(if (index < 0) 0 else index)
                }
            }
        }
    }
}
