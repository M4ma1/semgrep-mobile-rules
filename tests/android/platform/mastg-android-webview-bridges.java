import android.webkit.JavascriptInterface;

public class Bridge {
    // ruleid: android.owasp.webview-bridges-javascriptinterface
    @JavascriptInterface
    public String publicMethod() { return ""; }

    // ruleid: android.owasp.webview-bridges-javascriptinterface
    @JavascriptInterface
    String packageMethod() { return ""; }

    // ok: android.owasp.webview-bridges-javascriptinterface
    public String notExposed() { return ""; }
}
