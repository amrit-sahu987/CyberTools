// Take hash code as input and attempt to match it by hashing words from a word list and comparing
package hash_cracker

import scala.io.Source
import java.security.MessageDigest
import java.nio.charset.StandardCharsets

class Cracker:
    def crack_hash(hash: String, filename: String): String =
        // Determine the hash type based on its length and attempt to match it
        val len = hash.length()
        val password = len match {
            // If the hash is 32 characters long, use MD5 hashing algorithm
            case 32 => match_hash("MD5", hash, filename)
            // If the hash is 40 characters long, use SHA-1 hashing algorithm
            case 40 => match_hash("SHA-1", hash, filename)
            // If the hash is 64 characters long, use SHA-256 hashing algorithm
            case 64 => match_hash("SHA-256", hash, filename)
            // If the hash type is not supported (not 32, 40, or 64 characters), return an error message
            case _ => "Hash type not supported"
        }
        // Return the cracked password or an error message
        password

    private def match_hash(hash_type: String, hash: String, filename: String): String =
        // Create an instance of the specified hashing algorithm
        var hash_function = MessageDigest.getInstance(hash_type)
        // Initialize the password variable with a default value
        var password = "---- Password not found ----"

        // Loop through each line in the word list file
        for (line <- Source.fromFile(filename).getLines()) {
            // Calculate the hash of the current word from the word list
            val digest = hash_function.digest(line.getBytes())
            // Convert the hash to its hexadecimal representation
            val sb = new java.lang.StringBuilder()
            for (i <- 0 to digest.length - 1) {
                val hex = Integer.toHexString(0xff & digest(i))
                // Add leading zeros if the hexadecimal representation is a single character
                if (hex.length == 1) {
                    sb.append('0')
                }
                // Append the hexadecimal representation to the string builder
                sb.append(hex)
            }
            // If the computed hash matches the input hash, update the password variable
            if (hash == sb.toString()) {
                password = line
            }
        }
        // Return the password if found, or the default "not found" message
        password