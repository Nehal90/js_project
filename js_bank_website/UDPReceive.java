/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: September, 2012													  *
*******************************************************************************/

import java.io.*;
import java.net.*;

public class UDPReceive {
  public static void main(String args[]) {
    try {
      if (args.length != 1)
        throw new IllegalArgumentException("Wrong number of arguments");

      int port = Integer.parseInt(args[0]);

      DatagramSocket dsocket = new DatagramSocket(port);

      byte[] buffer = new byte[2048];
      for(;;) {
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        dsocket.receive(packet);

        String msg = new String(buffer, 0, packet.getLength());
        System.out.println("I Receive a Datagram. It Is from " +
                           packet.getAddress().getHostName() + ":\n" + msg);
      }
    }
    catch (Exception e) {
      System.err.println(e);
      System.err.println("Usage: java UDPReceive <port>");
    }
  }
}