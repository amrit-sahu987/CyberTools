package hash_function

import scala.io.Source
import java.security.MessageDigest
import java.nio.charset.StandardCharsets

// Define a class named HashFunction
class HashFunction:

  // Define a method named generate that takes a plaintext string and a hash_type string as arguments
  def generate(plaintext: String, hash_type: String): String = {
    // Create an instance of MessageDigest using the specified hash_type
    var hasher = MessageDigest.getInstance(hash_type)

    // Calculate the hash (digest) of the plaintext by converting it to bytes and passing it to the MessageDigest
    val digested = hasher.digest(plaintext.getBytes())

    // Create a StringBuilder to construct the hexadecimal representation of the digest
    val sb = new java.lang.StringBuilder()

    // Iterate through each byte in the digest
    for (i <- 0 to digested.length - 1) {
      // Convert the byte to a hexadecimal string (0xff is a bit mask to ensure we get a positive value)
      val hex = Integer.toHexString(0xff & digested(i))

      // If the hexadecimal value is only one character, add a leading '0'
      if (hex.length == 1) {
        sb.append('0')
      }

      // Append the hexadecimal value to the StringBuilder
      sb.append(hex)
    }

    // Return the final hexadecimal representation of the hash
    return sb.toString()
  }
