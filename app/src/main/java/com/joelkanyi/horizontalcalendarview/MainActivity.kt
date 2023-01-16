package com.joelkanyi.horizontalcalendarview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joelkanyi.horizontalcalendar.HorizontalCalendarView
import com.joelkanyi.horizontalcalendarview.ui.theme.HorizontalCalendarViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current

            HorizontalCalendarViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HorizontalCalendarView(
                        modifier = Modifier,
                        selectedTextColor = Color.White,
                        unSelectedTextColor = Color.Black,
                        selectedCardColor = Color.Blue,
                        unSelectedCardColor = Color.LightGray,
                        onDayClick = { day ->
                            Toast.makeText(context, day.toString(), Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}