import javax.crypto.Cipher;

// ruleid: android.insecure_cipher_blowfish
val cipher = Cipher.getInstance("Blowfish");
// ruleid: android.insecure_cipher_blowfish
val cipher2 = Cipher.getInstance("Blowfish/ECB/NoPadding");
// ruleid: android.insecure_cipher_blowfish
Cipher.getInstance("Blowfish")
// ruleid: android.insecure_cipher_blowfish
foo(Cipher.getInstance("Blowfish/CBC/PKCS5Padding"))
// ruleid: android.insecure_cipher_blowfish
Cipher.getInstance("Blowfish").init(1, key)
// ruleid: android.insecure_cipher_blowfish
Cipher.getInstance("Blowfish/CBC/PKCS5Padding", "SunJCE")
// ruleid: android.insecure_cipher_blowfish
javax.crypto.Cipher.getInstance("Blowfish")
// ruleid: android.insecure_cipher_blowfish
Cipher.getInstance("blowfish")
// ruleid: android.insecure_cipher_blowfish
KeyGenerator.getInstance("Blowfish")
// ok: android.insecure_cipher_blowfish
Cipher.getInstance("AES/GCM/NoPadding")
// ok: android.insecure_cipher_blowfish
Cipher.getInstance("RSA/ECB/PKCS1Padding")
// ok: android.insecure_cipher_blowfish
Cipher.getInstance("AES/GCM/NoPadding")
