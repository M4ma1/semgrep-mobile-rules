import CommonCrypto

// ruleid: ios.insecure_cipher_rc4
let rc4_mode: CCMode = CCMode(kCCModeRC4)
// ruleid: ios.insecure_cipher_rc4
let rc4 = CCAlgorithm(kCCAlgorithmRC4)