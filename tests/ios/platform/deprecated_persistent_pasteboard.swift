import UIKit


// ruleid: ios.deprecated_persistent_pasteboard
UIPasteboard.withUniqueName().setPersistent(true)

// ok: ios.deprecated_persistent_pasteboard
UIPasteboard.withUniqueName().setPersistent(false)

let pasteboard = UIPasteboard.withUniqueName()
// ruleid: ios.deprecated_persistent_pasteboard
pasteboard.setPersistent(true)
// ok: ios.deprecated_persistent_pasteboard
pasteboard.setPersistent(false)