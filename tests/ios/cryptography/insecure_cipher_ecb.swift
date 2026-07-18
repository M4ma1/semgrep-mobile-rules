import CommonCrypto

// ruleid: ios.insecure_cipher_ecb
let ecb_mode: CCMode = CCMode(kCCModeECB)
// ruleid: ios.insecure_cipher_ecb
let ecb_options = CCOptions(kCCOptionECBMode)