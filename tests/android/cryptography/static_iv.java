import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

class StaticIv {
    private static byte[] myIV = new byte[16] {};
    private byte[] myIV_ok = new byte[16] {};

    // from android.static_iv: IV kept in a static field
    void staticField() {
        // ruleid: android.static_iv
        IvParameterSpec ivSpec = new IvParameterSpec(myIV);
    }

    void nonStaticField() {
        // ok: android.static_iv
        IvParameterSpec ivSpec = new IvParameterSpec(myIV_ok);
    }

    // from android.mobsf.cbc_static_iv: hardcoded string IV
    void stringIv(String strKey, String plainText) throws Exception {
        // ruleid: android.static_iv
        byte[] bytesIV = "foo".getBytes("UTF-8");

        IvParameterSpec iv = new IvParameterSpec(bytesIV);
        SecretKeySpec skeySpec = new SecretKeySpec(strKey.getBytes("UTF-8"), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
    }

    // from android.mobsf.cbc_static_iv: hardcoded byte array IV
    void arrayIv(String strKey, String plainText) throws Exception {
        // ruleid: android.static_iv
        byte[] bytesIV1 = {
            0x01, 0x02, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00
        };

        IvParameterSpec iv = new IvParameterSpec(bytesIV1);
        SecretKeySpec skeySpec = new SecretKeySpec(strKey.getBytes("UTF-8"), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
    }

    // from android.mobsf.weak_iv: weak all-zero IV with DES
    void weakIv(byte[] inpBytes) throws Exception {
        // ruleid: android.static_iv
        byte[] iv = {
            0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00
        };
        IvParameterSpec ips = new IvParameterSpec(iv);
        Cipher cp = Cipher.getInstance("DES/CBC/PKCS5Padding");
    }

    // widened: a hardcoded IV is flagged whatever the cipher mode is
    void ctrMode() throws Exception {
        // ruleid: android.static_iv
        byte[] iv = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1, 2};
        IvParameterSpec s = new IvParameterSpec(iv);
        Cipher c = Cipher.getInstance("AES/CTR/NoPadding");
    }

    // random IV is fine
    String randomIv(String strKey, String plainText) throws Exception {
        SecureRandom random = new SecureRandom();
        byte[] bytesIV = new byte[16];
        random.nextBytes(bytesIV);

        // ok: android.static_iv
        IvParameterSpec iv = new IvParameterSpec(bytesIV);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        return null;
    }

    // IV built inline from a hardcoded value
    void inlineZeroArray() {
        // ruleid: android.static_iv
        IvParameterSpec s = new IvParameterSpec(new byte[16]);
    }

    void inlineArrayLiteral() {
        // ruleid: android.static_iv
        IvParameterSpec s = new IvParameterSpec(new byte[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    void inlineString() {
        // ruleid: android.static_iv
        IvParameterSpec s = new IvParameterSpec("0123456789abcdef".getBytes());
    }

    void okFromParameter(byte[] p) {
        // ok: android.static_iv
        IvParameterSpec s = new IvParameterSpec(p);
    }
}
