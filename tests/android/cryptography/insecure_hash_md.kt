import java.security.MessageDigest
import java.security.Signature
import org.apache.commons.codec.digest.DigestUtils

class MdTests {
    val ALG = "MD5"

    fun md5() {
        // ruleid: android.insecure_hash_md
        val a = MessageDigest.getInstance("MD5")
        // ruleid: android.insecure_hash_md
        val b = MessageDigest.getInstance("MD5").digest(data)
        // ruleid: android.insecure_hash_md
        val c = MessageDigest.getInstance("md5")
        // ruleid: android.insecure_hash_md
        val d = MessageDigest.getInstance("MD5", "BC")
        // ruleid: android.insecure_hash_md
        val e = java.security.MessageDigest.getInstance("MD5")
        // ruleid: android.insecure_hash_md
        val f = MessageDigest.getInstance(ALG)
        // ruleid: android.insecure_hash_md
        val g = Signature.getInstance("MD5withRSA")
    }

    fun md2md4() {
        // ruleid: android.insecure_hash_md
        val a = MessageDigest.getInstance("MD2")
        // ruleid: android.insecure_hash_md
        val b = MessageDigest.getInstance("MD2").digest(data)
        // ruleid: android.insecure_hash_md
        val c = MessageDigest.getInstance("MD4")
        // ruleid: android.insecure_hash_md
        val d = Signature.getInstance("MD2withRSA")
    }

    fun digestUtils() {
        // ruleid: android.insecure_hash_md
        val a = DigestUtils.md5Hex(data)
        // ruleid: android.insecure_hash_md
        val b = DigestUtils.md5(data)
        // ruleid: android.insecure_hash_md
        val c = DigestUtils.getMd5Digest()
        // ruleid: android.insecure_hash_md
        val d = DigestUtils.md2Hex(data)
        // ruleid: android.insecure_hash_md
        val e = DigestUtils.getMd2Digest()
        // ruleid: android.insecure_hash_md
        val f = DigestUtils.md4(data)
        // ruleid: android.insecure_hash_md
        val g = DigestUtils.md4Hex(data)
    }

    fun guava() {
        // ruleid: android.insecure_hash_md
        val a = Files.hash(file, Hashing.md5())
    }

    fun safe() {
        // ok: android.insecure_hash_md
        val a = MessageDigest.getInstance("SHA-256")
        // ok: android.insecure_hash_md
        val b = DigestUtils.sha256Hex(data)
        // ok: android.insecure_hash_md
        val c = Signature.getInstance("SHA256withRSA")
        // ok: android.insecure_hash_md
        Log.d("t", "no longer MD5")
        // ok: android.insecure_hash_md
        val md5 = computeSha256(data)
        // HMAC-MD5 is not collision based
        // ok: android.insecure_hash_md
        val mac = Mac.getInstance("HmacMD5")
    }
}
