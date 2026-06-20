package dev.veeso.biangbianghangul

import dev.veeso.biangbianghangul.services.HangulRomanizer
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Span-level parity for the Hangul romaniser. The library's
 * `TextProcessingEngine` owns span detection / passthrough / spacing, so
 * these assert Revised Romanization of an already-isolated Hangul span only,
 * kept at exact parity with the iOS implementation.
 */
class HangulRomanizerParityTest {
    private val t = HangulRomanizer()

    @Test fun annyeong() = assertEquals("annyeong", t.transliterate("안녕"))

    @Test fun sarang() = assertEquals("sarang", t.transliterate("사랑"))

    @Test fun hanguk() = assertEquals("hanguk", t.transliterate("한국"))

    @Test fun gamsa() = assertEquals("gamsa", t.transliterate("감사"))

    @Test fun nonHangulPreservedVerbatim() =
        assertEquals("Hello 123!", t.transliterate("Hello 123!"))

    @Test fun mixedSpanPassesThroughNonHangul() =
        assertEquals("Ahan-guk", t.transliterate("A한-국"))
}
