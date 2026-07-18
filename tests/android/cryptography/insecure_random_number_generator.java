import java.util.Random;
import java.lang.*;
import java.security.SecureRandom;

// ok: android.insecure_random_number_generator
SecureRandom sRandom_ok = new SecureRandom();
// ruleid: android.insecure_random_number_generator
SecureRandom sRandom_ko = new SecureRandom(12);
// ruleid: android.insecure_random_number_generator
Random random = new Random();
// ruleid: android.insecure_random_number_generator
int math_r = 1 + Math.random();