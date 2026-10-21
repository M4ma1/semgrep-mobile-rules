import example



// Check Log Injection
class LogViewController: UIViewController {
    var name: String = ""
    @IBOutlet weak var labelName: UILabel!
    @IBOutlet weak var textFieldName: UITextField!

    @IBAction func foo1(sender: UIButton) {
        let name = textFieldName.text!
        NSLog("Input value = %@", textFieldName.text)
        labelName.text = "Hello \(name)"
    }
}



// ruleid: ios.akabe1.log-inj
class LogViewController: UIViewController {
    @IBOutlet weak var label: NSTextField!

    @IBAction func foo2(sender: UIButton) {
        NSLog("Input value = %@", label.stringValue)
    }


    @IBAction func foo3() {
        NSLog("Input value = %@", label.stringValue)
    }

}




// ruleid: ios.akabe1.log-inj
class LogViewController: UIViewController {
    @IBOutlet weak var txtUserInput: UITextField!

    override func viewDidLoad() {
        super.viewDidLoad()
    }

    func foo4() {
        //Read untrusted user input
        let injParam = txtUserInput.text
        //Try to conver user input to into integer
        let num = Int(injParam)
        //Then log unvalidated user input in case of failure
        if num == nil {
            NSLog("Input value = %@", injParam)
        }
    }

}


class LogViewController: UIViewController {

    func foo5(_ webView: UIWebView) {
        // ruleid: ios.akabe1.log-inj
        let html = webView.stringByEvaluatingJavaScript(from: "document.body.innerHTML")
        NSLog("Input value = %@", html)
    }


    func foo6(_ webView: UIWebView) {
        // ruleid: ios.akabe1.log-inj
        let passwordNameValue = webview.stringByEvaluatingJavaScript(from: "document.getElementById('password').value").value
        NSLog("Input value = %@", passwordNameValue)
    }



    func foo7(webView: WKWebView, navigationAction: WKNavigationAction) {
        // ruleid: ios.akabe1.log-inj
        let urlStr = navigationAction.request.url?.absoluteString
        let components = URLComponents(url: urlStr, resolvingAgainstBaseURL: false)
        NSLog("Query value = %@", components.query)
        NSLog("Host value = %@", components.host)
    }


    func foo8(webView: WKWebView, navigationAction: WKNavigationAction) {
        let urlStr = navigationAction.request.url?.absoluteString
        let components = URLComponents(url: urlStr, resolvingAgainstBaseURL: false)
        if let components = components {
            components.host
            components.query
            components.percentEncodedQuery
            // ruleid: ios.akabe1.log-inj
            let queryItems = components.queryItems
                for queryItem in queryItems {
                    NSLog("Input nmae = %@", queryItem.name)
                    NSLog("Input value = %@", queryItem.value)
                }
       }
    }



    func foo9(webView: WKWebView) {
        // ruleid: ios.akabe1.log-inj
        let urlString = webView.request!.url!.absoluteString
        NSLog("Input value = %@", urlString)
    }


    func foo10(webView: WKWebView, navigationAction: WKNavigationAction) {
        // Get the current URL
        // ruleid: ios.akabe1.log-inj
        let urlStr = navigationAction.request.url?.absoluteString
        NSLog("Input value = %@", urlStr)
    }


    func foo11(webView: UIWebView) {
        // Get the current URL
        // ruleid: ios.akabe1.log-inj
        let url = WebView.request?.mainDocumentURL
        NSLog("Input value = %@", url)
    }


    func foo12(webView: UIWebView) {
        // Get the current URL
        // ruleid: ios.akabe1.log-inj
        let url = webView.stringByEvaluatingJavaScriptFromString("window.location.href")!
        NSLog("Input value = %@", url)
    }
}

