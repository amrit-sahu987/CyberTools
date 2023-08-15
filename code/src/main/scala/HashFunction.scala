package hash_function

import scala.io.Source
import java.security.MessageDigest
import java.nio.charset.StandardCharsets


class HashFunction:
  def generate(plaintext: String, hash_type: String): String = {
    var hasher = MessageDigest.getInstance(hash_type)
    val digested = hasher.digest(plaintext.getBytes())
    val sb = new java.lang.StringBuilder()
    for (i <- 0 to digested.length - 1) {
      val hex = Integer.toHexString(0xff & digested(i))
      if (hex.length == 1) {
        sb.append('0')
      }
      sb.append(hex)
    }
    return sb.toString()
  }








