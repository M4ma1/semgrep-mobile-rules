import UIKit

// ruleid: ios.insecure_pasteboard
let pasteboard = UIPasteboard.general

// ok: ios.insecure_pasteboard
let otherpasteboard = UIPasteboard.withUniqueName()

// ruleid: ios.insecure_pasteboard
if UIPasteboard.general.hasStrings {
    print("has strings")
}