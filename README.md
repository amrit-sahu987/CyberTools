# CyberTools
 We have created a packet analyser, hash cracker, hash generator and password strength tester in Scala. We also intended
to create a keylogger, but ran into difficulties with integrating the imported java libraries and did not finish 
debugging it in time. 

The packet analyser captures packets on the network and displays info about the captured packets to the terminal.

The hash cracker tests the given hash against a dictionary of known words to see if the hashes match.

The hash function uses standard java libraries to encrypt the given plaintext.

The password strength tester checks to see if the given password contains numbers or symbols, as well as checking the 
length in order to offer advice on how to strengthen it.

