public class A{
    // ruleid: MSTG-CRYPTO-1
    byte[] key = new byte[]{2,7,2,9};
    byte[] iv = new byte[]{12};
    
    private byte[] aes(byte[] data, int mode){
        Cipher cipher = Cipher.getInstance(AES_MODE);
        cipher.init(mode, new SecretKeySpec(this.key, "AES"), new IvParameterSpec(iv));
        return cipher.doFinal(data);
    }
}
public class B{
    // ruleid: MSTG-CRYPTO-1
    String key = "SuperPassword123!";
    byte[] iv = new byte[]{12};
    
    private byte[] aes(byte[] data, int mode){
        Cipher cipher = Cipher.getInstance(AES_MODE);
        cipher.init(mode, new SecretKeySpec(this.key.getBytes(), "AES"), new IvParameterSpec(iv));
        return cipher.doFinal(data);
    }
}
public class C{
    String key;
    byte[] iv = new byte[]{12};
    
    private byte[] aes(byte[] data, int mode){
        // ruleid: MSTG-CRYPTO-1
        key = getString(R.string.key);
        Cipher cipher = Cipher.getInstance(AES_MODE);
        cipher.init(mode, new SecretKeySpec(key.toByteArray(), "AES"), new IvParameterSpec(iv));
        return cipher.doFinal(data);
    }
}

// Cases ported from android.mobsf.aes_hardcoded_key / android.owasp.hardcoded-crypto-keys-usage
public class D{
    private void literalDirect() throws Exception {
        // ruleid: MSTG-CRYPTO-1
        new SecretKeySpec("hardcoded".getBytes(), "AES");
    }
    private void literalAssigned(Cipher cipher) throws Exception {
        // ruleid: MSTG-CRYPTO-1
        SecretKeySpec secret = new SecretKeySpec("hardcoded".getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secret);
    }
    private void literalViaLocalString(Cipher cipher) throws Exception {
        String p = "hardcoded";
        // ruleid: MSTG-CRYPTO-1
        SecretKeySpec secret = new SecretKeySpec(p.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secret);
    }
    private void byteArrayLiteral() throws Exception {
        // ruleid: MSTG-CRYPTO-1
        byte[] k = {1, 2, 3, 4};
        new SecretKeySpec(k, "AES");
    }
    private void otherAlgorithm() throws Exception {
        // ruleid: MSTG-CRYPTO-1
        SecretKeySpec s = new SecretKeySpec("hardcoded".getBytes(), "DES");
    }
    private void okFromParam(byte[] key) throws Exception {
        // ok: MSTG-CRYPTO-1
        SecretKeySpec s = new SecretKeySpec(key, "AES");
    }
    private void okFromPassword(String password) throws Exception {
        // ok: MSTG-CRYPTO-1
        SecretKeySpec s = new SecretKeySpec(password.getBytes(), "AES");
    }
}
