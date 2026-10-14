import android.webkit.WebView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val webView = WebView(this)
        // ruleid: MSTG-PLATFORM-5
        webView.settings.javaScriptEnabled = true
        // ruleid: MSTG-PLATFORM-5
        webView.settings.setJavaScriptEnabled(true)
        // ok: MSTG-PLATFORM-5
        webView.settings.javaScriptEnabled = false
        // ok: MSTG-PLATFORM-5
        webView.settings.setJavaScriptEnabled(false)
        webView.settings.apply {
            // ruleid: MSTG-PLATFORM-5
            javaScriptEnabled = true
        }
    }
}
