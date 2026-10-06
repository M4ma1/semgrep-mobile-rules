import javax.net.ssl.*;
import java.security.cert.*;
import android.webkit.*;

// ===== TrustManager.checkServerTrusted =====
class T1 implements X509TrustManager {
    public void checkClientTrusted(X509Certificate[] c, String a) throws CertificateException {}
    // ruleid: android.insecure_tls_validation
    public void checkServerTrusted(X509Certificate[] c, String a) throws CertificateException {}
    public X509Certificate[] getAcceptedIssuers() { return d.getAcceptedIssuers(); }
}
class T2 implements X509TrustManager {
    public void checkClientTrusted(X509Certificate[] c, String a) {}
    // ruleid: android.insecure_tls_validation
    public void checkServerTrusted(X509Certificate[] c, String a) {}
    public X509Certificate[] getAcceptedIssuers() { return d.getAcceptedIssuers(); }
}
class T3 implements X509TrustManager {
    public void checkClientTrusted(X509Certificate[] c, String a) {}
    // ruleid: android.insecure_tls_validation
    public void checkServerTrusted(X509Certificate[] c, String a) { System.out.println("x"); }
    public X509Certificate[] getAcceptedIssuers() { return d.getAcceptedIssuers(); }
}
class T4 implements X509TrustManager {
    public void checkClientTrusted(java.security.cert.X509Certificate[] c, String a) {}
    // ruleid: android.insecure_tls_validation
    public void checkServerTrusted(java.security.cert.X509Certificate[] c, String a) throws CertificateException {}
    public X509Certificate[] getAcceptedIssuers() { return d.getAcceptedIssuers(); }
}
class T5 implements X509TrustManager {
    X509TrustManager d;
    public void checkClientTrusted(X509Certificate[] c, String a) {}
    // ruleid: android.insecure_tls_validation
    public void checkServerTrusted(X509Certificate[] c, String a) throws CertificateException {
        try { d.checkServerTrusted(c, a); } catch (CertificateException e) { }
    }
    public X509Certificate[] getAcceptedIssuers() { return d.getAcceptedIssuers(); }
}
class T6 implements X509TrustManager {
    public void checkClientTrusted(X509Certificate[] c, String a, java.net.Socket s) {}
    // ruleid: android.insecure_tls_validation
    public void checkServerTrusted(X509Certificate[] c, String a, java.net.Socket s) {}
    public X509Certificate[] getAcceptedIssuers() { return d.getAcceptedIssuers(); }
}
class S1 implements X509TrustManager {
    X509TrustManager d;
    public void checkClientTrusted(X509Certificate[] c, String a) throws CertificateException { d.checkClientTrusted(c, a); }
    // ok: android.insecure_tls_validation
    public void checkServerTrusted(X509Certificate[] c, String a) throws CertificateException { d.checkServerTrusted(c, a); }
    public X509Certificate[] getAcceptedIssuers() { return d.getAcceptedIssuers(); }
}
class S2 implements X509TrustManager {
    public void checkClientTrusted(X509Certificate[] c, String a) throws CertificateException {}
    // ok: android.insecure_tls_validation
    public void checkServerTrusted(X509Certificate[] c, String a) throws CertificateException {
        throw new CertificateException("never trust");
    }
    public X509Certificate[] getAcceptedIssuers() { return d.getAcceptedIssuers(); }
}
class S3 implements X509TrustManager {
    public void checkClientTrusted(X509Certificate[] c, String a) {}
    // ok: android.insecure_tls_validation
    public void checkServerTrusted(X509Certificate[] c, String a) throws CertificateException {
        if (!ok(c)) { throw new CertificateException("bad"); }
    }
    public X509Certificate[] getAcceptedIssuers() { return d.getAcceptedIssuers(); }
}

