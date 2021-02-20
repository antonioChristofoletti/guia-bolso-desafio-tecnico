package general.utils

import java.time.YearMonth
import java.util.Calendar
import java.util.Date
import kotlin.random.Random

abstract class DateUtils {
    companion object {

        fun getRandomMonth() = Random.nextInt(1, 13)
        private fun getRandomYear() = Random.nextInt(1900, YearMonth.now().year + 1)
        private fun getRandomDay(month: Int, year: Int) = Random.nextInt(1, YearMonth.of(year, month).lengthOfMonth() + 1)

        fun createRandomDate(month: Int = getRandomMonth(), year: Int = getRandomYear(), day: Int = getRandomDay(month, year)): Date {
            val hour = Random.nextInt(0, 23 + 1)
            val minute = Random.nextInt(0, 59 + 1)
            val second = Random.nextInt(0, 59 + 1)

            return Calendar.getInstance().apply { set(year, month, day, hour, minute, second) }.time
        }
    }
}