import example


// Check pinning for AlamoFire old versions (ver < 5.x)
public class NetworkManager_oldAlamoFire {
    fileprivate (set) var requestsDictionary: [String : [NetworkRequest]] = [ : ]
    
    public static let manager: Alamofire.SessionManager_1 = {
   
        let configuration = URLSessionConfiguration.default
        configuration.httpAdditionalHeaders = Alamofire.SessionManager.defaultHTTPHeaders
        configuration.timeoutIntervalForRequest = Configuration.defaultTimeout
        
        
        // ruleid: ios.akabe1.alamofire-pinning
        let serverTrustPolicies: [String: ServerTrustPolicy] = [
            "pin.test.net": trustPolicyPinning,
            "insecure.example.net": .disableevaluation,
            "insecure.test.com": .disableEvaluation,
            "pin.example.com": trustPolicyPinning,
            "pin.test.net": trustPolicyPinning,
            "insecure.asd.gov": .disableEvaluation,
        ]

        return Alamofire.SessionManager(configuration: configuration, serverTrustPolicyManager: ServerTrustPolicyManager(policies: serverTrustPolicies))
    }()


    public static let manager: Alamofire.SessionManager_2 = {
        // ruleid: ios.akabe1.alamofire-pinning
        let serverTrustPolicies: [String: ServerTrustPolicy] = [
            "test.example.com": .PinCertificates(
                certificates: ServerTrustPolicy.certificatesInBundle(),
                validateCertificateChain: false, 
                validateHost: true
            ),
            "insecure.expired-apis.com": trustPolicyPinning
        ]
        return Alamofire.SessionManager(configuration: configuration, serverTrustPolicyManager: ServerTrustPolicyManager(policies: serverTrustPolicies))
    }()



    public static let manager: Alamofire.SessionManager_3 = {
        // ruleid: ios.akabe1.alamofire-pinning
        let serverTrustPolicies: [String: ServerTrustPolicy] = [
            "test.example.com": .PinCertificates(
                certificates: ServerTrustPolicy.certificatesInBundle(),
                validateCertificateChain: true, 
                validateHost: false
            ),
            "pin.example-apis.com": trustPolicyPinning
        ]
        return Alamofire.SessionManager(configuration: configuration, serverTrustPolicyManager: ServerTrustPolicyManager(policies: serverTrustPolicies))
    }()        
        

    public static let manager: Alamofire.SessionManager_4 = {
        // ruleid: ios.akabe1.alamofire-pinning
        let serverTrustPolicies: [String: ServerTrustPolicy] = [
            "test.example.com": .PinPublicKeys(
                keys: ServerTrustPolicy.keysInBundle(),
                validateCertificateChain: true, 
                validateHost: false
            ),
            "pin.example-apis.com": trustPolicyPinning
        ]
        return Alamofire.SessionManager(configuration: configuration, serverTrustPolicyManager: ServerTrustPolicyManager(policies: serverTrustPolicies))
    }()


    public static let manager: Alamofire.SessionManager_5 = {
        // ruleid: ios.akabe1.alamofire-pinning
        let serverTrustPolicies: [String: ServerTrustPolicy] = [
            "test.example.com": .PinPublicKeys(
                keys: ServerTrustPolicy.keysInBundle(),
                validateCertificateChain: false, 
                validateHost: true
            ),
            "pin.example-apis.com": trustPolicyPinning
        ]
        return Alamofire.SessionManager(configuration: configuration, serverTrustPolicyManager: ServerTrustPolicyManager(policies: serverTrustPolicies))
    }()

    public static let manager: Alamofire.SessionManager_6 = {
        // ok: ios.akabe1.alamofire-pinning
        let serverTrustPolicies: [String: ServerTrustPolicy] = [
            "test.example.com": .PinPublicKeys(
                keys: ServerTrustPolicy.keysInBundle(),
                validateCertificateChain: true, 
                validateHost: true
            ),
            "pin.example-apis.com": trustPolicyPinning
        ]
        return Alamofire.SessionManager(configuration: configuration, serverTrustPolicyManager: ServerTrustPolicyManager(policies: serverTrustPolicies))
    }()
    
}  




// Check pinning for AlamoFire v5.x
class class_newAlamoFire: ServerTrustPolicyTestCase {
    // MARK: Validate Certificate Chain Without Validating Host


    func foo1() {
        let host = "test.alamofire.org"
        let serverTrust = TestTrusts.leafValidDNSName.trust
        let certificates = [TestCertificates.leafValidDNSName]
        // ruleid: ios.akabe1.alamofire-pinning
        let serverTrustPolicy = PinnedCertificatesTrustEvaluator(certificates: certificates,
                                                                 performDefaultValidation: false,
                                                                 validateHost: false)

        let result = Result { try serverTrustPolicy.evaluate(serverTrust, forHost: host) }
        XCTAssertTrue(result.isSuccess, "server trust should pass evaluation")
    }


