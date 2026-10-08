public class WebAppInterface {
    Context mContext;
    public void test1(){
        MSTG_ENV_008_JS_Interface jsInterface = new MSTG_ENV_008_JS_Interface(this);
        // ruleid: MSTG-PLATFORM-7_2
        myWebView.addJavascriptInterface(jsInterface, "Android");
    }
}
public class WebAppInterface extends WebView {
    Context mContext;
    public void test2(){
        // ruleid: MSTG-PLATFORM-7_2
        addJavascriptInterface(new MSTG_ENV_008_JS_Interface(this), "Android");
    }
    public void test3(){
        // ruleid: MSTG-PLATFORM-7_2
        this.addJavascriptInterface(new MSTG_ENV_008_JS_Interface(this), "Android");
    }
}

// Cases ported from android.mobsf.webview_javascript_interface and android.owasp.webview-bridges-setup
public class HelloWebApp extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        // ruleid: MSTG-PLATFORM-7_2
        webView.addJavascriptInterface(new testClass(), "jsinterface");
        webView.loadUrl("file:///android_asset/www/index.html");
    }
    public void noJs(WebView wv) {
        wv.getSettings().setJavaScriptEnabled(false);
        // ruleid: MSTG-PLATFORM-7_2
        wv.addJavascriptInterface(new testClass(), "jsinterface2");
    }
    public void extraArgs(WebView wv, Object o) {
        // ruleid: MSTG-PLATFORM-7_2
        wv.addJavascriptInterface(o, "jsinterface3", extra);
        // ruleid: MSTG-PLATFORM-7_2
        getWebView().addJavascriptInterface(new testClass(), "jsinterface4");
        // ok: MSTG-PLATFORM-7_2
        wv.removeJavascriptInterface("jsinterface");
    }
}
