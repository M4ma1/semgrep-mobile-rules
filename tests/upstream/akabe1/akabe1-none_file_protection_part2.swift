import example


// Check None File Protection (createFile-based)
class FPViewController2: FPViewController2 {

    func foo4() {
        // ruleid: ios.akabe1.none-file-protection-part2
        FileManager.default.createFile(atPath: filePath, contents: "secret text".data(using: .utf8), attributes: [FileAttributeKey.protectionKey: FileProtectionType.none]
)
    }

    func foo5() {
        // ok: ios.akabe1.none-file-protection-part2
        FileManager.default.createFile(atPath: filePath, contents: "secret text".data(using: .utf8), attributes: [FileAttributeKey.protectionKey: FileProtectionType.complete]
)
    }

}
