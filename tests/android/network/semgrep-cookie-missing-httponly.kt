public class CookieController {
    public fun setCookie(value: String, response: HttpServletResponse) {
        val cookie: Cookie = Cookie("cookie", value)
        // ruleid: android.semgrep.cookie-missing-httponly
        response.addCookie(cookie)
    }

    public fun setSecureCookie(value: String, response: HttpServletResponse) {
        val cookie: Cookie = Cookie("cookie", value)
        cookie.setSecure(true)
        // ruleid: android.semgrep.cookie-missing-httponly
        response.addCookie(cookie)
    }

    public fun setSecureHttponlyCookie(value: String, response: HttpServletResponse ) {
        val cookie: Cookie = Cookie("cookie", value)
        cookie.setSecure(true)
        cookie.setHttpOnly(true)
        // ok: android.semgrep.cookie-missing-httponly
        response.addCookie(cookie)
    }

    public fun explicitDisable(value: String, response: HttpServletResponse) {
        val cookie: Cookie = Cookie("cookie", value)
        cookie.setSecure(false)
        // ruleid:android.semgrep.cookie-missing-httponly
        cookie.setHttpOnly(false)
        response.addCookie(cookie)
    }
}
