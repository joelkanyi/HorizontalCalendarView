package com.joelkanyi.horizontalcalendar.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DayItemCard(
    modifier: Modifier,
    day: String,
    date: String,
    fullDate: String,
    onClick: (String) -> Unit = {},
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
            .clickable {
                onClick(fullDate)
            },
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected(fullDate)) {
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
                    text = day,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = if (isSelected(fullDate)) {
                        selectedTextColor
                    } else {
                        unSelectedTextColor
                    }
                )
                Text(
                    text = date,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = if (isSelected(fullDate)) {
                        selectedTextColor
                    } else {
                        unSelectedTextColor
                    }
                )
            }
        }
    }
}