import android.webkit.JavascriptInterface

class Bridge {
    // ruleid: android.owasp.webview-bridges-javascriptinterface
    @JavascriptInterface
    fun blockBody(): String { return "" }

    // ruleid: android.owasp.webview-bridges-javascriptinterface
    @JavascriptInterface
    fun noReturnType() { }

    // ruleid: android.owasp.webview-bridges-javascriptinterface
    @JavascriptInterface
    fun exprBody() = "x"

    // ruleid: android.owasp.webview-bridges-javascriptinterface
    @JavascriptInterface
    fun withArgs(msg: String): String { return msg }

    // ruleid: android.owasp.webview-bridges-javascriptinterface
    @JavascriptInterface private fun inline(a: String) { }

    // ok: android.owasp.webview-bridges-javascriptinterface
    fun notExposed(): String { return "" }
}
