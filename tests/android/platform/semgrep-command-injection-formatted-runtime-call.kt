class Cls {
    fun Cls(input: String) {
        val r: Runtime = Runtime.getRuntime()
        // ruleid: android.semgrep.command-injection-formatted-runtime-call
        r.exec("/bin/sh -c some_tool" + input)
    }

    fun test1(input: String) {
        val r: Runtime = Runtime.getRuntime()
        // ruleid: android.semgrep.command-injection-formatted-runtime-call
        r.loadLibrary(String.format("%s.dll", input))
    }

    fun test2(input: String) {
        val r: Runtime = Runtime.getRuntime()
        // ok: android.semgrep.command-injection-formatted-runtime-call
        r.exec("echo 'blah'")
    }
}
