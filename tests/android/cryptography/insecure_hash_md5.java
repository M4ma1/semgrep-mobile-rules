import java.security.MessageDigest;
import org.apache.commons.codec.digest.DigestUtils;

// ruleid: android.insecure_hash_md5
MessageDigest md_1 = MessageDigest.getInstance("MD5");
// ruleid: android.insecure_hash_md5
MessageDigest md_2 = DigestUtils.getMd5Digest();
// ruleid: android.insecure_hash_md5
byte[] md_3 = DigestUtils.md5("dummy");
// ruleid: android.insecure_hash_md5
String md_4 = DigestUtils.md5Hex("dummy");