import java.security.MessageDigest;
import org.apache.commons.codec.digest.DigestUtils;

// ruleid: android.insecure_hash_sha224
MessageDigest md_1 = MessageDigest.getInstance("SHA-224");