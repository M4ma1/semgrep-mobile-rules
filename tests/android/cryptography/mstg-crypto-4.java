import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyGenParameterSpec.Builder;
import android.security.keystore.KeyProperties;
import java.security.SecureRandom;
import javax.crypto.*;

// ===== DES =====
// ruleid: MSTG-CRYPTO-4
Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
// ruleid: MSTG-CRYPTO-4
SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("DES");
// ruleid: MSTG-CRYPTO-4
foo(Cipher.getInstance("DES/CBC/PKCS5Padding"));
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("DES").init(1, key);
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("DES/CBC/PKCS5Padding", "SunJCE");
// ruleid: MSTG-CRYPTO-4
javax.crypto.Cipher.getInstance("DES");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("PBEWithMD5AndDES");
// ruleid: MSTG-CRYPTO-4
KeyGenerator.getInstance("DES");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("AES/CBC/PKCS5Padding");
// ok: MSTG-CRYPTO-4
Cipher.getInstance("RSA/ECB/PKCS1Padding");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("3DES");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("DESede");

// ===== 3DES =====
// ruleid: MSTG-CRYPTO-4
Cipher cipher = Cipher.getInstance("3DES/CBC/NoPadding");
// ruleid: MSTG-CRYPTO-4
Cipher cipher2 = Cipher.getInstance("DESede/CBC/NoPadding");
// ruleid: MSTG-CRYPTO-4
Cipher cipher3 = Cipher.getInstance("DESEDEWRAP/CBC/NoPadding");
// ruleid: MSTG-CRYPTO-4
SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("DESede");
// ruleid: MSTG-CRYPTO-4
foo(Cipher.getInstance("DESede/ECB/PKCS5Padding"));
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("DESede").init(1, key);
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("DESede/ECB/PKCS5Padding", "SunJCE");
// ruleid: MSTG-CRYPTO-4
javax.crypto.Cipher.getInstance("DESede");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("PBEWithSHA1AndDESede");
// ruleid: MSTG-CRYPTO-4
KeyGenerator.getInstance("DESede");
// ok: MSTG-CRYPTO-4
Cipher.getInstance("AES/GCM/NoPadding");
// ok: MSTG-CRYPTO-4
Cipher.getInstance("RSA/ECB/PKCS1Padding");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("DES/CBC/NoPadding");

// ===== RC2 =====
// ruleid: MSTG-CRYPTO-4
Cipher cipher = Cipher.getInstance("RC2/CBC/PKCS5Padding");
// ruleid: MSTG-CRYPTO-4
SecretKeyFactory factory = SecretKeyFactory.getInstance("RC2");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("RC2");
// ruleid: MSTG-CRYPTO-4
foo(Cipher.getInstance("RC2/ECB/PKCS5Padding"));
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("RC2").init(1, key);
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("RC2/ECB/PKCS5Padding", "SunJCE");
// ruleid: MSTG-CRYPTO-4
javax.crypto.Cipher.getInstance("RC2");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("PBEWithSHA1AndRC2_40");
// ruleid: MSTG-CRYPTO-4
KeyGenerator.getInstance("RC2");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("AES/CBC/PKCS5Padding");
// ok: MSTG-CRYPTO-4
Cipher.getInstance("RSA/ECB/PKCS1Padding");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("RC4");

// ===== RC4 =====
// ruleid: MSTG-CRYPTO-4
Cipher cipher = Cipher.getInstance("RC4/CBC/PKCS5Padding");
// ruleid: MSTG-CRYPTO-4
SecretKeyFactory factory = SecretKeyFactory.getInstance("RC4");
// ruleid: MSTG-CRYPTO-4
SecretKeyFactory factory_2 = SecretKeyFactory.getInstance("ARCFOUR");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("RC4");
// ruleid: MSTG-CRYPTO-4
foo(Cipher.getInstance("ARCFOUR/ECB/NOPADDING"));
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("RC4").init(1, key);
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("ARCFOUR/ECB/NOPADDING", "SunJCE");
// ruleid: MSTG-CRYPTO-4
javax.crypto.Cipher.getInstance("RC4");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("PBEWithSHA1And128BitRC4");
// ruleid: MSTG-CRYPTO-4
KeyGenerator.getInstance("RC4");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("AES/CBC/PKCS5Padding");
// ok: MSTG-CRYPTO-4
Cipher.getInstance("RSA/ECB/PKCS1Padding");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("RC2");

