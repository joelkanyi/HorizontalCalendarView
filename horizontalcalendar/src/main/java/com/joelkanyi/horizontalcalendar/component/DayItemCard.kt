package com.joelkanyi.horizontalcalendar.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.joelkanyi.horizontalcalendar.model.Day

@Composable
fun DayItemCard(
    modifier: Modifier,
    day: Day,
    onClick: (Day) -> Unit = {},
    isSelected: (String) -> Boolean,
    selectedCardColor: Color,
    unSelectedCardColor: Color,
    selectedTextColor: Color,
    unSelectedTextColor: Color,
) {
    Card(
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(2.dp)
            .clip(RoundedCornerShape(12.0.dp))
            .clickable {
                onClick(day)
            },
        shape = RoundedCornerShape(12.0.dp), // similar to medium shape token
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected(day.fullDate)) {
                selectedCardColor
            } else {
                unSelectedCardColor
            }
        )
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = day.dayShortName.take(2).uppercase(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = if (isSelected(day.fullDate)) {
                        selectedTextColor
                    } else {
                        unSelectedTextColor
                    }
                )
                Text(
                    text = day.displayDate,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = if (isSelected(day.fullDate)) {
                        selectedTextColor
                    } else {
                        unSelectedTextColor
                    }
                )
            }
        }
    }
}