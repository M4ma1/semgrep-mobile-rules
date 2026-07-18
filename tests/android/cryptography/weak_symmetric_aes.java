import java.security.KeyPairGenerator;

// ruleid: android.weak_symmetric_aes
KeyPairGenerator keyGen_weak = KeyPairGenerator.getInstance("AES");
keyGen_weak.initialize(128);

// ruleid: android.weak_symmetric_aes
KeyPairGenerator keyGen_weak_again = KeyPairGenerator.getInstance("AES");
keyGen_weak_again.initialize(192);

// ok: android.weak_symmetric_aes
KeyPairGenerator keyGen = KeyPairGenerator.getInstance("AES");
keyGen.initialize(256);