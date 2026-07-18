import javax.crypto.Cipher;

// ruleid: android.insecure_cipher_rc2
Cipher cipher = Cipher.getInstance("RC2/CBC/PKCS5Padding");
// ruleid: android.insecure_cipher_rc2
SecretKeyFactory factory = SecretKeyFactory.getInstance("RC2");