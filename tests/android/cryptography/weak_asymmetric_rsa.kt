import java.security.KeyPairGenerator

// ruleid: android.weak_asymmetric_rsa
val keyGen_weak = KeyPairGenerator.getInstance("RSA")
keyGen_weak.initialize(512)

// ruleid: android.weak_asymmetric_rsa
val keyGen_weak_again = KeyPairGenerator.getInstance("RSA")
keyGen_weak_again.initialize(2048)

// ok: android.weak_asymmetric_rsa
val keyGen = KeyPairGenerator.getInstance("RSA")
keyGen.initialize(3072)