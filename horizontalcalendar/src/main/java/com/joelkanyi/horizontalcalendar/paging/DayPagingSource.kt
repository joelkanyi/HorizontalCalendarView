package com.joelkanyi.horizontalcalendar.paging

import android.annotation.SuppressLint
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.joelkanyi.horizontalcalendar.model.Day
import java.text.SimpleDateFormat
import java.util.*

class DayPagingSource(
    private val startYear: Int = 2023,
    private val endYear: Int = 2040,
) : PagingSource<Int, Day>() {

    private val calendar = Calendar.getInstance()

    @SuppressLint("SimpleDateFormat")
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy")

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Day> {
        val page = params.key ?: startYear

        val days = mutableListOf<Day>()

        // Iterate over the months of the year
        for (month in 0..11) {

            // Set the calendar to the first day of the month
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.YEAR, page)

            // Get the number of days in the month
            val numDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

            // Iterate over the days of the month
            for (day in 1..numDaysInMonth) {
                calendar.set(Calendar.DAY_OF_MONTH, day)
                val dayOfWeek = calendar.getDisplayName(
                    Calendar.DAY_OF_WEEK,
                    Calendar.SHORT,
                    Locale.getDefault()
                )
                val displayDate =
                    String.format("%02d", day) // Format the day to always have two digits
                val fullDate =
                    dateFormat.format(calendar.time) // Use the SimpleDateFormat to format the fullDate field
                val displayMonth = calendar.getDisplayName(
                    Calendar.MONTH,
                    Calendar.SHORT,
                    Locale.getDefault()
                )
                val year = calendar.get(Calendar.YEAR).toString()
                val day = Day(dayOfWeek, displayDate, fullDate, displayMonth, year)
                days.add(day)
            }
        }

        return LoadResult.Page(
            data = days,
            prevKey = if (page > startYear) page - 1 else null,
            nextKey = if (page < endYear) page + 1 else null
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Day>): Int? {
        return null
    }
}