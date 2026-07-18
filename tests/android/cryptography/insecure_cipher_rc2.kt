import javax.crypto.Cipher;

// ruleid: android.insecure_cipher_rc2
val cipher = Cipher.getInstance("RC2/CBC/PKCS5Padding");
// ruleid: android.insecure_cipher_rc2
val factory = SecretKeyFactory.getInstance("RC2");