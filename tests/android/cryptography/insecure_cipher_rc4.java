import javax.crypto.Cipher;

// ruleid: android.insecure_cipher_rc4
Cipher cipher = Cipher.getInstance("RC4/CBC/PKCS5Padding");
// ruleid: android.insecure_cipher_rc4
SecretKeyFactory factory = SecretKeyFactory.getInstance("RC4");
// ruleid: android.insecure_cipher_rc4
SecretKeyFactory factory_2 = SecretKeyFactory.getInstance("ARCFOUR");