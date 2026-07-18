import javax.crypto.Cipher;

// ruleid: android.insecure_cipher_blowfish
val cipher = Cipher.getInstance("Blowfish");
// ruleid: android.insecure_cipher_blowfish
val cipher2 = Cipher.getInstance("Blowfish/ECB/NoPadding");