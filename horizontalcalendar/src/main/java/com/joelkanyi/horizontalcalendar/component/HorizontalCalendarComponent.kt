package com.joelkanyi.horizontalcalendar.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.joelkanyi.horizontalcalendar.model.Day
import kotlinx.coroutines.flow.Flow

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
    val daysLazyRowState = rememberLazyListState()
    val allDays = days.collectAsLazyPagingItems()

    Column(
        modifier = Modifier.padding(16.dp),
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
                itemsIndexed(allDays) { index, day ->
                    if (daysLazyRowState.firstVisibleItemIndex == index) {
                        monthAndYear.value = "${day?.monthShortName}, ${day?.year}"
                    }
                    day?.let {
                        DayItemCard(
                            modifier = modifier,
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
    }
}