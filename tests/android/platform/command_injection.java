import java.lang.Runtime;

class Cls {

    public void direct(String foo) throws Exception {
        // ruleid:android.mobsf.command_injection
        Process process = Runtime.getRuntime().exec("ping somewhere.com" + foo);
    }

    public void directLiteral() throws Exception {
        // ok:android.mobsf.command_injection
        Process process = Runtime.getRuntime().exec("ping somewhere.com");
    }

    public Cls(String input) {
        Runtime r = Runtime.getRuntime();
        // ruleid:android.mobsf.command_injection
        r.exec("/bin/sh -c some_tool" + input);
    }

    public void test1(String input) {
        Runtime r = Runtime.getRuntime();
        // ruleid:android.mobsf.command_injection
        r.loadLibrary(String.format("%s.dll", input));
    }

    public void test2(String input) {
        Runtime r = Runtime.getRuntime();
        // ruleid:android.mobsf.command_injection
        r.exec("bash", "-c", input);
    }

    public void okTest(String input) {
        Runtime r = Runtime.getRuntime();
        // ok: android.mobsf.command_injection
        r.exec("echo 'blah'");
    }
}
