public class OverlayProtection {
    void harden(View webView) {
        // ruleid: android.owasp.overlay-protection-setfiltertoucheswhenobscured
        webView.getView().setFilterTouchesWhenObscured(true);
    }
}