// ===== Blowfish =====
// ruleid: MSTG-CRYPTO-4
Cipher cipher = Cipher.getInstance("Blowfish");
// ruleid: MSTG-CRYPTO-4
Cipher cipher2 = Cipher.getInstance("Blowfish/ECB/NoPadding");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("Blowfish");
// ruleid: MSTG-CRYPTO-4
foo(Cipher.getInstance("Blowfish/CBC/PKCS5Padding"));
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("Blowfish").init(1, key);
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("Blowfish/CBC/PKCS5Padding", "SunJCE");
// ruleid: MSTG-CRYPTO-4
javax.crypto.Cipher.getInstance("Blowfish");
// ruleid: MSTG-CRYPTO-4
Cipher.getInstance("blowfish");
// ruleid: MSTG-CRYPTO-4
KeyGenerator.getInstance("Blowfish");
// ok: MSTG-CRYPTO-4
Cipher.getInstance("AES/GCM/NoPadding");
// ok: MSTG-CRYPTO-4
Cipher.getInstance("RSA/ECB/PKCS1Padding");
// ok: MSTG-CRYPTO-4
Cipher.getInstance("AES/GCM/NoPadding");

// ===== CBC + PKCS padding =====
// ruleid: MSTG-CRYPTO-4
Cipher cipher_pkcs5 = Cipher.getInstance("AES/CBC/PKCS5Padding");
// ruleid: MSTG-CRYPTO-4
Cipher cipher_pkcs7 = Cipher.getInstance("AES/CBC/PKCS7Padding");
// ok: MSTG-CRYPTO-4
Cipher cipher_no_padding = Cipher.getInstance("AES/CBC/NoPadding");
// ruleid: MSTG-CRYPTO-4
KeyGenParameterSpec spec_pkcs5 = new KeyGenParameterSpec.Builder("key", KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
    .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS5)
    .build();
