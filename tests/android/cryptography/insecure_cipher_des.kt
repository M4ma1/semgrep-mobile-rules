import javax.crypto.Cipher;

// ruleid: android.insecure_cipher_des
val cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
// ruleid: android.insecure_cipher_des
val factory = SecretKeyFactory.getInstance("DES");