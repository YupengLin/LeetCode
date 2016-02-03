package EncodeDecodeString;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	 public String encode(List<String> strs) {
	        StringBuilder encodeString = new StringBuilder();
	        for(String str : strs) {
	            encodeString.append(str.length()).append("/").append(str);
	        }
	        return encodeString.toString();
	    }

	    // Decodes a single string to a list of strings.
	    public List<String> decode(String s) {
	        List<String> decodeList = new ArrayList<String>();
	        while(s.length() != 0 ) {
	            int delimPos = s.indexOf("/");
	            int stringLength = Integer.parseInt(s.substring(0, delimPos));
	            decodeList.add(s.substring(delimPos + 1, delimPos + 1 + stringLength));
	            s = s.substring(delimPos + 1 + stringLength);
	        }
	        return decodeList;
	    }
}
