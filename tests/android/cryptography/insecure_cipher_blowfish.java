import javax.crypto.Cipher;

// ruleid: android.insecure_cipher_blowfish
Cipher cipher = Cipher.getInstance("Blowfish");
// ruleid: android.insecure_cipher_blowfish
Cipher cipher2 = Cipher.getInstance("Blowfish/ECB/NoPadding");