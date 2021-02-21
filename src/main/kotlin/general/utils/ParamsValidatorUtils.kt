package general.utils

import io.javalin.core.validation.Validator

abstract class ParamsValidatorUtils {
    companion object {
        fun Validator<Int>.checkParamLowerThan(value: Double): Validator<Int> {
            return this.apply { check({ it <= value }, "The param value '${this.key}' needs to be lower or equal to $value") }
        }

        fun Validator<Int>.checkParamHigherThan(value: Double): Validator<Int> {
            return this.apply { check({ it >= value }, "The param value '${this.key}' needs to be higher or equal to $value") }
        }

        fun Validator<Int>.checkRange(minValue: Int? = null, maxValue: Int? = null): Validator<Int> {
            return this.apply {
                maxValue?.let { checkParamLowerThan(it.toDouble()) }
                minValue?.let { checkParamHigherThan(it.toDouble()) }
            }
        }

        fun Validator<Int>.checkMonth(): Validator<Int> {
            return this.apply {
                checkParamLowerThan(12.0)
                checkParamHigherThan(1.0)
            }
        }
    }
}