package general.utils

import kotlin.random.Random

abstract class StringGeneratorUtils {
    companion object {
        class MinMaxValues(val min: Int, val max: Int = min) {
            fun getRandom() = when (min) {
                max -> max
                else -> Random.nextInt(min, max+1)
            }
        }

        private val DEFAULT_MIN_MAX_SYLLABLE = MinMaxValues(3, 4)
        private val DEFAULT_MIN_MAX_WORD = MinMaxValues(2, 4)

        private enum class Vowels { a, e, i, o, u }
        private enum class Consonants { b, c, ç, ch, d, f, g, h, j, k, l, m, n, p, q, qu, r, s, sh, t, v, x, y, w, z }

        private val vowelsList by lazy { Vowels.values().map { it.name } }
        private val consonantsList by lazy { Consonants.values().map { it.name } }

        private fun getRandomLetter(listLetters: List<String>) = listLetters[Random.nextInt(0, listLetters.size)]

        private fun getRandomVowel(vararg ignoreVowelList: String) = getRandomLetter(vowelsList.filter { !ignoreVowelList.contains(it) })

        private fun getRandomConsonant() = getRandomLetter(consonantsList)

        private fun createSyllable(): String {
            val consonant = getRandomConsonant()

            val vowel = when (consonant) {
                Consonants.qu.name -> getRandomVowel(Vowels.u.name)
                else -> getRandomVowel()
            }

            return "$consonant${vowel}"
        }

        private fun createSequenceString(minMaxValues: MinMaxValues, createString: () -> String, spaceBetweenThem: String): String {
            return (1..minMaxValues.getRandom()).map { createString() }.reduce { acc, s -> "$acc$spaceBetweenThem$s" }
        }

        fun createWord(minMaxValues: MinMaxValues = DEFAULT_MIN_MAX_SYLLABLE) = createSequenceString(minMaxValues, { createSyllable() }, "")

        fun createPhrase(minMaxSyllable: MinMaxValues = DEFAULT_MIN_MAX_SYLLABLE, minMaxWord: MinMaxValues = DEFAULT_MIN_MAX_WORD): String {
            return createSequenceString(minMaxWord, { createWord(minMaxSyllable) }, " ")
        }
    }
}