// ruleid: MSTG-CRYPTO-4
KeyGenParameterSpec spec_pkcs7 = new KeyGenParameterSpec.Builder("key", KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
    .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
    .build();
// ok: MSTG-CRYPTO-4
KeyGenParameterSpec spec_no_padding = new KeyGenParameterSpec.Builder("key", KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
    .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
    .build();

// ===== CBC padding oracle (bare calls) =====
// ruleid: MSTG-CRYPTO-4
Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
// ruleid: MSTG-CRYPTO-4
Cipher cc = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
// ruleid: MSTG-CRYPTO-4
Cipher ccc = Cipher.getInstance("DES/CBC/PKCS5Padding");
// ruleid: MSTG-CRYPTO-4
Cipher cccc = Cipher.getInstance("AES/CBC/PKCS7Padding");
// ruleid: MSTG-CRYPTO-4
Cipher ccccc = Cipher.getInstance("Blowfish/CBC/PKCS7Padding");

// good
Cipher g = Cipher.getInstance("AES/GCM/NoPadding");

Cipher g1 = Cipher.getInstance("RSA/None/OAEPWithSHA-1AndMGF1Padding"); 
Cipher g2 = Cipher.getInstance("RSA/None/OAEPWITHSHA-256ANDMGF1PADDING");

// ===== ECB mode =====
class EcbTests {
    static final String MODE = "AES/ECB/PKCS5Padding";

    void vulnerable(Key k) throws Exception {
        // ruleid: MSTG-CRYPTO-4
        Cipher.getInstance("AES/ECB/PKCS5Padding");
        // ruleid: MSTG-CRYPTO-4
        Cipher c1 = Cipher.getInstance("AES/ECB/NoPadding");
        // ruleid: MSTG-CRYPTO-4
        Cipher c2 = Cipher.getInstance("AES/ECB/PKCS5Padding", "BC");
        // ruleid: MSTG-CRYPTO-4
        javax.crypto.Cipher c3 = javax.crypto.Cipher.getInstance("AES/ECB/PKCS5Padding");
        // ruleid: MSTG-CRYPTO-4
        Cipher.getInstance("AES/ECB/PKCS5Padding").init(Cipher.ENCRYPT_MODE, k);
        // ruleid: MSTG-CRYPTO-4
        Cipher c4 = Cipher.getInstance("DES/ECB/PKCS5Padding");
        // ruleid: MSTG-CRYPTO-4
        Cipher c5 = Cipher.getInstance("Blowfish/ECB/NoPadding");
        // ruleid: MSTG-CRYPTO-4
        Cipher c6 = Cipher.getInstance("AES/ecb/PKCS5Padding");
        // ruleid: MSTG-CRYPTO-4
        Cipher c7 = Cipher.getInstance(MODE);
        // ruleid: MSTG-CRYPTO-4
        Cipher c8 = Cipher.getInstance("AES");
        // ruleid: MSTG-CRYPTO-4
        Cipher c9 = Cipher.getInstance("AES", "BC");
    }

    void keyStore() {
        // ruleid: MSTG-CRYPTO-4
        KeyGenParameterSpec spec = new KeyGenParameterSpec.Builder("key", KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
            .setBlockModes(KeyProperties.BLOCK_MODE_ECB)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
            .build();
        // ok: MSTG-CRYPTO-4
        KeyGenParameterSpec ok = new KeyGenParameterSpec.Builder("key", KeyProperties.PURPOSE_ENCRYPT)
            .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
            .build();
    }

    void safe() throws Exception {
        // ok: MSTG-CRYPTO-4
        Cipher a = Cipher.getInstance("AES/GCM/NoPadding");
        // ruleid: MSTG-CRYPTO-4
        Cipher b = Cipher.getInstance("AES/CBC/PKCS5Padding");
        // ok: MSTG-CRYPTO-4
        Cipher c = Cipher.getInstance("AES/GCM/NoPadding", "BC");
        // ok: MSTG-CRYPTO-4
        Object d = Foo.getInstance("ECB");
        // RSA/ECB is only a naming convention, not block-cipher ECB
        // ok: MSTG-CRYPTO-4
        Cipher e = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        // ok: MSTG-CRYPTO-4
        Cipher f = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
    }
}

// ===== deprecated "Crypto" SecureRandom provider =====
// ruleid: MSTG-CRYPTO-4
SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "Crypto");
// ok: MSTG-CRYPTO-4
SecureRandom sr2 = SecureRandom.getInstance("SHA1PRNG");

// ===== original MSTG-CRYPTO-4 tests =====
public class TestCryptoAndroid {
    
    private void vuln_generateKey1() {
        // Vulnerable 
        //[...]
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");
        // ruleid: MSTG-CRYPTO-4
        keyGenerator.initialize(new KeyGenParameterSpec.Builder("key2", KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                 .setBlockModes(KeyProperties.BLOCK_MODE_ECB)
                 .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                 .build());
        SecretKey key = keyGenerator.generateKey();
    }

        private void vuln_generateKey2() {
        // Vulnerable 
        //[...]
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");
        // ruleid: MSTG-CRYPTO-4
        keyGenerator.initialize(new KeyGenParameterSpec.Builder("key2", KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                 .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                 .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
                 .build());
        SecretKey key = keyGenerator.generateKey();
    }



    private void good_generateKey() {
        // Good 
        //[...]
        final KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES,ANDROID_KEY_STORE);
        final KeyGenParameterSpec keyGenParameterSpec = new KeyGenParameterSpec.Builder(
                        keyName,
                        KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                        .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                        .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                        .build();
        keyGenerator.init(keyGenParameterSpec);
        secretKey = keyGenerator.generateKey();
    }
    

        
    private void vuln_generateKey3() {
        // Vulnerable 
        //[...]
        final KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES,ANDROID_KEY_STORE);
        // ruleid: MSTG-CRYPTO-4
        final KeyGenParameterSpec keyGenParameterSpec = new KeyGenParameterSpec.Builder(
                        keyName,
                        KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                        .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                        .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
                        .build();
        keyGenerator.init(keyGenParameterSpec);
        secretKey = keyGenerator.generateKey();
    }
    
    
    
        private void vuln_generateKey4() {
        // Vulnerable 
        //[...]
        final KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES,ANDROID_KEY_STORE);
        // ruleid: MSTG-CRYPTO-4
        final KeyGenParameterSpec keyGenParameterSpec = new KeyGenParameterSpec.Builder(
                        keyName,
                        KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                        .setBlockModes(KeyProperties.BLOCK_MODE_ECB)
                        .build();
        keyGenerator.init(keyGenParameterSpec);
        secretKey = keyGenerator.generateKey();
    }
    
    
    
    public String vuln_encrypt(String toEncrypt) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        // Vulnerable 
        //[...]
        // ruleid: MSTG-CRYPTO-4
        final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        //[...]
    }
    
    
    
    public String good_encrypt(String toEncrypt) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        // Good 
        //[...]
        final Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        //[...]
    }    
    
    
    
    public static String vuln_decrypt(String key, String data) {
	// Vulnerable 
        //[...]
        DESKeySpec dks = new DESKeySpec(key.getBytes());
        // ruleid: MSTG-CRYPTO-4
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        Key secretKey = keyFactory.generateSecret(dks);
	//[...]
    }    
    
    
}
