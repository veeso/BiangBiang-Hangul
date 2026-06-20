//
//  RomanizerTests.swift
//  BiangBiang Hangul
//
//  Span-level checks for the Hangul romanizer. The library's
//  `TextProcessingEngine` owns span detection / passthrough / spacing, so
//  these assert romanisation of an already-isolated script span only.
//

@testable import BiangBiang_Hangul
import Testing

struct HangulRomanizerTests {
    let t = HangulRomanizer()

    @Test func annyeong() {
        #expect(t.transliterate("안녕") == "annyeong")
    }

    @Test func sarang() {
        #expect(t.transliterate("사랑") == "sarang")
    }

    @Test func hanguk() {
        #expect(t.transliterate("한국") == "hanguk")
    }

    @Test func gamsa() {
        #expect(t.transliterate("감사") == "gamsa")
    }

    @Test func nonHangulPreservedVerbatim() {
        #expect(t.transliterate("A한B") == "AhanB")
    }
}
