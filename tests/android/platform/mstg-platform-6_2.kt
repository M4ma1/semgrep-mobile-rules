import android.webkit.WebSettings
import android.webkit.WebView

class KWebActivity : Activity() {
    fun flag(): Boolean = true

    fun setters(wv: WebView, b: Boolean) {
        val s = wv.settings
        // ruleid: MSTG-PLATFORM-6_2
        s.setAllowFileAccess(true)
        // ruleid: MSTG-PLATFORM-6_2
        s.setAllowContentAccess(true)
        // ruleid: MSTG-PLATFORM-6_2
        s.setAllowFileAccessFromFileURLs(b)
        // ruleid: MSTG-PLATFORM-6_2
        s.setAllowUniversalAccessFromFileURLs(flag())
        // ok: MSTG-PLATFORM-6_2
        s.setAllowFileAccess(false)
        // ok: MSTG-PLATFORM-6_2
        s.setAllowUniversalAccessFromFileURLs(false)
    }

    fun properties(wv: WebView, b: Boolean) {
        val s = wv.settings
        // ruleid: MSTG-PLATFORM-6_2
        s.allowFileAccess = true
        // ruleid: MSTG-PLATFORM-6_2
        s.allowContentAccess = true
        // ruleid: MSTG-PLATFORM-6_2
        s.allowFileAccessFromFileURLs = b
        // ruleid: MSTG-PLATFORM-6_2
        s.allowUniversalAccessFromFileURLs = true
        // ruleid: MSTG-PLATFORM-6_2
        wv.settings.allowUniversalAccessFromFileURLs = true
        // ok: MSTG-PLATFORM-6_2
        s.allowFileAccess = false
        // ok: MSTG-PLATFORM-6_2
        wv.settings.allowFileAccessFromFileURLs = false
        // ok: MSTG-PLATFORM-6_2
        s.javaScriptEnabled = true
    }

    fun scoped(wv: WebView) {
        wv.settings.apply {
            // ruleid: MSTG-PLATFORM-6_2
            allowFileAccessFromFileURLs = true
            // ruleid: MSTG-PLATFORM-6_2
            allowUniversalAccessFromFileURLs = true
            // ok: MSTG-PLATFORM-6_2
            allowFileAccess = false
        }
        val enabled = true
        // ruleid: MSTG-PLATFORM-6_2
        wv.settings.allowContentAccess = enabled
    }
}
