import Foundation

func example() -> Void {
    // ruleid: ios.semgrep.insecure-random
    let randomInt = Int.random(in: 0..<6)
    // ruleid: ios.semgrep.insecure-random
    let randomDouble = Double.random(in: 2.71828...3.14159)
    // ruleid: ios.semgrep.insecure-random
    let randomBool = Bool.random()

    // ruleid: ios.semgrep.insecure-random
    let diceRoll = Int(arc4random_uniform(6) + 1)


    // ruleid: ios.semgrep.insecure-random
    let a = Int.random(in: 0 ... 10)

    // ruleid: ios.semgrep.insecure-random
    var k: Int = random() % 10;

    // ruleid: ios.semgrep.insecure-random
    let randomNumber = arc4random()

    var r: Self = 0
    // ruleid: ios.semgrep.insecure-random
    arc4random_buf(&r, MemoryLayout<Self>.size)

    // ruleid: ios.semgrep.insecure-random
    let x = Int.random(in: 1...100)
    // ruleid: ios.semgrep.insecure-random
    var g = SystemRandomNumberGenerator()
    // ruleid: ios.semgrep.insecure-random
    let y = Int.random(in: 1...100, using: &g)

    // ruleid: ios.semgrep.insecure-random
    if (Int.random(in: 1...100) <  50) {
        println("foo")
    }

    var printRandom = {
        // ruleid: ios.semgrep.insecure-random
        let a = Int.random(in: 1...10)
        print(a)
    }
    
    // okid: ios.semgrep.insecure-random
    Test.random(in: 1...10)
}

