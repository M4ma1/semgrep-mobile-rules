import RealmSwiftRealm

func ok() throws {
    var key = Data(count: 64)
    // assuming the key is generated correctly
    var config = Realm.Configuration(encryptionKey: key)
    // ok:ios.weak_realm
    let realm = try Realm(configuration: config)
}

func ok_again() throws {
    var key = Data(count: 64)
    // assuming the key is generated correctly
    var config: Realm.Configuration = .init(encryptionKey: key)
    // ok:ios.weak_realm
    let realm = try Realm(configuration: config)
}

func ok_again_2() throws {
    var key = Data(count: 64)
    // assuming the key is generated correctly
    var config = Realm.Configuration(syncConfiguration: nil, encryptionKey: key, readOnly: false)
    // ok:ios.weak_realm
    let realm = try Realm(configuration: config)
}

func ok_again_3() throws {
    var key = Data(count: 64)
    // assuming the key is generated correctly
    var config: Realm.Configuration = .init(syncConfiguration: nil, encryptionKey: key, readOnly: false)
    // ok:ios.weak_realm
    let realm = try Realm(configuration: config)
}

func bad_no_encryption() throws {
    var config = Realm.Configuration()
    // ruleid:ios.weak_realm
    let realm = try Realm(configuration: config)
}

func bad_no_encryption_again() throws {
    var config: Realm.Configuration = .init()
    // ruleid:ios.weak_realm
    let realm = try Realm(configuration: config)
}

func bad_no_encryption_again_2() throws {
    var config = Realm.Configuration(syncConfiguration: nil)
    // ruleid:ios.weak_realm
    let realm = try Realm(configuration: config)
}

func bad_no_encryption_again_3() throws {
    var config: Realm.Configuration = .init(syncConfiguration: nil)
    // ruleid:ios.weak_realm
    let realm = try Realm(configuration: config)
}

func bad_no_configuration_again_4() throws {
    // ruleid:ios.weak_realm
    let realm = try Realm()
}