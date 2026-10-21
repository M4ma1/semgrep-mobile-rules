import example


// Check pinning for TrustKit
final class TrustKitService: NSObject, ApplicationService {
    static let kMyDomain = "test.example.com"

    func footrust1(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey: Any]? = nil) -> Bool {
        // ok: ios.akabe1.trustkit-pinning
        let trustKitConfig = [
            kTSKPinnedDomains: [
                TrustKitService.kMyDomain: [
                    kTSKEnforcePinning: true,
                    kTSKIncludeSubdomains: true,
                    kTSKPublicKeyAlgorithms: [kTSKAlgorithmRsa2048],
                    kTSKPublicKeyHashes: [
                        "public key 1",
                        "public key 2"
                    ]]
            ]] as [String: Any]

        TrustKit.initSharedInstance(withConfiguration: trustKitConfig)

        return true
    }


    func footrust2(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey: Any]? = nil) -> Bool {
        // ruleid: ios.akabe1.trustkit-pinning
        let trustKitConfig = [
            kTSKPinnedDomains: [
                TrustKitService.kMyDomain: [
                    kTSKEnforcePinning: false,
                    kTSKIncludeSubdomains: true,
                    kTSKPublicKeyAlgorithms: [kTSKAlgorithmRsa2048],
                    kTSKPublicKeyHashes: [
                        "public key 1",
                        "public key 2"
                    ]]
            ]] as [String: Any]

        TrustKit.initSharedInstance(withConfiguration: trustKitConfig)

        return true
    }
    
    
        func footrust3(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey: Any]? = nil) -> Bool {
	   // vuln Trustkit pinning
           // ruleid: ios.akabe1.trustkit-pinning
           let trustKitConfig: [String: Any] = [
               kTSKSwizzleNetworkDelegates: false,
               kTSKPinnedDomains: [
                       "test.example.com": [
                           kTSKEnforcePinning: true,
                           kTSKIncludeSubdomains: false,
                           kTSKPublicKeyHashes: [
                              "ZCv/DWs7Y/6OPAoRMqopsFj77y+a/mCD4DRZuhTtXwg=",
                              "AAAAAAAAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBCCC="
                          ],
                          kTSKReportUris: ["https://website.net/trustkit/report"],
                       ]
               ]]
              
               TrustKit.initSharedInstance(withConfiguration: trustKitConfig)

               return true
        }

}
