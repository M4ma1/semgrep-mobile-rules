import javax.crypto.Cipher;

// ruleid: android.insecure_cipher_rc4
Cipher cipher = Cipher.getInstance("RC4/CBC/PKCS5Padding");
// ruleid: android.insecure_cipher_rc4
SecretKeyFactory factory = SecretKeyFactory.getInstance("RC4");
// ruleid: android.insecure_cipher_rc4
SecretKeyFactory factory_2 = SecretKeyFactory.getInstance("ARCFOUR");
// ruleid: android.insecure_cipher_rc4
Cipher.getInstance("RC4");
// ruleid: android.insecure_cipher_rc4
foo(Cipher.getInstance("ARCFOUR/ECB/NOPADDING"));
// ruleid: android.insecure_cipher_rc4
Cipher.getInstance("RC4").init(1, key);
// ruleid: android.insecure_cipher_rc4
Cipher.getInstance("ARCFOUR/ECB/NOPADDING", "SunJCE");
// ruleid: android.insecure_cipher_rc4
javax.crypto.Cipher.getInstance("RC4");
// ruleid: android.insecure_cipher_rc4
Cipher.getInstance("PBEWithSHA1And128BitRC4");
// ruleid: android.insecure_cipher_rc4
KeyGenerator.getInstance("RC4");
// ok: android.insecure_cipher_rc4
Cipher.getInstance("AES/CBC/PKCS5Padding");
// ok: android.insecure_cipher_rc4
Cipher.getInstance("RSA/ECB/PKCS1Padding");
// ok: android.insecure_cipher_rc4
Cipher.getInstance("RC2");
