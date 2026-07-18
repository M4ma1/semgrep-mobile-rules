import LocalAuthentication

let context = LAContext()
// ruleid: ios.improper_biometric
context.evaluatePolicy(.deviceOwnerAuthenticationWithBiometrics, localizedReason: "Reason") { success, error in }