// ===== getAcceptedIssuers / SSLContext.init(null) =====
class G1 implements X509TrustManager {
    // ruleid: android.insecure_tls_validation
    public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
}
class G2 implements X509TrustManager {
    // ruleid: android.insecure_tls_validation
    public X509Certificate[] getAcceptedIssuers() { return null; }
}
class G3 implements X509TrustManager {
    // ok: android.insecure_tls_validation
    public X509Certificate[] getAcceptedIssuers() { return trusted; }
}
class I1 {
    void m(TrustManager[] trustAll) throws Exception {
        // ruleid: android.insecure_tls_validation
        SSLContext ctx = SSLContext.getInstance("TLS");
        ctx.init(null, trustAll, new SecureRandom());
    }
}
class I2 {
    void m() throws Exception {
        // ok: android.insecure_tls_validation
        SSLContext ctx = SSLContext.getInstance("TLS");
        ctx.init(null, null, null);
    }
}
class I3 {
    void m(TrustManagerFactory tmf) throws Exception {
        // custom trust store: kept as a finding (review that only intended CAs are trusted)
        // ruleid: android.insecure_tls_validation
        SSLContext ctx = SSLContext.getInstance("TLS");
        ctx.init(null, tmf.getTrustManagers(), null);
    }
}
class I4 {
    void m(TrustManager[] trustAll) throws Exception {
        // ruleid: android.insecure_tls_validation
        sslContext.init(null, trustAll, new SecureRandom());
    }
}
class I5 {
    void m() throws Exception {
        // ok: android.insecure_tls_validation
        sslContext.init(null, null, null);
    }
}

// ===== HostnameVerifier =====
class H1 implements HostnameVerifier {
    // ruleid: android.insecure_tls_validation
    public boolean verify(String h, SSLSession s) { return true; }
}
class H2 implements HostnameVerifier {
    // ruleid: android.insecure_tls_validation
    public boolean verify(String h, SSLSession s) { System.out.println(h); return true; }
}
class H3 {
    HostnameVerifier v = new HostnameVerifier() {
        // ruleid: android.insecure_tls_validation
        public boolean verify(String h, SSLSession s) { return true; }
    };
}
class H5 {
    // ruleid: android.insecure_tls_validation
    HostnameVerifier v = org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
}
class H7 implements HostnameVerifier {
    // ruleid: android.insecure_tls_validation
    public boolean verify(String host, SSLSession sess) { return true; }
}
class HS1 {
    HostnameVerifier v = new HostnameVerifier() {
        // ok: android.insecure_tls_validation
        public boolean verify(String h, SSLSession s) { return h.endsWith(".example.com"); }
    };
}
class HS2 {
    HostnameVerifier v = new HostnameVerifier() {
        // ok: android.insecure_tls_validation
        public boolean verify(String h, SSLSession s) { return HttpsURLConnection.getDefaultHostnameVerifier().verify(h, s); }
    };
}

// ===== WebView onReceivedSslError =====
class W1 extends WebViewClient {
    // ruleid: android.insecure_tls_validation
    public void onReceivedSslError(WebView v, SslErrorHandler h, SslError e) { h.proceed(); }
}
class W2 extends WebViewClient {
    // ruleid: android.insecure_tls_validation
    public void onReceivedSslError(WebView v, SslErrorHandler h, SslError e) { Log.d("x", "err"); h.proceed(); }
}
class W3 extends WebViewClient {
    // ruleid: android.insecure_tls_validation
    public void onReceivedSslError(WebView v, SslErrorHandler h, SslError e) { if (BuildConfig.DEBUG) { h.proceed(); } else { h.cancel(); } }
}
class W4 extends WebViewClient {
    // ruleid: android.insecure_tls_validation
    public void onReceivedSslError(android.webkit.WebView v, android.webkit.SslErrorHandler h, android.net.http.SslError e) { h.proceed(); }
}
class W5 extends WebViewClient {
    // ruleid: android.insecure_tls_validation
    public void onReceivedSslError(WebView v, SslErrorHandler h, SslError e) { h.proceed(); Log.d("x", "y"); }
}
class WS1 extends WebViewClient {
    // ok: android.insecure_tls_validation
    public void onReceivedSslError(WebView v, SslErrorHandler h, SslError e) { h.cancel(); }
}
class WS2 extends WebViewClient {
    // ok: android.insecure_tls_validation
    public void onReceivedSslError(WebView v, SslErrorHandler h, SslError e) { showError(e); h.cancel(); }
}
