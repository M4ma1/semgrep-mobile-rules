import Foundation
import CommonCrypto
import CryptoKit

let value = "dummy"
let data = value.data(using: .utf8)!
var digest = [UInt8](repeating: 0, count: Int(CC_MD2_DIGEST_LENGTH))

var ctx = CC_MD2_CTX()
// ruleid: ios.insecure_hash_md2
CC_MD2_Init(&ctx)
// ruleid: ios.insecure_hash_md2
CC_MD2_Update(&ctx, value, CC_LONG(data.count))
// ruleid: ios.insecure_hash_md2
CC_MD2_Final(&digest, &ctx)

data.withUnsafeBytes {
    // ruleid: ios.insecure_hash_md2
    _ = CC_MD2($0.baseAddress, CC_LONG(data.count), &digest)
}