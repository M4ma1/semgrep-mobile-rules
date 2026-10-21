import example


// Check pinning for AFSecurityPolicy 
class class_AFNetworking: SecPolicyTestCase {

        func fooAFNetworking1() {
            var uploadSessionManager = self.uploadSessionManager
            // ruleid: ios.akabe1.afnetworking-pinning
            let securityPolicy = AFSecurityPolicy(pinningMode: AFSSLPinningMode.none)
                securityPolicy.validatesDomainName = true
                securityPolicy.validatesCertificateChain = true
                securityPolicy.allowInvalidCertificates = false
            uploadSessionManager.securityPolicy = securityPolicy
        }



        func fooAFNetworking2() {
           let certificatePath = NSBundle.mainBundle().pathForResource("pinned-certificate", ofType: "cer")! 
           let certificateData = NSData(contentsOfFile: certificatePath)! 
           // ruleid: ios.akabe1.afnetworking-pinning
           let securityPolicy = AFSecurityPolicy(pinningMode: AFSSLPinningMode.Certificate) 
           securityPolicy.pinnedCertificates = [certificateData]; 
           securityPolicy.validatesCertificateChain = false 
           self.securityPolicy = securityPolicy 
        }



        func fooAFNetworking3() {
           let certificatePath = NSBundle.mainBundle().pathForResource("pinned-certificate", ofType: "cer")! 
           let certificateData = NSData(contentsOfFile: certificatePath)! 
           // ruleid: ios.akabe1.afnetworking-pinning
           let securityPolicy = AFSecurityPolicy(pinningMode: AFSSLPinningMode.PublicKey) 
           securityPolicy.pinnedCertificates = [certificateData]; 
           securityPolicy.allowInvalidCertificates = true 
           self.securityPolicy = securityPolicy 
        }
        
        
        
        func fooAFNetworking4() {
           let certificatePath = NSBundle.mainBundle().pathForResource("pinned-certificate", ofType: "cer")! 
           let certificateData = NSData(contentsOfFile: certificatePath)! 
           // ok: ios.akabe1.afnetworking-pinning
           let securityPolicy = AFSecurityPolicy(pinningMode: AFSSLPinningMode.Certificate) 
           securityPolicy.pinnedCertificates = [certificateData]; 
           securityPolicy.validatesDomainName = true
           securityPolicy.validatesCertificateChain = true
           securityPolicy.allowInvalidCertificates = false
           self.securityPolicy = securityPolicy 
        }


        func fooAFNetworking5() {
           let manager = AFHTTPSessionManager()
           // ruleid: ios.akabe1.afnetworking-pinning
           let securityPolicy = AFSecurityPolicy.default()
           securityPolicy.allowInvalidCertificates = false
           securityPolicy.validatesDomainName = true
           manager.securityPolicy = securityPolicy
        }


}
