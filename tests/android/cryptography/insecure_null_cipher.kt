import javax.crypto.Cipher
import javax.crypto.NullCipher

class NullCipherTests {
    // ruleid: android.insecure_null_cipher
    val property = NullCipher()

    fun vulnerable(out: OutputStream) {
        // ruleid: android.insecure_null_cipher
        val a = NullCipher()
        // ruleid: android.insecure_null_cipher
        val b = javax.crypto.NullCipher()
        // ruleid: android.insecure_null_cipher
        val c: Cipher = NullCipher()
        // ruleid: android.insecure_null_cipher
        val s = CipherOutputStream(out, NullCipher())
        // ruleid: android.insecure_null_cipher
        NullCipher()
    }

    fun factory(): Cipher {
        // ruleid: android.insecure_null_cipher
        return NullCipher()
    }

    fun safe(param: NullCipher?) {
        // ok: android.insecure_null_cipher
        val a = Cipher.getInstance("AES/GCM/NoPadding")
        // ok: android.insecure_null_cipher
        Log.d("t", "NullCipher is bad")
        // ok: android.insecure_null_cipher
        val c = NullCipherFactory()
    }
}
