let username = getUsername()
let passphrase = getPass()


// okid: ios.semgrep.swift-user-defaults
UserDefaults.standard.set(username, forKey: "userName")
// ruleid: ios.semgrep.swift-user-defaults
UserDefaults.standard.set(passphrase, forKey: "passphrase")
// ruleid: ios.semgrep.swift-user-defaults
UserDefaults.standard.set(passWord, forKey: "userPassword")

// ruleid: ios.semgrep.swift-user-defaults
UserDefaults.standard.set("12717-127163-a71367-127ahc", forKey: "apiKey")

let apiKey = "12717-127163-a71367-127ahc"
// ruleid: ios.semgrep.swift-user-defaults
UserDefaults.standard.set(apiKey, forKey: "GOOGLE_TOKEN")


let key = "1sdad3SADSD33131"
// ruleid: ios.semgrep.swift-user-defaults
UserDefaults.standard.set(key, forKey: "cryptoKey")


let key = "foobar"
// ruleid: ios.semgrep.swift-user-defaults
UserDefaults.standard.set(key, forKey: "clientSecret")


let key = "foobar"
// ruleid: ios.semgrep.swift-user-defaults
UserDefaults.standard.set(key, forKey: "rsaPrivateKey")

// ruleid: ios.semgrep.swift-user-defaults
UserDefaults.standard.set(passphrase, forKey: "pass_phrase")