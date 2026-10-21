import example

class StorageViewController: UIViewController {


    func foo1(picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [NSObject : AnyObject]) {
        if let pickedImage = info[UIImagePickerControllerOriginalImage] as? UIImage {
            imageView.contentMode = .ScaleAspectFit
            imageView.image = pickedImage
        }
        // ruleid: ios.akabe1.insecure-storage
        UIImageWriteToSavedPhotosAlbum(pickedImage!, self, nil, nil)
        dismissViewControllerAnimated(true, completion: nil)
    }


    func foo2() {
        // ruleid: ios.akabe1.insecure-storage
        let plistName = "secretfile.plist"
        let filePath = URL(fileURLWithPath: Bundle.main.resourcePath! + "/" + plistName)
        let encodedData = try PropertyListEncoder().encode(self)
        let succeed = encodedData.write(to: filePath)

    }


    func foo3() {
        var myDict: NSDictionary?
        // ruleid: ios.akabe1.insecure-storage
        let path = NSBundle.mainBundle().pathForResource("Config", ofType: "plist")
        myDict = NSDictionary(contentsOfFile: path)
    }



    func foo4() {
        var test = "secret_test"
        // ruleid: ios.akabe1.insecure-storage
        UserDefaults.standard.set(test, forKey: "PIN")
    }

    func foo5() {
        let passphrase = getPass()
        // ruleid: ios.akabe1.insecure-storage
        UserDefaults.standard.set(passphrase, forKey: "passphrase")
        // ruleid: ios.akabe1.insecure-storage
        UserDefaults.standard.set(passphrase, forKey: "pass_phrase")
    }


}
