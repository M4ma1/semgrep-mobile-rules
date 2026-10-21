let context = LAContext()

// ok: ios.gitlab.rules_lgpl_swift_other_rule-ios-biometric-acl
if context.biometryType == .biometryAny {
    print("Biometric authentication is available")
}

var accessControl: SecAccessControl?

// ok: ios.gitlab.rules_lgpl_swift_other_rule-ios-biometric-acl
let flags: SecAccessControlCreateFlags = [.biometryAny, .userPresence]

// ruleid: ios.gitlab.rules_lgpl_swift_other_rule-ios-biometric-acl
let status = SecAccessControlCreateWithFlags(kCFAllocatorDefault, kSecAttrAccessibleWhenUnlockedThisDeviceOnly, .biometryAny, &accessControl)

// ok: ios.gitlab.rules_lgpl_swift_other_rule-ios-biometric-acl
let status2 = SecAccessControlCreateWithFlags(kCFAllocatorDefault, kSecAttrAccessibleWhenUnlockedThisDeviceOnly, .biometryCurrentSet, &accessControl)

// ruleid: ios.gitlab.rules_lgpl_swift_other_rule-ios-biometric-acl
let insecureFlags: SecAccessControlCreateFlags = .biometryAny
let status3 = SecAccessControlCreateWithFlags(kCFAllocatorDefault, kSecAttrAccessibleWhenUnlockedThisDeviceOnly, insecureFlags, &accessControl)

// ruleid: ios.gitlab.rules_lgpl_swift_other_rule-ios-biometric-acl
let insecureFlagsArray: SecAccessControlCreateFlags = [.userPresence, .privateKeyUsage]
let status4 = SecAccessControlCreateWithFlags(kCFAllocatorDefault, kSecAttrAccessibleWhenUnlockedThisDeviceOnly, insecureFlagsArray, &accessControl)

// ok: ios.gitlab.rules_lgpl_swift_other_rule-ios-biometric-acl
let secureFlags: SecAccessControlCreateFlags = .biometryCurrentSet
let status5 = SecAccessControlCreateWithFlags(kCFAllocatorDefault, kSecAttrAccessibleWhenUnlockedThisDeviceOnly, secureFlags, &accessControl)

// ruleid: ios.gitlab.rules_lgpl_swift_other_rule-ios-biometric-acl
let status6 = SecAccessControlCreateWithFlags(kCFAllocatorDefault, kSecAttrAccessibleWhenUnlockedThisDeviceOnly, .userPresence, &accessControl)

// ruleid: ios.gitlab.rules_lgpl_swift_other_rule-ios-biometric-acl
let status7 = SecAccessControlCreateWithFlags(kCFAllocatorDefault, kSecAttrAccessibleWhenUnlockedThisDeviceOnly, .touchIDAny, &accessControl)


// --- legacy C-constant spellings ---

func cconst_biometryAny() {
    var error: Unmanaged<CFError>?
    // ruleid: ios.gitlab.rules_lgpl_swift_other_rule-ios-biometric-acl
    let accessControl = SecAccessControlCreateWithFlags(kCFAllocatorDefault, kSecAttrAccessibleWhenPasscodeSetThisDeviceOnly, kSecAccessControlBiometryAny, &error)
}

func cconst_touchIDAny_force_unwrap() {
    var error: Unmanaged<CFError>?
    // ruleid: ios.gitlab.rules_lgpl_swift_other_rule-ios-biometric-acl
    let accessControl = SecAccessControlCreateWithFlags(kCFAllocatorDefault, kSecAttrAccessibleWhenPasscodeSetThisDeviceOnly, kSecAccessControlTouchIDAny, &error)!
}

func cconst_userPresence_guard_let() {
    var error: Unmanaged<CFError>?
    // ruleid: ios.gitlab.rules_lgpl_swift_other_rule-ios-biometric-acl
    guard let accessControl = SecAccessControlCreateWithFlags(kCFAllocatorDefault, kSecAttrAccessibleWhenPasscodeSetThisDeviceOnly, kSecAccessControlUserPresence, &error) else {
        return
    }
}

func cconst_biometryAny_two_step() {
    var accessControl: SecAccessControl?
    // ruleid: ios.gitlab.rules_lgpl_swift_other_rule-ios-biometric-acl
    let insecureFlags = kSecAccessControlBiometryAny
    let status = SecAccessControlCreateWithFlags(kCFAllocatorDefault, kSecAttrAccessibleWhenUnlockedThisDeviceOnly, insecureFlags, &accessControl)
}

// --- .watch (allows auth via a paired Apple Watch) ---

func dot_watch() {
    var accessControl: SecAccessControl?
    // ruleid: ios.gitlab.rules_lgpl_swift_other_rule-ios-biometric-acl
    let status = SecAccessControlCreateWithFlags(kCFAllocatorDefault, kSecAttrAccessibleWhenUnlockedThisDeviceOnly, .watch, &accessControl)
}

func qualified_watch() {
    var accessControl: SecAccessControl?
    // ruleid: ios.gitlab.rules_lgpl_swift_other_rule-ios-biometric-acl
    let status = SecAccessControlCreateWithFlags(kCFAllocatorDefault, kSecAttrAccessibleWhenUnlockedThisDeviceOnly, SecAccessControlCreateFlags.watch, &accessControl)
}

func cconst_watch() {
    var error: Unmanaged<CFError>?
    // ruleid: ios.gitlab.rules_lgpl_swift_other_rule-ios-biometric-acl
    let accessControl = SecAccessControlCreateWithFlags(kCFAllocatorDefault, kSecAttrAccessibleWhenPasscodeSetThisDeviceOnly, kSecAccessControlWatch, &error)
}

// --- .touchIDCurrentSet: deprecated NAME for the secure flag, not itself weak, but flagged for modernization ---

func dot_touchIDCurrentSet_force_unwrap() {
    var error: Unmanaged<CFError>?
    // ruleid: ios.gitlab.rules_lgpl_swift_other_rule-ios-biometric-acl
    let accessControl = SecAccessControlCreateWithFlags(kCFAllocatorDefault, kSecAttrAccessibleWhenPasscodeSetThisDeviceOnly, .touchIDCurrentSet, &error)!
}

func watch_and_touchIDCurrentSet_guard_let_force_unwrap() {
    var error: Unmanaged<CFError>?
    // ruleid: ios.gitlab.rules_lgpl_swift_other_rule-ios-biometric-acl
    guard let accessControl = SecAccessControlCreateWithFlags(kCFAllocatorDefault, SecAccessControlCreateFlags.watch, .touchIDCurrentSet, &error)! else {
        return
    }
}

func cconst_touchIDCurrentSet_safe_use() {
    var error: Unmanaged<CFError>?
    // NOTE: kSecAccessControlTouchIDCurrentSet IS flagged by this rule (see the case above) - this
    // function intentionally uses the modern, non-deprecated spelling to confirm it stays clean.
    // ok: ios.gitlab.rules_lgpl_swift_other_rule-ios-biometric-acl
    let accessControl = SecAccessControlCreateWithFlags(kCFAllocatorDefault, kSecAttrAccessibleWhenPasscodeSetThisDeviceOnly, kSecAccessControlBiometryCurrentSet, &error)
}
