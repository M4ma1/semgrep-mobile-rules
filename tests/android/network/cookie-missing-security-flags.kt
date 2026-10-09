import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

class CookieFlags {
    fun missingBoth(value: String, response: HttpServletResponse) {
        val cookie: Cookie = Cookie("cookie", value)
        // ruleid: android.cookie-missing-security-flags
        response.addCookie(cookie)
    }

    fun missingHttpOnly(value: String, response: HttpServletResponse) {
        val cookie: Cookie = Cookie("cookie", value)
        cookie.setSecure(true)
        // ruleid: android.cookie-missing-security-flags
        response.addCookie(cookie)
    }

    fun missingSecure(value: String, response: HttpServletResponse) {
        val cookie: Cookie = Cookie("cookie", value)
        cookie.setHttpOnly(true)
        // ruleid: android.cookie-missing-security-flags
        response.addCookie(cookie)
    }

    fun bothSet(value: String, response: HttpServletResponse) {
        val cookie: Cookie = Cookie("cookie", value)
        cookie.setSecure(true)
        cookie.setHttpOnly(true)
        // ok: android.cookie-missing-security-flags
        response.addCookie(cookie)
    }

    fun httpOnlyExplicitlyFalse(value: String, response: HttpServletResponse) {
        val cookie: Cookie = Cookie("cookie", value)
        cookie.setSecure(true)
        // ruleid: android.cookie-missing-security-flags
        cookie.setHttpOnly(false)
        response.addCookie(cookie)
    }

    fun secureExplicitlyFalse(value: String, response: HttpServletResponse) {
        val cookie: Cookie = Cookie("cookie", value)
        cookie.setHttpOnly(true)
        // ruleid: android.cookie-missing-security-flags
        cookie.setSecure(false)
        response.addCookie(cookie)
    }

    fun bothExplicitlyFalse(value: String, response: HttpServletResponse) {
        val cookie: Cookie = Cookie("cookie", value)
        // ruleid: android.cookie-missing-security-flags
        cookie.setSecure(false)
        // ruleid: android.cookie-missing-security-flags
        cookie.setHttpOnly(false)
        response.addCookie(cookie)
    }

    fun clearCookie(existingCookie: Cookie, response: HttpServletResponse) {
        existingCookie.setValue("")
        existingCookie.setMaxAge(0)
        // ok: android.cookie-missing-security-flags
        response.addCookie(existingCookie)
    }
}

// Fully qualified servlet types (ported from the former GitLab cookie rules)
class QualifiedCookieFlags {
    fun dangerJavaxMissingBoth(res: javax.servlet.http.HttpServletResponse) {
        val cookie = javax.servlet.http.Cookie("key", "value")
        cookie.setMaxAge(60)
        // ruleid: android.cookie-missing-security-flags
        res.addCookie(cookie)
    }

    fun dangerJavaxHttpOnlyFalse(res: javax.servlet.http.HttpServletResponse) {
        val cookie = javax.servlet.http.Cookie("key", "value")
        cookie.setSecure(true)
        cookie.setMaxAge(60)
        // ruleid: android.cookie-missing-security-flags
        cookie.setHttpOnly(false)
        res.addCookie(cookie)
    }

    fun dangerJavaxSecureFalse(res: javax.servlet.http.HttpServletResponse) {
        val cookie = javax.servlet.http.Cookie("key", "value")
        // ruleid: android.cookie-missing-security-flags
        cookie.setSecure(false)
        cookie.setMaxAge(60)
        cookie.setHttpOnly(true)
        res.addCookie(cookie)
    }

    fun safeJavax(response: javax.servlet.http.HttpServletResponse) {
        val myCookie = javax.servlet.http.Cookie("key", "value")
        myCookie.setSecure(true)
        myCookie.setHttpOnly(true)
        myCookie.setMaxAge(60)
        // ok: android.cookie-missing-security-flags
        response.addCookie(myCookie)
    }

    fun dangerJakartaMissingBoth(response: jakarta.servlet.http.HttpServletResponse) {
        val myCookie = jakarta.servlet.http.Cookie("key", "value")
        myCookie.setMaxAge(60)
        // ruleid: android.cookie-missing-security-flags
        response.addCookie(myCookie)
    }

    fun dangerJakartaHttpOnlyOnly(response: jakarta.servlet.http.HttpServletResponse) {
        val myCookie = jakarta.servlet.http.Cookie("key", "value")
        myCookie.setHttpOnly(true)
        myCookie.setMaxAge(60)
        // ruleid: android.cookie-missing-security-flags
        response.addCookie(myCookie)
    }

    fun safeJakarta(response: jakarta.servlet.http.HttpServletResponse) {
        val myCookie = jakarta.servlet.http.Cookie("key", "value")
        myCookie.setSecure(true)
        myCookie.setHttpOnly(true)
        myCookie.setMaxAge(60)
        // ok: android.cookie-missing-security-flags
        response.addCookie(myCookie)
    }
}
