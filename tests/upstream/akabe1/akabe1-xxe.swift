import example


// Check XXE
class XXEViewController: ViewController {

    // ruleid: ios.akabe1.xxe
    func foo1() {
        var success: Bool
        // ruleid: ios.akabe1.xxe
        var rawXmlConvToData: NSData = rawXml.data(using: NSUTF8StringEncoding)
        var myParser: XMLParser = NSXMLParser(data: rawXmlConvToData)
        myParser.shouldResolveExternalEntities = true
        myParser.delegate = self
        myParser.parse()
    }




    func foo2(xml: String) {
        // ruleid: ios.akabe1.xxe
        parser = NSXMLParser(data: rawXml.dataUsingEncoding(NSUTF8StringEncoding)!)
        parser.delegate = self
        parser.shouldResolveExternalEntities = true
        parser.parse()
    }



    func foo3(xml: String) {
        parser = NSXMLParser(data: rawXml.dataUsingEncoding(NSUTF8StringEncoding)!)
        parser.delegate = self
        // ok: ios.akabe1.xxe
        parser.parse()
    }


    func foo4(xml: String) {
        parser = NSXMLParser(data: rawXml.dataUsingEncoding(NSUTF8StringEncoding)!)
        parser.delegate = self
        // ok: ios.akabe1.xxe
        parser.shouldResolveExternalEntities = false
        parser.parse()
    }

}


