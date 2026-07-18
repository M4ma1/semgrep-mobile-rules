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