package general.utils

import io.javalin.core.validation.Validator

abstract class ParamsValidator {
    companion object {
        fun checkParamIntLowerThan(validator: Validator<Int>, value: Int) {
            validator.check({ it <= value }, "The param value ${validator.key} needs to be lower than $value")
        }

        fun checkParamIntHigherThan(validator: Validator<Int>, value: Int) {
            validator.check({ it >= value }, "The param value ${validator.key} needs to be higher than $value")
        }

        fun checkParamIntRange(validator: Validator<Int>, minValue: Int? = null, maxValue: Int? = null) {
            maxValue?.apply { checkParamIntLowerThan(validator, this) }
            minValue?.apply { checkParamIntHigherThan(validator, this) }
        }

        fun checkParamIntMonth(validator: Validator<Int>) {
            checkParamIntLowerThan(validator, 12)
            checkParamIntHigherThan(validator, 1)
        }
    }
}