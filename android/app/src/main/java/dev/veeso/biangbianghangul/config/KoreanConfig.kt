package dev.veeso.biangbianghangul.config

import android.content.Context
import dev.veeso.biangbianghangul.services.HangulRomanizer
import dev.veeso.biangbiangui.config.BiangBiangConfig
import dev.veeso.biangbiangui.config.Branding
import dev.veeso.biangbiangui.config.FeatureFlags
import dev.veeso.biangbiangui.config.LanguageProfile
import dev.veeso.biangbiangui.config.LanguageVariant
import dev.veeso.biangbiangui.config.OcrRecognizer

/**
 * The complete [BiangBiangConfig] for BiangBiang Hangul: one Korean
 * [LanguageProfile] with a single variant. The library renders every screen
 * from this data. The [context] parameter is kept for call-site stability
 * even though the Korean profile needs no asset-backed dictionary. Logo
 * asset names are the app's `drawable` resource names (`logo`,
 * `logo_button_ico`).
 */
fun koreanConfig(context: Context): BiangBiangConfig {
    val romanizer = HangulRomanizer()
    return BiangBiangConfig(
        branding = Branding(
            appName = "BiangBiang Hangul",
            accentColorHex = "#003478",
            logoAssetName = "logo",
            buttonLogoAssetName = "logo_button_ico",
            githubRepo = "veeso/BiangBiang-Hangul",
            supportEmail = "info@veeso.dev",
            appStoreId = "",
            playStoreId = "dev.veeso.biangbianghangul",
        ),
        languages = listOf(
            LanguageProfile(
                id = "korean",
                displayName = "Korean",
                scriptRanges = listOf(0xAC00u..0xD7A3u),
                ocrRecognizer = OcrRecognizer.KOREAN,
                variants = listOf(
                    LanguageVariant(
                        id = "korean",
                        displayName = "Korean",
                        transliterator = romanizer,
                        ttsLanguageCode = "ko",
                        translatable = true,
                    ),
                ),
            ),
        ),
        extraSettings = emptyList(),
        plugins = emptyList(),
        features = FeatureFlags(),
        strings = mapOf(
            "inputTitle" to "Hangul",
            "outputTitle" to "Romanization",
            "appSubtitle" to "Convert Hangul to Romanization",
        ),
    )
}
