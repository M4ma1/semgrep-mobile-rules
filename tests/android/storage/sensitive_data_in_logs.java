import java.io.BufferedWriter;
import java.util.logging.Logger;

public class LogTests {
    void directLog(String password, String token, String pwd, String secret, String apiKey, String email) {
        // ruleid: android.sensitive_data_in_logs
        Log.d("tag", "pw: " + password);
        // ruleid: android.sensitive_data_in_logs
        Log.i("tag", "token=" + token);
        // ruleid: android.sensitive_data_in_logs
        Log.e("tag", "login failed " + pwd);
        // ruleid: android.sensitive_data_in_logs
        Log.wtf("tag", "s " + secret);
        // ruleid: android.sensitive_data_in_logs
        Log.v("tag", String.format("t=%s", token));
        // ruleid: android.sensitive_data_in_logs
        Log.d("tag", "user email: " + email);
        // ruleid: android.sensitive_data_in_logs
        Log.d("tag",
              "key " + apiKey);
    }

    void printAndLoggers(String password, String secret, Logger l) {
        // ruleid: android.sensitive_data_in_logs
        System.out.println(password);
        // ruleid: android.sensitive_data_in_logs
        System.err.print("x" + secret);
        // ruleid: android.sensitive_data_in_logs
        System.out.println(password + " is the secret");
        // ruleid: android.sensitive_data_in_logs
        l.info("secret " + secret);
        // ruleid: android.sensitive_data_in_logs
        Timber.d("token " + secret);
    }

    void writer(String key) {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        // ruleid: android.sensitive_data_in_logs
        out.write("key: " + key);
    }

    void labels(String variable, String p, String t) {
        // ruleid: android.sensitive_data_in_logs
        Log.v("tag", "key: " + variable);
        // ruleid: android.sensitive_data_in_logs
        Log.i("tag", "password: " + p);
        // ruleid: android.sensitive_data_in_logs
        Log.d("tag", String.format("token %s", t));
    }

    void indirect(String password, int n) {
        // ruleid: android.sensitive_data_in_logs
        String msg = "p " + password;
        Log.d("tag", msg);
        // ruleid: android.sensitive_data_in_logs
        String line = "t=" + password;
        System.out.println(line);
        // ok: android.sensitive_data_in_logs
        String ok1 = "n=" + n;
        Log.d("tag", ok1);
        // ok: android.sensitive_data_in_logs
        String sent = "t=" + password;
        send(sent);
        Log.d("tag", "sent");
    }

    void safe(Exception e, int n, String screen) {
        // ok: android.sensitive_data_in_logs
        Log.d("tag", "started");
        // ok: android.sensitive_data_in_logs
        Log.e("tag", "failed: " + e.getMessage());
        // ok: android.sensitive_data_in_logs
        Log.i("tag", "count " + n);
        // ok: android.sensitive_data_in_logs
        Log.d("tag", "opened " + screen);
        // ok: android.sensitive_data_in_logs
        Log.e("tag", "Key not found in map");
        // ok: android.sensitive_data_in_logs
        Log.e("tag", "Key not " + "found");
        // ok: android.sensitive_data_in_logs
        System.out.println("it's ok");
        // ok: android.sensitive_data_in_logs
        System.out.println("count " + n);
    }
}
