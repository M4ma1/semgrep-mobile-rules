import Foundation
import os.log

// ruleid: ios.invalid_logger
print("my log")

// ruleid: ios.invalid_logger
NSLog("my log")

let log = OSLog(subsystem: "myapp", category: "dummy")
let signpostID = OSSignpostID(log: log)
// ruleid: ios.invalid_logger
os_signpost(.begin, log: log, name: "Processing", signpostID: signpostID)