import javax.crypto.NullCipher

class NullCipherTests {
  def vulnerable(out: OutputStream): Unit = {
    // ruleid: android.insecure_null_cipher
    val a = new NullCipher()
    // ruleid: android.insecure_null_cipher
    val s = new CipherOutputStream(out, new NullCipher())
  }

  def safe(): Unit = {
    // ok: android.insecure_null_cipher
    val c = Cipher.getInstance("AES/GCM/NoPadding")
  }
}
