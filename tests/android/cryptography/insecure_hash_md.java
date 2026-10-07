import java.security.MessageDigest;
import java.security.Signature;
import org.apache.commons.codec.digest.DigestUtils;

class MdTests {
    static final String ALG = "MD5";

    void md5() throws Exception {
        // ruleid: android.insecure_hash_md
        MessageDigest a = MessageDigest.getInstance("MD5");
        // ruleid: android.insecure_hash_md
        byte[] b = MessageDigest.getInstance("MD5").digest(data);
        // ruleid: android.insecure_hash_md
        MessageDigest c = MessageDigest.getInstance("md5");
        // ruleid: android.insecure_hash_md
        MessageDigest d = MessageDigest.getInstance("MD5", "BC");
        // ruleid: android.insecure_hash_md
        java.security.MessageDigest e = java.security.MessageDigest.getInstance("MD5");
        // ruleid: android.insecure_hash_md
        MessageDigest f = MessageDigest.getInstance(ALG);
        // ruleid: android.insecure_hash_md
        Signature g = Signature.getInstance("MD5withRSA");
    }

    void md2md4() throws Exception {
        // ruleid: android.insecure_hash_md
        MessageDigest a = MessageDigest.getInstance("MD2");
        // ruleid: android.insecure_hash_md
        byte[] b = MessageDigest.getInstance("MD2").digest(data);
        // ruleid: android.insecure_hash_md
        MessageDigest c = MessageDigest.getInstance("MD4");
        // ruleid: android.insecure_hash_md
        Signature d = Signature.getInstance("MD2withRSA");
        // ruleid: android.insecure_hash_md
        x.getInstance("md4");
    }

    void digestUtils() {
        // ruleid: android.insecure_hash_md
        String a = DigestUtils.md5Hex(data);
        // ruleid: android.insecure_hash_md
        byte[] b = DigestUtils.md5(data);
        // ruleid: android.insecure_hash_md
        MessageDigest c = DigestUtils.getMd5Digest();
        // ruleid: android.insecure_hash_md
        String d = DigestUtils.md2Hex(data);
        // ruleid: android.insecure_hash_md
        MessageDigest e = DigestUtils.getMd2Digest();
        // ruleid: android.insecure_hash_md
        byte[] f = DigestUtils.md4(data);
        // ruleid: android.insecure_hash_md
        String g = DigestUtils.md4Hex(data);
    }

    void guava() throws Exception {
        // ruleid: android.insecure_hash_md
        HashCode a = Files.hash(file, Hashing.md5());
        // ruleid: android.insecure_hash_md
        HashCode b = com.google.common.io.Files
            .hash(new File(filename), Hashing.md5());
    }

    void safe() throws Exception {
        // ok: android.insecure_hash_md
        MessageDigest a = MessageDigest.getInstance("SHA-256");
        // ok: android.insecure_hash_md
        String b = DigestUtils.sha256Hex(data);
        // ok: android.insecure_hash_md
        Signature c = Signature.getInstance("SHA256withRSA");
        // ok: android.insecure_hash_md
        Log.d("t", "no longer MD5");
        // ok: android.insecure_hash_md
        String md5 = computeSha256(data);
        // HMAC-MD5 is not collision based
        // ok: android.insecure_hash_md
        Mac mac = Mac.getInstance("HmacMD5");
    }
}
