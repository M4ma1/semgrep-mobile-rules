import javax.crypto.Cipher;

class EcbTests {
    static final String MODE = "AES/ECB/PKCS5Padding";

    void vulnerable(Key k) throws Exception {
        // ruleid: android.insecure_cipher_ecb
        Cipher.getInstance("AES/ECB/PKCS5Padding");
        // ruleid: android.insecure_cipher_ecb
        Cipher c1 = Cipher.getInstance("AES/ECB/NoPadding");
        // ruleid: android.insecure_cipher_ecb
        Cipher c2 = Cipher.getInstance("AES/ECB/PKCS5Padding", "BC");
        // ruleid: android.insecure_cipher_ecb
        javax.crypto.Cipher c3 = javax.crypto.Cipher.getInstance("AES/ECB/PKCS5Padding");
        // ruleid: android.insecure_cipher_ecb
        Cipher.getInstance("AES/ECB/PKCS5Padding").init(Cipher.ENCRYPT_MODE, k);
        // ruleid: android.insecure_cipher_ecb
        Cipher c4 = Cipher.getInstance("DES/ECB/PKCS5Padding");
        // ruleid: android.insecure_cipher_ecb
        Cipher c5 = Cipher.getInstance("Blowfish/ECB/NoPadding");
        // ruleid: android.insecure_cipher_ecb
        Cipher c6 = Cipher.getInstance("AES/ecb/PKCS5Padding");
        // ruleid: android.insecure_cipher_ecb
        Cipher c7 = Cipher.getInstance(MODE);
        // ruleid: android.insecure_cipher_ecb
        Cipher c8 = Cipher.getInstance("AES");
        // ruleid: android.insecure_cipher_ecb
        Cipher c9 = Cipher.getInstance("AES", "BC");
    }

    void keyStore() {
        // ruleid: android.insecure_cipher_ecb
        KeyGenParameterSpec spec = new KeyGenParameterSpec.Builder("key", KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
            .setBlockModes(KeyProperties.BLOCK_MODE_ECB)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
            .build();
        // ok: android.insecure_cipher_ecb
        KeyGenParameterSpec ok = new KeyGenParameterSpec.Builder("key", KeyProperties.PURPOSE_ENCRYPT)
            .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
            .build();
    }

    void safe() throws Exception {
        // ok: android.insecure_cipher_ecb
        Cipher a = Cipher.getInstance("AES/GCM/NoPadding");
        // ok: android.insecure_cipher_ecb
        Cipher b = Cipher.getInstance("AES/CBC/PKCS5Padding");
        // ok: android.insecure_cipher_ecb
        Cipher c = Cipher.getInstance("AES/GCM/NoPadding", "BC");
        // ok: android.insecure_cipher_ecb
        Object d = Foo.getInstance("ECB");
        // RSA/ECB is only a naming convention, not block-cipher ECB
        // ok: android.insecure_cipher_ecb
        Cipher e = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        // ok: android.insecure_cipher_ecb
        Cipher f = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
    }
}
