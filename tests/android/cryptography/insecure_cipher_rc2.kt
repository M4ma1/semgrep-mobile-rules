import javax.crypto.Cipher;

// ruleid: android.insecure_cipher_rc2
val cipher = Cipher.getInstance("RC2/CBC/PKCS5Padding");
// ruleid: android.insecure_cipher_rc2
val factory = SecretKeyFactory.getInstance("RC2");
// ruleid: android.insecure_cipher_rc2
Cipher.getInstance("RC2")
// ruleid: android.insecure_cipher_rc2
foo(Cipher.getInstance("RC2/ECB/PKCS5Padding"))
// ruleid: android.insecure_cipher_rc2
Cipher.getInstance("RC2").init(1, key)
// ruleid: android.insecure_cipher_rc2
Cipher.getInstance("RC2/ECB/PKCS5Padding", "SunJCE")
// ruleid: android.insecure_cipher_rc2
javax.crypto.Cipher.getInstance("RC2")
// ruleid: android.insecure_cipher_rc2
Cipher.getInstance("PBEWithSHA1AndRC2_40")
// ruleid: android.insecure_cipher_rc2
KeyGenerator.getInstance("RC2")
// ok: android.insecure_cipher_rc2
Cipher.getInstance("AES/CBC/PKCS5Padding")
// ok: android.insecure_cipher_rc2
Cipher.getInstance("RSA/ECB/PKCS1Padding")
// ok: android.insecure_cipher_rc2
Cipher.getInstance("RC4")
