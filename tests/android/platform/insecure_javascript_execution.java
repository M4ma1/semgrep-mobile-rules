public class MainActivity extends AppCompatActivity {
    WebView webView;
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        WebSettings settings = webView.getSettings();
        // ruleid: android.insecure_javascript_execution
        settings.setJavaScriptEnabled(true);
        setContentView(webView);
        
        WebView webview2 = new WebView(this);
        setContentView(webview2);
        // ruleid: android.insecure_javascript_execution
        webview2.getSettings().setJavaScriptEnabled(true);
 
    }
}