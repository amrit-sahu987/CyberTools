// Take hash code as input and attempt to match it by hashing words from a word list and comparing
package hash_cracker

import scala.io.Source
import java.security.MessageDigest
import java.nio.charset.StandardCharsets

class Cracker:
    def crack_hash(hash: String, filename: String): String =
        val len = hash.length()
        val password = len match {
            case 32 => match_hash("MD5", hash, filename)
            case 40 => match_hash("SHA-1", hash, filename)
            case 64 => match_hash("SHA-256", hash, filename)
            case _ => "Hash type not supported"
        }
        password

    private def match_hash(hash_type: String, hash: String, filename: String): String =
        var hash_function = MessageDigest.getInstance(hash_type)
        var password = "---- Password not found ----"

        for (line <- Source.fromFile(filename).getLines()) {
            val digest = hash_function.digest(line.getBytes())
            val sb = new java.lang.StringBuilder()
            for (i <- 0 to digest.length - 1) {
                val hex = Integer.toHexString(0xff & digest(i))
                if (hex.length == 1) {
                    sb.append('0')
                }
                sb.append(hex)
            }
            if (hash == sb.toString()) {
                password = line
            }
        }
        password