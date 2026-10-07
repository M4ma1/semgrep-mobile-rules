import javax.crypto.Cipher;

// ruleid: android.insecure_cipher_des
val cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
// ruleid: android.insecure_cipher_des
val factory = SecretKeyFactory.getInstance("DES");
// ruleid: android.insecure_cipher_des
Cipher.getInstance("DES")
// ruleid: android.insecure_cipher_des
foo(Cipher.getInstance("DES/CBC/PKCS5Padding"))
// ruleid: android.insecure_cipher_des
Cipher.getInstance("DES").init(1, key)
// ruleid: android.insecure_cipher_des
Cipher.getInstance("DES/CBC/PKCS5Padding", "SunJCE")
// ruleid: android.insecure_cipher_des
javax.crypto.Cipher.getInstance("DES")
// ruleid: android.insecure_cipher_des
Cipher.getInstance("PBEWithMD5AndDES")
// ruleid: android.insecure_cipher_des
KeyGenerator.getInstance("DES")
// ok: android.insecure_cipher_des
Cipher.getInstance("AES/CBC/PKCS5Padding")
// ok: android.insecure_cipher_des
Cipher.getInstance("RSA/ECB/PKCS1Padding")
// ok: android.insecure_cipher_des
Cipher.getInstance("3DES")
// ok: android.insecure_cipher_des
Cipher.getInstance("DESede")
