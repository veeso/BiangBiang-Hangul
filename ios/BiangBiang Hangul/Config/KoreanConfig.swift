//
//  KoreanConfig.swift
//  BiangBiang Hangul
//
//  The complete `BiangBiangConfig` for BiangBiang Hangul: one Korean
//  `LanguageProfile` with a single variant. The library renders every
//  screen from this data.
//

import BiangBiangUI

enum KoreanConfig {
    @MainActor
    static let koreanConfig: BiangBiangConfig = .init(
        branding: Branding(
            appName: "BiangBiang Hangul",
            accentColorHex: "#003478",
            logoAssetName: "Logo",
            buttonLogoAssetName: "ico_button",
            githubRepo: "veeso/BiangBiang-Hangul",
            supportEmail: "info@veeso.dev",
            appStoreId: "6782341879",
            playStoreId: "dev.veeso.biangbianghangul"
        ),
        languages: [
            LanguageProfile(
                id: "korean",
                displayName: "Korean",
                scriptRanges: [0xAC00 ... 0xD7A3],
                ocrRecognizer: .korean,
                variants: [
                    LanguageVariant(
                        id: "korean",
                        displayName: "Korean",
                        transliterator: HangulRomanizer(),
                        ttsLanguageCode: "ko-KR",
                        translatable: true
                    ),
                ]
            ),
        ],
        extraSettings: [],
        plugins: [],
        features: FeatureFlags(),
        strings: [
            "inputTitle": "Hangul",
            "outputTitle": "Romanization",
            "appSubtitle": "Convert Hangul to Romanization",
        ]
    )
}
