package com.lee.learn.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		
		telnetTest();
		System.exit(0);
		
		InetAddress address = InetAddress.getByName("www.tadu.com");
		System.out.println("ip: " + address.getHostAddress());
		System.out.println("host: " + address.getHostName());
		System.out.println("canonical host name: "
				+ address.getCanonicalHostName());
		byte[] bytes = address.getAddress();
		for (byte b : bytes) {
			if (b >= 0)
				System.out.print(b);
			else
				System.out.print(256 + b);
			System.out.print(" ");
		}
	}

	public static void telnetTest() {
		Socket server = null;
		try {
			server = new Socket();
			InetSocketAddress address = new InetSocketAddress("119.75.218.77", 80);
			server.connect(address, 5000);
			System.out.println("ok!");
		} catch (UnknownHostException e) {
			System.out.println("wrong!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("wrong");
			e.printStackTrace();
		}

	}
}
