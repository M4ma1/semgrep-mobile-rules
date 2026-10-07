import javax.crypto.Cipher;

class RsaTests {
    static final String T = "RSA/ECB/NoPadding";

    void vulnerable(Key k) throws Exception {
        // ruleid: android.rsa_no_oaep
        Cipher a = Cipher.getInstance("RSA/ECB/NoPadding");
        // ruleid: android.rsa_no_oaep
        Cipher b = Cipher.getInstance("RSA/None/NoPadding");
        // ruleid: android.rsa_no_oaep
        Cipher c = Cipher.getInstance("rsa/ecb/nopadding");
        // ruleid: android.rsa_no_oaep
        javax.crypto.Cipher d = javax.crypto.Cipher.getInstance("RSA/ECB/NoPadding", "BC");
        // ruleid: android.rsa_no_oaep
        Cipher e = Cipher.getInstance(T);
        // ruleid: android.rsa_no_oaep
        Cipher.getInstance("RSA/ECB/NoPadding").init(Cipher.ENCRYPT_MODE, k);
        String alg = "RSA/ECB/NoPadding";
        // ruleid: android.rsa_no_oaep
        Cipher f = Cipher.getInstance(alg);
    }

    void safe() throws Exception {
        // ok: android.rsa_no_oaep
        Cipher a = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        // ok: android.rsa_no_oaep
        Cipher b = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        // ok: android.rsa_no_oaep
        Cipher c = Cipher.getInstance("RSA");
        // ok: android.rsa_no_oaep
        Cipher d = Cipher.getInstance("AES/GCM/NoPadding");
        // ok: android.rsa_no_oaep
        Object e = Foo.getInstance("RSA/ECB/NoPadding");
    }
}
