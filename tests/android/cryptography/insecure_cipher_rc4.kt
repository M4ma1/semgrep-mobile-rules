import javax.crypto.Cipher;

// ruleid: android.insecure_cipher_rc4
val cipher = Cipher.getInstance("RC4/CBC/PKCS5Padding");
// ruleid: android.insecure_cipher_rc4
val factory = SecretKeyFactory.getInstance("RC4");
// ruleid: android.insecure_cipher_rc4
val factory_2 = SecretKeyFactory.getInstance("ARCFOUR");