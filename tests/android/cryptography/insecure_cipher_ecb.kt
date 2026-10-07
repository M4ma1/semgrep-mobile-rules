import javax.crypto.Cipher
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties

class EcbTests {
    val MODE = "AES/ECB/PKCS5Padding"

    fun vulnerable(k: Key) {
        // ruleid: android.insecure_cipher_ecb
        Cipher.getInstance("AES/ECB/PKCS5Padding")
        // ruleid: android.insecure_cipher_ecb
        val c1 = Cipher.getInstance("AES/ECB/NoPadding")
        // ruleid: android.insecure_cipher_ecb
        val c2: Cipher = Cipher.getInstance("AES/ECB/NoPadding")
        // ruleid: android.insecure_cipher_ecb
        val c3 = Cipher.getInstance("AES/ECB/PKCS5Padding", "BC")
        // ruleid: android.insecure_cipher_ecb
        val c4 = javax.crypto.Cipher.getInstance("AES/ECB/PKCS5Padding")
        // ruleid: android.insecure_cipher_ecb
        Cipher.getInstance("AES/ECB/PKCS5Padding").init(Cipher.ENCRYPT_MODE, k)
        // ruleid: android.insecure_cipher_ecb
        val c5 = Cipher.getInstance("DES/ECB/PKCS5Padding")
        // ruleid: android.insecure_cipher_ecb
        val c6 = Cipher.getInstance("Blowfish/ECB/NoPadding")
        // ruleid: android.insecure_cipher_ecb
        val c7 = Cipher.getInstance("AES/ecb/PKCS5Padding")
        // ruleid: android.insecure_cipher_ecb
        val c8 = Cipher.getInstance(MODE)
        // ruleid: android.insecure_cipher_ecb
        val c9 = Cipher.getInstance("AES")
    }

    fun keyStore() {
        // ruleid: android.insecure_cipher_ecb
        val spec = KeyGenParameterSpec.Builder("key", KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
            .setBlockModes(KeyProperties.BLOCK_MODE_ECB)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
            .build()
        // ok: android.insecure_cipher_ecb
        val ok = KeyGenParameterSpec.Builder("key", KeyProperties.PURPOSE_ENCRYPT)
            .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
            .build()
    }

    fun safe() {
        // ok: android.insecure_cipher_ecb
        val a = Cipher.getInstance("AES/GCM/NoPadding")
        // ok: android.insecure_cipher_ecb
        val b = Cipher.getInstance("AES/CBC/PKCS5Padding")
        // ok: android.insecure_cipher_ecb
        val d = Foo.getInstance("ECB")
        // RSA/ECB is only a naming convention, not block-cipher ECB
        // ok: android.insecure_cipher_ecb
        val e = Cipher.getInstance("RSA/ECB/PKCS1Padding")
        // ok: android.insecure_cipher_ecb
        val f = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding")
    }
}
