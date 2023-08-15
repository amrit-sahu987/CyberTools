import hash_cracker.Cracker
import packet_analyzer.Analyzer
import password_strength_tester.PasswordStrengthTester
import hash_function.HashFunction

@main def hello: Unit =
  println("Hello world!")
  println(msg)
  // val cracker = Cracker()
  // println("Password is: " + cracker.crack_hash("5f4dcc3b5aa765d61d8327deb882cf99", "wordlist.txt"))
  // Analyzer require super user permissions to run
  // val analyzer = Analyzer()
  // analyzer.capture()


def msg = "I was compiled by Scala 3. :)"
