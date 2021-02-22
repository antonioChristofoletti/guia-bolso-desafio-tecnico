package general.utils

import java.time.YearMonth
import java.util.Calendar
import java.util.Date
import kotlin.random.Random

abstract class DateUtils {
    companion object {
        fun getRandomMonth() = Random.nextInt(1, 13)
        fun getRandomYear() = Random.nextInt(1900, YearMonth.now().year + 1)
        fun getRandomDay(month: Int, year: Int) = Random.nextInt(1, YearMonth.of(year, month).lengthOfMonth() + 1)
        fun getRandomHour() = Random.nextInt(0, 24)
        fun getRandomMinute() = Random.nextInt(0, 60)
        fun getRandomSecond() = Random.nextInt(0, 60)

        fun createRandomDate(month: Int = getRandomMonth(), year: Int = getRandomYear(), day: Int = getRandomDay(month, year)): Date {
            return Calendar.getInstance().apply {
                set(year, month-1, day, getRandomHour(), getRandomMinute(), getRandomSecond())
                set(Calendar.MILLISECOND, 0);
            }.time
        }

        fun getFirstMonthMoment(month: Int, year: Int): Date {
            return Calendar.getInstance().apply {
                set(year, month - 1, 1, 0, 0, 0)
                set(Calendar.MILLISECOND, 0)
            }.time
        }

        fun getLastMonthMoment(month: Int, year: Int): Date {
            return Calendar.getInstance().apply {
                set(year, month - 1, YearMonth.of(year, month).lengthOfMonth(), 23, 59, 59)
                set(Calendar.MILLISECOND, 999)
            }.time
        }
    }
}