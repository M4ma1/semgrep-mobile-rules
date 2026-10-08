import android.webkit.WebView

class Bridge(val ctx: Context) {
    @JavascriptInterface
    fun hi() {}
}

class KWebView : WebView {
    constructor(c: Context) : super(c)

    fun exposed(wv: WebView, o: Any) {
        // ruleid: MSTG-PLATFORM-7_2
        wv.addJavascriptInterface(Bridge(ctx), "b1")
        // ruleid: MSTG-PLATFORM-7_2
        wv.addJavascriptInterface(o, "b2")
        // ruleid: MSTG-PLATFORM-7_2
        wv.addJavascriptInterface(o as Bridge, "b3")
        // ruleid: MSTG-PLATFORM-7_2
        this.addJavascriptInterface(Bridge(ctx), "b4")
        // ruleid: MSTG-PLATFORM-7_2
        addJavascriptInterface(Bridge(ctx), "b5")
        // ruleid: MSTG-PLATFORM-7_2
        super.addJavascriptInterface(Bridge(ctx), "b6")
        // ruleid: MSTG-PLATFORM-7_2
        getWebView().addJavascriptInterface(Bridge(ctx), "b7")
        // ruleid: MSTG-PLATFORM-7_2
        wv.also { it.addJavascriptInterface(Bridge(ctx), "b9") }
    }

    fun notExposed(wv: WebView) {
        // ok: MSTG-PLATFORM-7_2
        wv.removeJavascriptInterface("b1")
        // ok: MSTG-PLATFORM-7_2
        wv.getSettings().setJavaScriptEnabled(true)
    }
}

fun topLevel(w: WebView) {
    // ruleid: MSTG-PLATFORM-7_2
    w.addJavascriptInterface(Bridge(ctx), "top")
}
