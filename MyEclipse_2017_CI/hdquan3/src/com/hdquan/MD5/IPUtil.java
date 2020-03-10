package com.hdquan.MD5;

public class IPUtil {
 public static boolean ipExistsInRange(String ip,String ipSection) {

		        ipSection = ipSection.trim();

		        ip = ip.trim();

		       int idx = ipSection.indexOf('-');

		        String beginIP = ipSection.substring(0, idx);

		        String endIP = ipSection.substring(idx + 1);

		       return getIp2long(beginIP)<=getIp2long(ip) &&getIp2long(ip)<=getIp2long(endIP);

		    }
		 
 public static long getIp2long(String ip) {

		        ip = ip.trim();

		        String[] ips = ip.split("\\.");

		       long ip2long = 0L;

		       for (int i = 0; i < 4; ++i) {

		            ip2long = ip2long << 8 | Integer.parseInt(ips[i]);

		        }

		       return ip2long;

		    }

 public static long getIp2long2(String ip) {

		        ip = ip.trim();

		        String[] ips = ip.split("\\.");

		       long ip1 = Integer.parseInt(ips[0]);

		       long ip2 = Integer.parseInt(ips[1]);

		       long ip3 = Integer.parseInt(ips[2]);

		       long ip4 = Integer.parseInt(ips[3]);



		       long ip2long =1L* ip1 * 256 * 256 * 256 + ip2 * 256 * 256 + ip3 * 256 + ip4;

		       return ip2long;

		    }

}