    func foo2() {
        let host = "test.alamofire.org"
        let serverTrust = TestTrusts.leafValidDNSName.trust
        let certificates = [TestCertificates.leafValidDNSName]
        // ruleid: ios.akabe1.alamofire-pinning
        let serverTrustPolicy = PinnedCertificatesTrustEvaluator(certificates: certificates, acceptSelfSignedCertificates: true)
        let result = Result { try serverTrustPolicy.evaluate(serverTrust, forHost: host) }
        XCTAssertTrue(result.isSuccess, "server trust should pass evaluation")
    }



    func foo3() {
        let host = "test.alamofire.org"
        let serverTrust = TestTrusts.leafValidDNSName.trust
        let keys = [TestCertificates.leafValidDNSName].af.publicKeys
        // ruleid: ios.akabe1.alamofire-pinning
        let serverTrustPolicy = PublicKeysTrustEvaluator(keys: keys, validateHost: false)
        setRootCertificateAsLoneAnchorCertificateForTrust(serverTrust)
        let result = Result { try serverTrustPolicy.evaluate(serverTrust, forHost: host) }
        XCTAssertTrue(result.isSuccess, "server trust should pass evaluation")
    }


    func foo4() {
        let host = "test.alamofire.org"
        let serverTrust = TestTrusts.leafExpired.trust
        let certificates = [TestCertificates.rootCA]
        // ruleid: ios.akabe1.alamofire-pinning
        let serverTrustPolicy = PinnedCertificatesTrustEvaluator(certificates: certificates,
                                                                 performDefaultValidation: false,
                                                                 acceptSelfSignedCertificates: true,
                                                                 validateHost: true)

        let result = Result { try serverTrustPolicy.evaluate(serverTrust, forHost: host) }
        XCTAssertTrue(result.isSuccess, "server trust should pass evaluation")
    }



    func foo5() {
        let host = "test.alamofire.org"
        let serverTrust = TestTrusts.leafExpired.trust
        let certificates = [TestCertificates.rootCA]
        // ruleid: ios.akabe1.alamofire-pinning
        let serverTrustPolicy = PinnedCertificatesTrustEvaluator(certificates: certificates,
                                                                 performDefaultValidation: false)

        let result = Result { try serverTrustPolicy.evaluate(serverTrust, forHost: host) }
        XCTAssertTrue(result.isSuccess, "server trust should pass evaluation")
    }



    func foo6() {
        let host = "test.alamofire.org"
        let serverTrust = TestTrusts.leafValidDNSName.trust
        let keys = [TestCertificates.leafValidDNSName].af.publicKeys
        // ok: ios.akabe1.alamofire-pinning
        let serverTrustPolicy = PublicKeysTrustEvaluator(keys: keys)
        setRootCertificateAsLoneAnchorCertificateForTrust(serverTrust)
        let result = Result { try serverTrustPolicy.evaluate(serverTrust, forHost: host) }
        XCTAssertTrue(result.isSuccess, "server trust should pass evaluation")
    }



    func foo7() {
        let host = "test.alamofire.org"
        let serverTrust = TestTrusts.leafValidDNSName.trust
        let keys = [TestCertificates.leafValidDNSName].af.publicKeys
        // ok: ios.akabe1.alamofire-pinning
        let serverTrustPolicy = PublicKeysTrustEvaluator(keys: keys, validateHost: true)
        setRootCertificateAsLoneAnchorCertificateForTrust(serverTrust)
        let result = Result { try serverTrustPolicy.evaluate(serverTrust, forHost: host) }
        XCTAssertTrue(result.isSuccess, "server trust should pass evaluation")
    }




    func foo8() {
        // ok: ios.akabe1.alamofire-pinning
        let evaluators: [String: ServerTrustEvaluating] = [
                "your.domain.com": PublicKeysTrustEvaluator(
                performDefaultValidation: true,
                acceptSelfSignedCertificates: false,
                validateHost: true)
        ]
        // ruleid: ios.akabe1.alamofire-pinning
        let serverTrustManager = ServerTrustManager(evaluators: evaluators, [ "demo.test.com": DisabledEvaluator()])
        let session = Session(serverTrustManager: serverTrustManager)
    }




    func foo9() {
        // ruleid: ios.akabe1.alamofire-pinning
        let session = Session(configuration: configuration, serverTrustManager: ServerTrustManager(evaluators: [ "demo.test.com": DisabledTrustEvaluator()]))
    }
    
    
    func foo10() {
        let host = "test.alamofire.org"
        let serverTrust = TestTrusts.leafValidDNSName.trust
        let keys = [TestCertificates.leafValidDNSName].af.publicKeys
        // ok: ios.akabe1.alamofire-pinning
        let serverTrustPolicy = PublicKeysTrustEvaluator(keys: keys, performDefaultValidation: true, validateHost: true, acceptSelfSignedCertificates: false)
        setRootCertificateAsLoneAnchorCertificateForTrust(serverTrust)
        let result = Result { try serverTrustPolicy.evaluate(serverTrust, forHost: host) }
        XCTAssertTrue(result.isSuccess, "server trust should pass evaluation")
    }


}
