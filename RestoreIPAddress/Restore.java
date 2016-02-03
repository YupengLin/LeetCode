package RestoreIPAddress;

import java.util.ArrayList;
import java.util.List;

public class Restore {
	public static List<String> restoreIpAddresses(String s) {
		List<String> validAddress = new ArrayList<String>();
		dfs(validAddress, new StringBuilder(), 0, s, 0);
		return validAddress;
	}
	
	public static void dfs(List<String> validAddress, StringBuilder ip, int curr, String s, int countSub) {
		if(curr >= s.length()) {
			if(countSub == 4) {
				validAddress.add(new StringBuilder(ip).substring(0, ip.length() - 1));
			}
			return;
		}
		if(countSub > 4) {
			return;
		}
		
		for(int i = curr + 1; i <= s.length(); i++) {
			String partIP = s.substring(curr, i);
			if(partIP.length() >= 2 && partIP.charAt(0) == '0') {
				break;
			}
			long segment = Long.parseLong(partIP);
			if(segment > Integer.MAX_VALUE) return;
			
			if(segment >= 0 && segment <= 255) {
				partIP = partIP + ".";
				ip.append(partIP);
				dfs(validAddress, ip, i, s, countSub + 1);
				ip.setLength(ip.length() - partIP.length());
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("010010"));
	}
}
