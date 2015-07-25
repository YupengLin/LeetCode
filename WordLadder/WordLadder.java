package WordLadder;

import java.util.*;

public class WordLadder {
public int ladderLength(String start,String end, Set<String> dict){
	if(dict.size()==0){
		return 0;
	}
	
	LinkedList<String> wordQueue=new LinkedList<String>();
	LinkedList<Integer> distQueue=new LinkedList<Integer>();
	
	wordQueue.add(start);
	distQueue.add(1);
	
	while(!wordQueue.isEmpty()){
		String currWord=wordQueue.getFirst();
		
	}
	return 0;
}
}
