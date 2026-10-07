import java.security.MessageDigest
import java.security.Signature
import org.apache.commons.codec.digest.DigestUtils

class Sha1Tests {
    val ALG = "SHA-1"

    fun messageDigest() {
        // ruleid: android.insecure_hash_sha1
        val a = MessageDigest.getInstance("SHA-1")
        // ruleid: android.insecure_hash_sha1
        val b = MessageDigest.getInstance("SHA1")
        // ruleid: android.insecure_hash_sha1
        var c: MessageDigest = MessageDigest.getInstance("SHA-1")
        // ruleid: android.insecure_hash_sha1
        val d = MessageDigest.getInstance("sha-1")
        // ruleid: android.insecure_hash_sha1
        val e = MessageDigest.getInstance("SHA")
        // ruleid: android.insecure_hash_sha1
        val f = MessageDigest.getInstance("SHA-1", "BC")
        // ruleid: android.insecure_hash_sha1
        java.security.MessageDigest.getInstance("SHA-1").digest(data)
        // ruleid: android.insecure_hash_sha1
        val g = MessageDigest.getInstance(ALG)
    }

    fun signatures() {
        // ruleid: android.insecure_hash_sha1
        val a = Signature.getInstance("SHA1withRSA")
        // ruleid: android.insecure_hash_sha1
        val b = Signature.getInstance("SHA1withECDSA")
        // ok: android.insecure_hash_sha1
        val c = Signature.getInstance("SHA256withRSA")
    }

    fun digestUtils(data: ByteArray) {
        // ruleid: android.insecure_hash_sha1
        val a = DigestUtils.getSha1Digest()
        // ruleid: android.insecure_hash_sha1
        val b = DigestUtils.sha1(data)
        // ruleid: android.insecure_hash_sha1
        val c = DigestUtils.sha1Hex(data)
        // ruleid: android.insecure_hash_sha1
        val d = DigestUtils.sha(data)
        // ruleid: android.insecure_hash_sha1
        val e = DigestUtils.shaHex(data)
        // ruleid: android.insecure_hash_sha1
        val f = DigestUtils.getSha1Digest().digest(data)
    }

    fun safe() {
        // ok: android.insecure_hash_sha1
        val a = MessageDigest.getInstance("SHA-256")
        // ok: android.insecure_hash_sha1
        val b = MessageDigest.getInstance("SHA-512")
        // ok: android.insecure_hash_sha1
        val c = MessageDigest.getInstance("SHA3-256")
        // ok: android.insecure_hash_sha1
        val d = DigestUtils.sha256Hex(data)
        // ok: android.insecure_hash_sha1
        Log.d("t", "we no longer use SHA-1")
        // HMAC-SHA1 is not collision based; PBKDF2WithHmacSHA1 has its own rule
        // ok: android.insecure_hash_sha1
        val mac = Mac.getInstance("HmacSHA1")
        // ok: android.insecure_hash_sha1
        val f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
    }
}
