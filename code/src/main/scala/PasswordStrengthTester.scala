package password_strength_tester

class PasswordStrengthTester:

  def test(password: String): String = {
    var result = ""
    var numcount = 0
    var symbolcount = 0
    val len = password.length()
    val range = 0 to (len - 1)
    if (len <= 8)
      return "Weak. Increase the length of your password."

    for (i <- range)
      if (password(i) > 47 && password(i) < 58)
        numcount += 1
      else if ((password(i) > 32 && password(i) < 48) || (password(i) > 57 && password(i) < 65) || (password(i) > 90 && password(i) < 97) || password(i) > 122)
        symbolcount += 1


    if (numcount == 0 && symbolcount == 0)
      return "Weak. Add numbers and symbols."
    else if (numcount == 0)
      return "Medium. Add numbers."
    else if (symbolcount == 0)
      return "Medium. Add symbols."
    else
      return "Strong."

    result
  }
