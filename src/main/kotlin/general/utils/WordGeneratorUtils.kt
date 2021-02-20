package general.utils

import kotlin.random.Random

abstract class WordGeneratorUtils {
    companion object {
        internal data class MinMaxValues(val min: Int, val max: Int)

        private val MIN_MAX_SYLLABLE = MinMaxValues(2, 4)
        private val MIN_MAX_WORD = MinMaxValues(2, 4)

        private enum class Vowels() {
            a, e, i, o, u
        }

        private enum class Consonants() {
            b, c, ç, ch, d, f, g, h, j, k, l, m, n, p, qu, r, s, sh, t, v, x, y, w, z
        }

        private fun getRandomLetter(listLetters: List<String>) = listLetters[Random.nextInt(0, listLetters.size)]

        private fun getRandomVowel(vararg ignoreItemList: String) = getRandomLetter(Vowels.values().map { it.name }.filter { !ignoreItemList.contains(it) })

        private fun getRandomConsonant() = getRandomLetter(Consonants.values().map { it.name })

        private fun createSyllable(): String {
            val consonant = getRandomConsonant()

            val vowel = when (consonant) {
                Consonants.qu.name -> getRandomVowel(Vowels.u.name)
                else -> getRandomVowel()
            }

            return "$consonant${vowel}"
        }

        private fun createSequenceString(minMaxValues: MinMaxValues, createString: () -> String, spaceAmongThem: String): String {
            val quantity = Random.nextInt(minMaxValues.min, minMaxValues.max+1)
            return (0..quantity).asSequence().map { createString() }.reduce { acc, s -> "$acc$spaceAmongThem$s" }
        }

        fun createWord() = createSequenceString(MIN_MAX_SYLLABLE, { createSyllable() }, "")

        fun createPhrase() = createSequenceString(MIN_MAX_WORD, { createWord() }, " ")
    }
}

fun main() {
    (0..1000).asSequence().forEach { _ ->
        println(WordGeneratorUtils.createPhrase())
    }
}