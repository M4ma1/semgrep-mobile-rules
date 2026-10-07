import javax.crypto.Cipher

class RsaTests {
    val T = "RSA/ECB/NoPadding"

    fun vulnerable(k: Key) {
        // ruleid: android.rsa_no_oaep
        val a = Cipher.getInstance("RSA/ECB/NoPadding")
        // ruleid: android.rsa_no_oaep
        val b = Cipher.getInstance("RSA/None/NoPadding")
        // ruleid: android.rsa_no_oaep
        val c = Cipher.getInstance("rsa/ecb/nopadding")
        // ruleid: android.rsa_no_oaep
        val d = javax.crypto.Cipher.getInstance("RSA/ECB/NoPadding", "BC")
        // ruleid: android.rsa_no_oaep
        val e = Cipher.getInstance(T)
        // ruleid: android.rsa_no_oaep
        Cipher.getInstance("RSA/ECB/NoPadding").init(Cipher.ENCRYPT_MODE, k)
        val alg = "RSA/ECB/NoPadding"
        // ruleid: android.rsa_no_oaep
        val f = Cipher.getInstance(alg)
    }

    fun safe() {
        // ok: android.rsa_no_oaep
        val a = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding")
        // ok: android.rsa_no_oaep
        val b = Cipher.getInstance("RSA/ECB/PKCS1Padding")
        // ok: android.rsa_no_oaep
        val c = Cipher.getInstance("RSA")
        // ok: android.rsa_no_oaep
        val d = Cipher.getInstance("AES/GCM/NoPadding")
        // ok: android.rsa_no_oaep
        val e = Foo.getInstance("RSA/ECB/NoPadding")
    }
}
