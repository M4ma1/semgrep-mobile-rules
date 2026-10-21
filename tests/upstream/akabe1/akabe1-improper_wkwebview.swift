import example


// Check WKWebView 
class WKViewController: WKViewController {


    // ruleid: ios.akabe1.improper-wkwebview
    func foo1() -> Bool {
        let webView = WKWebView(frame: view.bounds)
        let url = URL(string: "https://www.test.com/test.js")!
        webView.loadData(URLRequest(url: url))
        webView.allowsBackForwardNavigationGestures = true
    }
    
    
    // False Negative at the moment "func $FUNC(...) {" is yet not supported in semgrep 
    func foo2(app: UIApplication, openURL url: NSURL, options: [String : AnyObject]) -> Bool {
        let name = inUrlName
        let html = "Hi \(name)"
        let webView = WKWebView()
        webView.loadHTMLString(html, baseURL:nil)
    }



    // ruleid: ios.akabe1.improper-wkwebview
    func foo3() -> Bool {
        let name = inUrlName
        let html = "Hi \(name)"
        let webView = WKWebView()
        webView.loadHTMLString(html, baseURL:nil)
    }

    
    
    func foo4() {
        let preferences = WKPreferences()
        preferences.javaScriptEnabled = false
        let config = WKWebViewConfiguration()
        config.preferences = preferences
        // ok: ios.akabe1.improper-wkwebview
        let webView = WKWebView(frame: view.bounds, configuration: config)
        let url = URL(string: "https://www.test.com/test.js")!
        webView.loadData(URLRequest(url: url))
        webView.allowsBackForwardNavigationGestures = true
    }
    
    
     func foo5() {
        let preferences = WKWebpagePreferences()
        preferences.allowsContentJavaScript = false
        // ok: ios.akabe1.improper-wkwebview
        let webView = WKWebView()
        let url = URL(string: "https://www.test.com/test.js")!
        webView.configuration.defaultWebpagePreferences = preferences
        webView.loadData(URLRequest(url: url))
    }



    func foo6() {
        let preferences = WKWebpagePreferences()
        preferences.allowsContentJavaScript = false
        // ruleid: ios.akabe1.improper-wkwebview
        preferences.allowUniversalAccessFromFileURLs = true
        let config = WKWebViewConfiguration()
        config.preferences = preferences
        let webView = WKWebView(frame: view.bounds, configuration: config)       
        let url = NSURL(string: "http://www.test.com/test.js")
        let urlRequest = NSURLRequest(URL: url!)
        webView.loadRequest(urlRequest)
        webView.navigationDelegate = self
        view.addSubview(webView)
    }
    
    
    
    
    func foo7() {
        let webView = WKWebView()       
        let url = NSURL(string: "http://www.test.com/test.js")
        let urlRequest = NSURLRequest(URL: url!)
        // ruleid: ios.akabe1.improper-wkwebview
        webView.configuration.preferences.setValue(true, forKey: "allowFileAccessFromFileURLs")
        webView.loadRequest(urlRequest)
    }
    
    
    
}


