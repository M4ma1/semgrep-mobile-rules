import javax.crypto.Cipher;
import javax.crypto.NullCipher;

class NullCipherTests {
    Cipher field;

    // ruleid: android.insecure_null_cipher
    Cipher initialised = new NullCipher();

    void vulnerable(OutputStream out) throws Exception {
        // ruleid: android.insecure_null_cipher
        Cipher a = new NullCipher();
        // ruleid: android.insecure_null_cipher
        Cipher b = new javax.crypto.NullCipher();
        // ruleid: android.insecure_null_cipher
        CipherOutputStream s = new CipherOutputStream(out, new NullCipher());
        // ruleid: android.insecure_null_cipher
        new NullCipher();
        // ruleid: android.insecure_null_cipher
        field = new NullCipher();
        // ruleid: android.insecure_null_cipher
        NullCipher nullc = new NullCipher();
    }

    Cipher factory() {
        // ruleid: android.insecure_null_cipher
        return new NullCipher();
    }

    void safe(NullCipher param) throws Exception {
        // ok: android.insecure_null_cipher
        Cipher a = Cipher.getInstance("AES/GCM/NoPadding");
        // ok: android.insecure_null_cipher
        Log.d("t", "NullCipher is bad");
        // ok: android.insecure_null_cipher
        Object c = new NullCipherFactory();
    }
}
