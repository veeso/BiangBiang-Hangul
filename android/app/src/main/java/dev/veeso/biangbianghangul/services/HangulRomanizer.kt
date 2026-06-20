package dev.veeso.biangbianghangul.services

import dev.veeso.biangbiangui.protocols.Transliterator

/**
 * Korean romanisation following the Revised Romanization of Korean. The
 * library's [dev.veeso.biangbiangui.services.TextProcessingEngine] owns span
 * detection, passthrough and spacing; this only romanises one isolated
 * Hangul script span by decomposing each syllable block into its initial,
 * medial and final jamo. Syllables within a span are concatenated with no
 * inserted spaces. Implemented algorithmically (no external dependency) to
 * stay at exact parity with the iOS implementation.
 */
class HangulRomanizer : Transliterator {

    override fun transliterate(scriptSpan: String): String {
        val out = StringBuilder()
        for (ch in scriptSpan) {
            val code = ch.code
            if (code in 0xAC00..0xD7A3) {
                val s = code - 0xAC00
                val l = s / 588
                val v = (s % 588) / 28
                val t = s % 28
                out.append(INITIAL[l])
                out.append(MEDIAL[v])
                out.append(FINAL[t])
            } else {
                out.append(ch)
            }
        }
        return out.toString()
    }

    private companion object {
        val INITIAL = arrayOf(
            "g", "kk", "n", "d", "tt", "r", "m", "b", "pp", "s",
            "ss", "", "j", "jj", "ch", "k", "t", "p", "h",
        )
        val MEDIAL = arrayOf(
            "a", "ae", "ya", "yae", "eo", "e", "yeo", "ye", "o", "wa",
            "wae", "oe", "yo", "u", "wo", "we", "wi", "yu", "eu", "ui", "i",
        )
        val FINAL = arrayOf(
            "", "k", "k", "k", "n", "n", "n", "t", "l", "k",
            "m", "p", "t", "t", "p", "l", "m", "p", "p", "t",
            "t", "ng", "t", "t", "k", "t", "p", "h",
        )
    }
}
