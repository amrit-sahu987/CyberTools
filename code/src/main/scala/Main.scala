import hash_cracker.Cracker

@main def hello: Unit =
  println("Hello world!")
  println(msg)
  val cracker = Cracker()
  println("Password is: " + cracker.crack_hash("5f4dcc3b5aa765d61d8327deb882cf99", "wordlist.txt"))

def msg = "I was compiled by Scala 3. :)"
