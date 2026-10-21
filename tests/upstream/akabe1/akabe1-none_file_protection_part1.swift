import example


// Check None File Protection (setAttributes-based)
class FPViewController: FPViewController {


    func foo1() {
        let documentsPath = NSURL(fileURLWithPath:   NSSearchPathForDirectoriesInDomains(.DocumentDirectory, .UserDomainMask, true)[0])
        let filename = "\(documentsPath)/tmp_activeTrans.txt"
        // ruleid: ios.akabe1.none-file-protection-part1
        let protection = [NSFileProtectionKey: NSFileProtectionNone]
        do {
            try NSFileManager.defaultManager().setAttributes(protection, ofItemAtPath: filename)
        } catch let error as NSError {
            NSLog("Unable to change attributes: \(error.debugDescription)")
        }
        try textToWrite.write(filename, atomically:true)
    }



    func foo2() {
        let documentsPath = NSURL(fileURLWithPath: NSSearchPathForDirectoriesInDomains(.DocumentDirectory, .UserDomainMask, true)[0])
        let filename = "\(documentsPath)/tmp_activeTrans.txt"
        // ruleid: ios.akabe1.none-file-protection-part1
        try textData.writeToFile(filepath, options: FileProtectionType.DataWritingFileProtectionNone);
    }



    func foo3() {
        try FileManager.default.setAttributes([.protectionKey: FileProtectionType.complete], ofItemAtPath: fileURL.path)
        // ok: ios.akabe1.none-file-protection-part1
        try (fileURL as NSURL).setResourceValue(URLFileProtection.complete, forKey: .fileProtectionKey)
    }

}
