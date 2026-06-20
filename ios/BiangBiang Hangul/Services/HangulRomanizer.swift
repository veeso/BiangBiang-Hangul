//
//  HangulRomanizer.swift
//  BiangBiang Hangul
//
//  Korean romanisation (Revised Romanization of Korean). The library's
//  `TextProcessingEngine` owns span detection, passthrough and spacing;
//  this only romanises one isolated script span. Each Hangul syllable in
//  the range U+AC00...U+D7A3 is algorithmically decomposed into its
//  initial, medial and final jamo and mapped to Latin letters. The
//  implementation mirrors the Android `TextProcessor` for exact parity.
//

import BiangBiangUI
import Foundation

struct HangulRomanizer: Transliterator {
    private static let initials = [
        "g", "kk", "n", "d", "tt", "r", "m", "b", "pp", "s",
        "ss", "", "j", "jj", "ch", "k", "t", "p", "h",
    ]
    private static let medials = [
        "a", "ae", "ya", "yae", "eo", "e", "yeo", "ye", "o", "wa",
        "wae", "oe", "yo", "u", "wo", "we", "wi", "yu", "eu", "ui", "i",
    ]
    private static let finals = [
        "", "k", "k", "k", "n", "n", "n", "t", "l", "k",
        "m", "p", "t", "t", "p", "l", "m", "p", "p", "t",
        "t", "ng", "t", "t", "k", "t", "p", "h",
    ]

    private static let syllableBase: UInt32 = 0xAC00
    private static let syllableEnd: UInt32 = 0xD7A3

    func transliterate(_ scriptSpan: String) -> String {
        var result = ""
        for scalar in scriptSpan.unicodeScalars {
            let code = scalar.value
            guard code >= Self.syllableBase, code <= Self.syllableEnd else {
                result.unicodeScalars.append(scalar)
                continue
            }
            let s = Int(code - Self.syllableBase)
            let initial = s / 588
            let medial = (s % 588) / 28
            let final = s % 28
            result += Self.initials[initial]
            result += Self.medials[medial]
            result += Self.finals[final]
        }
        return result
    }
}
