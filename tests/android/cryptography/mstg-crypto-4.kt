import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKeyFactory

// ===== DES =====
// ruleid: MSTG-CRYPTO-4
val cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
// ruleid: MSTG-CRYPTO-4
val factory = SecretKeyFactory.getInstance("DES");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("DES")
// ruleid: MSTG-CRYPTO-4
foo(Cipher.getInstance("DES/CBC/PKCS5Padding"))
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("DES").init(1, key)
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("DES/CBC/PKCS5Padding", "SunJCE")
// ruleid: MSTG-CRYPTO-4
javax.crypto.Cipher.getInstance("DES")
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("PBEWithMD5AndDES")
// ruleid: MSTG-CRYPTO-4
KeyGenerator.getInstance("DES")
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("AES/CBC/PKCS5Padding")
// ok: MSTG-CRYPTO-4
Cipher.getInstance("RSA/ECB/PKCS1Padding")
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("3DES")
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("DESede")

// ===== 3DES =====
// ruleid: MSTG-CRYPTO-4
val cipher = Cipher.getInstance("3DES/CBC/NoPadding");
// ruleid: MSTG-CRYPTO-4
val cipher2 = Cipher.getInstance("DESede/CBC/NoPadding");
// ruleid: MSTG-CRYPTO-4
val cipher3 = Cipher.getInstance("DESEDEWRAP/CBC/NoPadding");
// ruleid: MSTG-CRYPTO-4
val factory = SecretKeyFactory.getInstance("DESede");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("DESede")
// ruleid: MSTG-CRYPTO-4
foo(Cipher.getInstance("DESede/ECB/PKCS5Padding"))
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("DESede").init(1, key)
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("DESede/ECB/PKCS5Padding", "SunJCE")
// ruleid: MSTG-CRYPTO-4
javax.crypto.Cipher.getInstance("DESede")
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("PBEWithSHA1AndDESede")
// ruleid: MSTG-CRYPTO-4
KeyGenerator.getInstance("DESede")
// ok: MSTG-CRYPTO-4
Cipher.getInstance("AES/GCM/NoPadding")
// ok: MSTG-CRYPTO-4
Cipher.getInstance("RSA/ECB/PKCS1Padding")
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("DES/CBC/NoPadding")

// ===== RC2 =====
// ruleid: MSTG-CRYPTO-4
val cipher = Cipher.getInstance("RC2/CBC/PKCS5Padding");
// ruleid: MSTG-CRYPTO-4
val factory = SecretKeyFactory.getInstance("RC2");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("RC2")
// ruleid: MSTG-CRYPTO-4
foo(Cipher.getInstance("RC2/ECB/PKCS5Padding"))
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("RC2").init(1, key)
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("RC2/ECB/PKCS5Padding", "SunJCE")
// ruleid: MSTG-CRYPTO-4
javax.crypto.Cipher.getInstance("RC2")
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("PBEWithSHA1AndRC2_40")
// ruleid: MSTG-CRYPTO-4
KeyGenerator.getInstance("RC2")
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("AES/CBC/PKCS5Padding")
// ok: MSTG-CRYPTO-4
Cipher.getInstance("RSA/ECB/PKCS1Padding")
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("RC4")

// ===== RC4 =====
// ruleid: MSTG-CRYPTO-4
val cipher = Cipher.getInstance("RC4/CBC/PKCS5Padding");
// ruleid: MSTG-CRYPTO-4
val factory = SecretKeyFactory.getInstance("RC4");
// ruleid: MSTG-CRYPTO-4
val factory_2 = SecretKeyFactory.getInstance("ARCFOUR");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("RC4")
// ruleid: MSTG-CRYPTO-4
foo(Cipher.getInstance("ARCFOUR/ECB/NOPADDING"))
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("RC4").init(1, key)
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("ARCFOUR/ECB/NOPADDING", "SunJCE")
// ruleid: MSTG-CRYPTO-4
javax.crypto.Cipher.getInstance("RC4")
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("PBEWithSHA1And128BitRC4")
// ruleid: MSTG-CRYPTO-4
KeyGenerator.getInstance("RC4")
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("AES/CBC/PKCS5Padding")
// ok: MSTG-CRYPTO-4
Cipher.getInstance("RSA/ECB/PKCS1Padding")
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("RC2")

// ===== Blowfish =====
// ruleid: MSTG-CRYPTO-4
val cipher = Cipher.getInstance("Blowfish");
// ruleid: MSTG-CRYPTO-4
val cipher2 = Cipher.getInstance("Blowfish/ECB/NoPadding");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("Blowfish")
// ruleid: MSTG-CRYPTO-4
foo(Cipher.getInstance("Blowfish/CBC/PKCS5Padding"))
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("Blowfish").init(1, key)
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("Blowfish/CBC/PKCS5Padding", "SunJCE")
// ruleid: MSTG-CRYPTO-4
javax.crypto.Cipher.getInstance("Blowfish")
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("blowfish")
// ruleid: MSTG-CRYPTO-4
KeyGenerator.getInstance("Blowfish")
// ok: MSTG-CRYPTO-4
Cipher.getInstance("AES/GCM/NoPadding")
// ok: MSTG-CRYPTO-4
Cipher.getInstance("RSA/ECB/PKCS1Padding")
// ok: MSTG-CRYPTO-4
Cipher.getInstance("AES/GCM/NoPadding")

// ===== CBC + PKCS padding =====
// ruleid: MSTG-CRYPTO-4
val cipher_pkcs5 = Cipher.getInstance("AES/CBC/PKCS5Padding");
// ruleid: MSTG-CRYPTO-4
val cipher_pkcs7 = Cipher.getInstance("AES/CBC/PKCS7Padding");
// ok: MSTG-CRYPTO-4
val cipher_no_padding = Cipher.getInstance("AES/CBC/NoPadding");
// ruleid: MSTG-CRYPTO-4
val spec_pkcs5 = KeyGenParameterSpec.Builder("key", KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
    .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS5)
    .build()
