package dev.veeso.biangbianghangul

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.veeso.biangbianghangul.config.koreanConfig
import dev.veeso.biangbiangui.ui.BiangBiangRoot

/**
 * Config-only entry point: the BiangBiangUI library renders every screen
 * and owns History, the rate prompt, TTS and the OCR pipeline (including
 * `registerLaunch`). The app supplies only [koreanConfig] + the Hangul
 * romaniser.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BiangBiangRoot(koreanConfig(this))
        }
    }
}
