import javax.crypto.Cipher;

// ruleid: android.insecure_cipher_cbc
Cipher cipher_pkcs5 = Cipher.getInstance("AES/CBC/PKCS5Padding");
// ruleid: android.insecure_cipher_cbc
Cipher cipher_pkcs7 = Cipher.getInstance("AES/CBC/PKCS7Padding");
// ok: android.insecure_cipher_cbc
Cipher cipher_no_padding = Cipher.getInstance("AES/CBC/NoPadding");
// ruleid: android.insecure_cipher_cbc
KeyGenParameterSpec spec_pkcs5 = new KeyGenParameterSpec.Builder("key", KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
    .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS5)
    .build();
// ruleid: android.insecure_cipher_cbc
KeyGenParameterSpec spec_pkcs7 = new KeyGenParameterSpec.Builder("key", KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
    .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
    .build();
// ok: android.insecure_cipher_cbc
KeyGenParameterSpec spec_no_padding = new KeyGenParameterSpec.Builder("key", KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
    .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
    .build();