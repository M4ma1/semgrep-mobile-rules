import javax.crypto.spec.IvParameterSpec;

private static byte[] myIV = new byte[16] {};
// ruleid: android.static_iv
IvParameterSpec ivSpec = new IvParameterSpec(myIV);

private byte[] myIV_ok = new byte[16] {};
// ok: android.static_iv
IvParameterSpec ivSpec = new IvParameterSpec(myIV_ok);