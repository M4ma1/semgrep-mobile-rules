import Foundation

func fileProtectionType_none() {
    // ruleid: ios.weak_file_protection
    let protection = [FileAttributeKey.protectionKey: FileProtectionType.none]
    // ruleid: ios.weak_file_protection
    let options = Data.WritingOptions.noFileProtection
    // ruleid: ios.weak_file_protection
    let value = URLFileProtection.none
    do {
        try FileManager.default.setAttributes(protection, ofItemAtPath: "dummy.txt")
        try Data().write(to: URL(string: "dummy.txt")!, options: options)
        try (URL(string: "dummy.txt")! as NSURL).setResourceValue(value, forKey: .fileProtectionKey)
    } catch  {}
}

func fileProtectionType_complete_unless_open() {
    // ruleid: ios.weak_file_protection
    let protection = [FileAttributeKey.protectionKey: FileProtectionType.completeUnlessOpen]
    // ruleid: ios.weak_file_protection
    let options = Data.WritingOptions.completeFileProtectionUnlessOpen
    // ruleid: ios.weak_file_protection
    let value = URLFileProtection.completeUnlessOpen
    do {
        try FileManager.default.setAttributes(protection, ofItemAtPath: "dummy.txt")
        try Data().write(to: URL(string: "dummy.txt")!, options: options)
        try (URL(string: "dummy.txt")! as NSURL).setResourceValue(value, forKey: .fileProtectionKey)
    } catch  {}
}

func complete_unless_open() {
    // ruleid: ios.weak_file_protection
    let protection: [FileAttributeKey : FileProtectionType] = [.protectionKey: .completeUnlessOpen]
    // ruleid: ios.weak_file_protection
    let options: Data.WritingOptions = .completeFileProtectionUnlessOpen
    // ruleid: ios.weak_file_protection
    let value: URLFileProtection = .completeUnlessOpen
    do {
        try FileManager.default.setAttributes(protection, ofItemAtPath: "dummy.txt")
        try Data().write(to: URL(string: "dummy.txt")!, options: options)
        try (URL(string: "dummy.txt")! as NSURL).setResourceValue(value, forKey: .fileProtectionKey)
    } catch  {}
}

func fileProtectionType_complete_until_first_user_authentication() {
    // ruleid: ios.weak_file_protection
    let protection = [FileAttributeKey.protectionKey: FileProtectionType.completeUntilFirstUserAuthentication]
    // ruleid: ios.weak_file_protection
    let options = Data.WritingOptions.completeFileProtectionUntilFirstUserAuthentication
    // ruleid: ios.weak_file_protection
    let value = URLFileProtection.completeUntilFirstUserAuthentication
    do {
        try FileManager.default.setAttributes(protection, ofItemAtPath: "dummy.txt")
        try Data().write(to: URL(string: "dummy.txt")!, options: options)
        try (URL(string: "dummy.txt")! as NSURL).setResourceValue(value, forKey: .fileProtectionKey)
    } catch  {}
}

func complete_until_first_user_authentication() {
    // ruleid: ios.weak_file_protection
    let protection: [FileAttributeKey : FileProtectionType] = [.protectionKey: .completeUntilFirstUserAuthentication]
    // ruleid: ios.weak_file_protection
    let options: Data.WritingOptions = .completeFileProtectionUntilFirstUserAuthentication
    // ruleid: ios.weak_file_protection
    let value: URLFileProtection = .completeUntilFirstUserAuthentication
    do {
        try FileManager.default.setAttributes(protection, ofItemAtPath: "dummy.txt")
        try Data().write(to: URL(string: "dummy.txt")!, options: options)
        try (URL(string: "dummy.txt")! as NSURL).setResourceValue(value, forKey: .fileProtectionKey)
    } catch  {}
}

func fileProtectionType_complete() {
    // ok: ios.weak_file_protection
    let protection = [FileAttributeKey.protectionKey: FileProtectionType.complete]
    // ok: ios.weak_file_protection
    let options = Data.WritingOptions.completeFileProtection
    // ok: ios.weak_file_protection
    let value = URLFileProtection.complete
    do {
        try FileManager.default.setAttributes(protection, ofItemAtPath: "dummy.txt")
        try Data().write(to: URL(string: "dummy.txt")!, options: options)
        try (URL(string: "dummy.txt")! as NSURL).setResourceValue(value, forKey: .fileProtectionKey)
    } catch  {}
}

func complete() {
    // ok: ios.weak_file_protection
    let protection: [FileAttributeKey : FileProtectionType] = [.protectionKey: .complete]
    // ok: ios.weak_file_protection
    let options: Data.WritingOptions = .completeFileProtection
    // ok: ios.weak_file_protection
    let value: URLFileProtection = .complete
    do {
        try FileManager.default.setAttributes(protection, ofItemAtPath: "dummy.txt")
        try Data().write(to: URL(string: "dummy.txt")!, options: options)
        try (URL(string: "dummy.txt")! as NSURL).setResourceValue(value, forKey: .fileProtectionKey)
    } catch  {}
}

// Legacy Objective-C-bridged constants (still valid in Swift), formerly only
// caught by the retired ios.akabe1.none-file-protection-part1/part2 and
// ios.gitlab...file-no-special rules.

func legacy_bare_constant_in_setAttributes() {
    let documentsPath = NSURL(fileURLWithPath: NSSearchPathForDirectoriesInDomains(.documentDirectory, .userDomainMask, true)[0])
    let filename = "\(documentsPath)/tmp_activeTrans.txt"
    // ruleid: ios.weak_file_protection
    let protection = [FileAttributeKey.protectionKey: NSFileProtectionNone]
    do {
        try FileManager.default.setAttributes(protection, ofItemAtPath: filename)
    } catch {}
}

func legacy_constant_outside_setAttributes_context() {
    // ruleid: ios.weak_file_protection
    someLegacyApi(protectionLevel: NSFileProtectionNone)
}

func legacy_dataWritingFileProtectionNone_dotform() {
    // ruleid: ios.weak_file_protection
    let options = Data.WritingOptions.dataWritingFileProtectionNone
    do {
        try Data().write(to: URL(string: "dummy.txt")!, options: options)
    } catch {}
}

func legacy_fixture_spelling_from_akabe1_test() {
    // This odd FileProtectionType.DataWritingFileProtectionNone spelling mirrors
    // the upstream akabe1 test fixture it replaces, kept for continuity.
    // ruleid: ios.weak_file_protection
    try? textData.writeToFile(filepath, options: FileProtectionType.DataWritingFileProtectionNone)
}

func safe_unrelated_legacy_lookalike() {
    // ok: ios.weak_file_protection
    let x = NSFileProtectionComplete
}
