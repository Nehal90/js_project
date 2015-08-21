/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: September, 2012													  *
*******************************************************************************/

import java.io.*;
import java.net.*;

public class UDPSend {
  public static void main(String args[]) {
    try {
      if (args.length < 3)
        throw new IllegalArgumentException("Wrong number of arguments");

      String host = args[0];
      int port = Integer.parseInt(args[1]);

      byte[] message;
      if (args[2].equals("-f")) {
        File f = new File(args[3]);
        int len = (int)f.length();    // figure out how big the file is
        message = new byte[len];      // create a buffer big enough
        FileInputStream in = new FileInputStream(f);
        int bytes_read = 0, n;
        do {                          // loop until we've read it all
          n = in.read(message, bytes_read, len-bytes_read);
          bytes_read += n;
        } while((bytes_read < len) && (n != -1));
      }
      else { // Otherwise, just combine all the remaining arguments.
        String msg = args[2];
        for (int i = 3; i < args.length; i++) msg += " " + args[i];
        message = msg.getBytes();
      }

      InetAddress address = InetAddress.getByName(host);
      DatagramPacket packet = new DatagramPacket(message,
                                                    message.length,  address, port);
      DatagramSocket dsocket = new DatagramSocket();
      dsocket.send(packet);
      dsocket.close();
    }
    catch (Exception e) {
      System.err.println(e);
      System.err.println("Usage: java UDPSend <hostname> <port> <msg>...\n"
                     + "   or: java UDPSend <hostname> <port> -f <file>");
    }
  }
}
