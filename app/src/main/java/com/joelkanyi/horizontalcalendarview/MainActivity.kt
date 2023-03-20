package com.joelkanyi.horizontalcalendarview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.joelkanyi.horizontalcalendar.HorizontalCalendarView
import com.joelkanyi.horizontalcalendarview.ui.theme.HorizontalCalendarViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current

            HorizontalCalendarViewTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column() {
                        /*HorizontalCalendarView(
                            modifier = Modifier.padding(16.dp),
                            selectedTextColor = Color.White,
                            unSelectedTextColor = Color.Black,
                            selectedCardColor = Color.Blue,
                            unSelectedCardColor = Color.LightGray,
                            onDayClick = { day ->
                                Toast.makeText(context, day.toString(), Toast.LENGTH_SHORT).show()
                            }
                        )*/

                        HorizontalCalendarView(
                            modifier = Modifier,
                            selectedTextColor = Color.White,
                            unSelectedTextColor = Color.Black,
                            selectedCardColor = Color.Blue,
                            unSelectedCardColor = Color.LightGray,
                            onDayClick = { day ->
                                Toast.makeText(context, day.fullDate, Toast.LENGTH_SHORT).show()
                            }
                        )
                    }
                }
            }
        }
    }
}
