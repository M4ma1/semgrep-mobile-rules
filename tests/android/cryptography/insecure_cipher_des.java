import javax.crypto.Cipher;

// ruleid: android.insecure_cipher_des
Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
// ruleid: android.insecure_cipher_des
SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");