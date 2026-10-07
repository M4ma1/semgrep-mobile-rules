import javax.crypto.Cipher;

// ruleid: android.insecure_cipher_3des
Cipher cipher = Cipher.getInstance("3DES/CBC/NoPadding");
// ruleid: android.insecure_cipher_3des
Cipher cipher2 = Cipher.getInstance("DESede/CBC/NoPadding");
// ruleid: android.insecure_cipher_3des
Cipher cipher3 = Cipher.getInstance("DESEDEWRAP/CBC/NoPadding");
// ruleid: android.insecure_cipher_3des
SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
// ruleid: android.insecure_cipher_3des
Cipher.getInstance("DESede");
// ruleid: android.insecure_cipher_3des
foo(Cipher.getInstance("DESede/ECB/PKCS5Padding"));
// ruleid: android.insecure_cipher_3des
Cipher.getInstance("DESede").init(1, key);
// ruleid: android.insecure_cipher_3des
Cipher.getInstance("DESede/ECB/PKCS5Padding", "SunJCE");
// ruleid: android.insecure_cipher_3des
javax.crypto.Cipher.getInstance("DESede");
// ruleid: android.insecure_cipher_3des
Cipher.getInstance("PBEWithSHA1AndDESede");
// ruleid: android.insecure_cipher_3des
KeyGenerator.getInstance("DESede");
// ok: android.insecure_cipher_3des
Cipher.getInstance("AES/GCM/NoPadding");
// ok: android.insecure_cipher_3des
Cipher.getInstance("RSA/ECB/PKCS1Padding");
// ok: android.insecure_cipher_3des
Cipher.getInstance("DES/CBC/NoPadding");
