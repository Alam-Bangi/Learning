/*
Program to check if it is a valid Ipv4 address or not
 */
package random;

import java.net.Inet4Address;
import java.net.InetAddress;

public class IpAddress {
    public static void main(String[] args) {
        String ipAddress1 = "10.0.255";
        String ipAddress2 = "192.168.1.1";
        String ipAddress3 = "12.304.5.6";
        String ipAddress4 = "12.204.5.6.90";
        String ipAddress5 = "I.Am.not.ip";
        String ipAddress6 = "999.255.255.255";

        InetAddress inetAddress = new IpAddress();
        isValidIpAddress(ipAddress1);
        isValidIpAddress(ipAddress2);
        isValidIpAddress(ipAddress3);
        isValidIpAddress(ipAddress4);
        isValidIpAddress(ipAddress5);
        isValidIpAddress(ipAddress6);
    }
    static void isValidIpAddress(String ipAddress) {
        String regex = "\\.";
        String[] parts = ipAddress.trim().split(regex);

        if(parts.length != 4) {
            System.out.println("Invalid IP-Address : " + ipAddress);
            return;
        }

        boolean isValidAddress = true;
        for (String part : parts) {
            if(part.length() > 3) {
                isValidAddress = false;
                break;
            }
            if(!part.matches("\\d+")) {
                isValidAddress = false;
                break;
            }
            if (part.length() > 1 && part.startsWith("0")) {
                isValidAddress = false;
                break;
            }
            int no = Integer.parseInt(part);
            if (no < 0 || no > 255) {
                isValidAddress = false;
                break;
            }
        }
        if (!isValidAddress) {
            System.out.println("Invalid IP-Address : " + ipAddress);
        } else {
            System.out.println("Valid IP-Address : " + ipAddress);
        }
    }
}
