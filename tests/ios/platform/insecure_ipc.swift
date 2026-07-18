import Foundation

@objc public protocol MyServiceProtocol {
    func upperCaseString(_ string: String, withReply reply: @escaping (String) -> Void)
}

// ruleid: ios.insecure_ipc
let connection = NSXPCConnection(serviceName: "myService")
// ruleid: ios.insecure_ipc
let interface = NSXPCInterface(with: MyServiceProtocol.self)
// ruleid: ios.insecure_ipc
let listener = NSXPCListener.service()
// ruleid: ios.insecure_ipc
var fileCoordinator = NSFileCoordinator()