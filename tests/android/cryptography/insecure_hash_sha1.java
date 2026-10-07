import java.security.MessageDigest;
import java.security.Signature;
import org.apache.commons.codec.digest.DigestUtils;

class Sha1Tests {
    static final String ALG = "SHA-1";

    void messageDigest() throws Exception {
        // ruleid: android.insecure_hash_sha1
        MessageDigest a = MessageDigest.getInstance("SHA-1");
        // ruleid: android.insecure_hash_sha1
        MessageDigest b = MessageDigest.getInstance("SHA1");
        // ruleid: android.insecure_hash_sha1
        MessageDigest c = MessageDigest.getInstance("sha-1");
        // ruleid: android.insecure_hash_sha1
        MessageDigest d = MessageDigest.getInstance("SHA");
        // ruleid: android.insecure_hash_sha1
        MessageDigest e = MessageDigest.getInstance("SHA-1", "BC");
        // ruleid: android.insecure_hash_sha1
        java.security.MessageDigest.getInstance("SHA-1").digest(data);
        // ruleid: android.insecure_hash_sha1
        MessageDigest f = MessageDigest.getInstance(ALG);
    }

    void signatures() throws Exception {
        // ruleid: android.insecure_hash_sha1
        Signature a = Signature.getInstance("SHA1withRSA");
        // ruleid: android.insecure_hash_sha1
        Signature b = Signature.getInstance("SHA1withECDSA");
        // ok: android.insecure_hash_sha1
        Signature c = Signature.getInstance("SHA256withRSA");
    }

    void digestUtils(byte[] data) {
        // ruleid: android.insecure_hash_sha1
        MessageDigest a = DigestUtils.getSha1Digest();
        // ruleid: android.insecure_hash_sha1
        byte[] b = DigestUtils.sha1(data);
        // ruleid: android.insecure_hash_sha1
        String c = DigestUtils.sha1Hex(data);
        // ruleid: android.insecure_hash_sha1
        byte[] d = DigestUtils.sha(data);
        // ruleid: android.insecure_hash_sha1
        String e = DigestUtils.shaHex(data);
        // ruleid: android.insecure_hash_sha1
        byte[] f = DigestUtils.getSha1Digest().digest(data);
    }

    void safe() throws Exception {
        // ok: android.insecure_hash_sha1
        MessageDigest a = MessageDigest.getInstance("SHA-256");
        // ok: android.insecure_hash_sha1
        MessageDigest b = MessageDigest.getInstance("SHA-512");
        // ok: android.insecure_hash_sha1
        MessageDigest c = MessageDigest.getInstance("SHA3-256");
        // ok: android.insecure_hash_sha1
        String d = DigestUtils.sha256Hex(data);
        // ok: android.insecure_hash_sha1
        Log.d("t", "we no longer use SHA-1");
        // HMAC-SHA1 is not collision based; PBKDF2WithHmacSHA1 has its own rule
        // ok: android.insecure_hash_sha1
        Mac mac = Mac.getInstance("HmacSHA1");
        // ok: android.insecure_hash_sha1
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    }
}
