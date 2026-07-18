import java.security.MessageDigest
import org.apache.commons.codec.digest.DigestUtils

// ruleid: android.insecure_hash_md5
val md_1 = MessageDigest.getInstance("MD5")
// ruleid: android.insecure_hash_md5
val md_2 = DigestUtils.getMd5Digest()
// ruleid: android.insecure_hash_md5
val md_3 = DigestUtils.md5("dummy")
// ruleid: android.insecure_hash_md5
val md_4 = DigestUtils.md5Hex("dummy");