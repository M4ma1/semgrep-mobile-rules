import example


// Check NoSql Injection
class NoSqlViewController: UIViewController {  

    func foo1(_ userContentController: WKUserContentController, didReceive message: WKScriptMessage) {
        let emailId = message.body as? String
        // ruleid: ios.akabe1.nosql-inj
        let email = realm.objects(Email.self).filter("id == '" + emailId + "'")
    }

    
    func foo2() {
        // ok: ios.akabe1.nosql-inj
        let email = realm.objects(Email.self).filter("id == '" + "1234" + "'")
    }


}