// ruleid: MSTG-CRYPTO-4
val spec_pkcs7 = KeyGenParameterSpec.Builder("key", KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
    .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
    .build()
// ok: MSTG-CRYPTO-4
val spec_no_padding = KeyGenParameterSpec.Builder("key", KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
    .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
    .build()

// ===== deprecated "Crypto" SecureRandom provider =====
// ruleid: MSTG-CRYPTO-4
val sr = SecureRandom.getInstance("SHA1PRNG", "Crypto")
// ok: MSTG-CRYPTO-4
val sr2 = SecureRandom.getInstance("SHA1PRNG")

// ===== KeyGenParameterSpec via initialize (Kotlin) =====
// ruleid: MSTG-CRYPTO-4
kg.initialize(KeyGenParameterSpec.Builder("key", KeyProperties.PURPOSE_ENCRYPT)
    .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
    .build())

// ===== ECB mode =====
class EcbTests {
    val MODE = "AES/ECB/PKCS5Padding"

    fun vulnerable(k: Key) {
        // ruleid: MSTG-CRYPTO-4
        Cipher.getInstance("AES/ECB/PKCS5Padding")
        // ruleid: MSTG-CRYPTO-4
        val c1 = Cipher.getInstance("AES/ECB/NoPadding")
        // ruleid: MSTG-CRYPTO-4
        val c2: Cipher = Cipher.getInstance("AES/ECB/NoPadding")
        // ruleid: MSTG-CRYPTO-4
        val c3 = Cipher.getInstance("AES/ECB/PKCS5Padding", "BC")
        // ruleid: MSTG-CRYPTO-4
        val c4 = javax.crypto.Cipher.getInstance("AES/ECB/PKCS5Padding")
        // ruleid: MSTG-CRYPTO-4
        Cipher.getInstance("AES/ECB/PKCS5Padding").init(Cipher.ENCRYPT_MODE, k)
        // ruleid: MSTG-CRYPTO-4
        val c5 = Cipher.getInstance("DES/ECB/PKCS5Padding")
        // ruleid: MSTG-CRYPTO-4
        val c6 = Cipher.getInstance("Blowfish/ECB/NoPadding")
        // ruleid: MSTG-CRYPTO-4
        val c7 = Cipher.getInstance("AES/ecb/PKCS5Padding")
        // ruleid: MSTG-CRYPTO-4
        val c8 = Cipher.getInstance(MODE)
        // ruleid: MSTG-CRYPTO-4
        val c9 = Cipher.getInstance("AES")
    }

    fun keyStore() {
        // ruleid: MSTG-CRYPTO-4
        val spec = KeyGenParameterSpec.Builder("key", KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
            .setBlockModes(KeyProperties.BLOCK_MODE_ECB)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
            .build()
        // ok: MSTG-CRYPTO-4
        val ok = KeyGenParameterSpec.Builder("key", KeyProperties.PURPOSE_ENCRYPT)
            .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
            .build()
    }

    fun safe() {
        // ok: MSTG-CRYPTO-4
        val a = Cipher.getInstance("AES/GCM/NoPadding")
        // ruleid: MSTG-CRYPTO-4
        val b = Cipher.getInstance("AES/CBC/PKCS5Padding")
        // ok: MSTG-CRYPTO-4
        val d = Foo.getInstance("ECB")
        // RSA/ECB is only a naming convention, not block-cipher ECB
        // ok: MSTG-CRYPTO-4
        val e = Cipher.getInstance("RSA/ECB/PKCS1Padding")
        // ok: MSTG-CRYPTO-4
        val f = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding")
    }
}

// ===== CBC padding oracle (gitlab Kotlin cases) =====
class CipherPaddingOracle {
    private var cipher: Cipher? = null
    @Throws(Exception::class)
    fun x() {
        cipher = Cipher.getInstance("AES/CTR/NoPadding")
    }

    companion object {
        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) {
            // ok: MSTG-CRYPTO-4
            Cipher.getInstance("AES/GCM/...") // ok
            // ruleid: MSTG-CRYPTO-4
            Cipher.getInstance("AES") // ECB and no integrity
            // ruleid: MSTG-CRYPTO-4
            Cipher.getInstance("DES/CTR/NoPadding", "BC") // no integrity
            // ruleid: MSTG-CRYPTO-4
            Cipher.getInstance("DESede/ECB/PKCS5Padding") // ECB and no integrity
            // ruleid: MSTG-CRYPTO-4
            Cipher.getInstance("DESede/CBC/PKCS5Padding") // CBC and no integrity
            // ruleid: MSTG-CRYPTO-4
            Cipher.getInstance("AES/CBC/PKCS5Padding") // oracle and no integrity
            // ruleid: MSTG-CRYPTO-4
            Cipher.getInstance("ECIES/CBC/PKCS5Padding") // oracle and no integrity
            // ok: MSTG-CRYPTO-4
            Cipher.getInstance("RSA") // ok
            // ok: MSTG-CRYPTO-4
            Cipher.getInstance("RSA/CBC/PKCS1Padding") // ok
            // ok: MSTG-CRYPTO-4
            Cipher.getInstance("RSA/ECB/PKCS1Padding") // ok
            // ok: MSTG-CRYPTO-4
            Cipher.getInstance(args[0]) // ok
            // ok: MSTG-CRYPTO-4
            Cipher.getInstance("ECIES") // ok this is elliptic curve
            // ok: MSTG-CRYPTO-4
            Cipher.getInstance("AES/GCM-SIV/NoPadding") // ok
        }
    }
}
