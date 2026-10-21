import LocalAuthentication

let context = LAContext()
// ruleid: ios.improper_biometric
context.evaluatePolicy(.deviceOwnerAuthenticationWithBiometrics, localizedReason: "Reason") { success, error in }


func canEvaluatePolicy_guard_style() {
    let context = LAContext()
    var error: NSError?
    guard context.canEvaluatePolicy(.deviceOwnerAuthentication, error: &error) else {
        return
    }
    // ruleid: ios.improper_biometric
    context.evaluatePolicy(.deviceOwnerAuthentication, localizedReason: "Authenticate, please.") { success, error in
        if success {
            // Authentication success
        }
    }
}

func canEvaluatePolicy_if_style() {
    let context = LAContext()
    var error: NSError?
    let canEvaluate = context.canEvaluatePolicy(.deviceOwnerAuthenticationWithBiometrics, error: &error)
    if canEvaluate {
        // ruleid: ios.improper_biometric
        context.evaluatePolicy(.deviceOwnerAuthentication, localizedReason: "Authenticate, please.") { success, error in
            if success {
                // Authentication success
            }
        }
    }
}
