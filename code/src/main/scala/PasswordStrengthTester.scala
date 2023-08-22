package password_strength_tester

// Define a class named PasswordStrengthTester
class PasswordStrengthTester:

  // Define a method named test that takes a password string as input and returns a strength evaluation
  def test(password: String): String = {
    var result = "" // Initialize a variable to store the strength evaluation
    var numcount = 0 // Initialize a counter for the number of digits in the password
    var symbolcount = 0 // Initialize a counter for the number of symbols in the password
    val len = password.length() // Get the length of the password
    val range = 0 to (len - 1) // Create a range from 0 to (length - 1) to iterate over the password characters

    // Check if the length of the password is less than or equal to 8
    if (len <= 8)
      return "Weak. Increase the length of your password."

    // Iterate through each character in the password
    for (i <- range)
    // Check if the character is a digit (ASCII values between 48 and 57)
      if (password(i) > 47 && password(i) < 58)
        numcount += 1 // Increment the digit count
      // Check if the character is a symbol (ASCII values outside the ranges of letters and digits)
      else if ((password(i) > 32 && password(i) < 48) || (password(i) > 57 && password(i) < 65) || (password(i) > 90 && password(i) < 97) || password(i) > 122)
        symbolcount += 1 // Increment the symbol count

    // Evaluate the strength of the password based on digit and symbol counts
    if (numcount == 0 && symbolcount == 0)
      return "Weak. Add numbers and symbols."
    else if (numcount == 0)
      return "Medium. Add numbers."
    else if (symbolcount == 0)
      return "Medium. Add symbols."
    else
      return "Strong."

    result // This line is never reached as it's after the return statements
  }
