import javax.crypto.Cipher;

// ruleid: android.insecure_cipher_3des
val cipher = Cipher.getInstance("3DES/CBC/NoPadding");
// ruleid: android.insecure_cipher_3des
val cipher2 = Cipher.getInstance("DESede/CBC/NoPadding");
// ruleid: android.insecure_cipher_3des
val cipher3 = Cipher.getInstance("DESEDEWRAP/CBC/NoPadding");
// ruleid: android.insecure_cipher_3des
val factory = SecretKeyFactory.getInstance("DESede");