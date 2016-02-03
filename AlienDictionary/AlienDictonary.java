package AlienDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlienDictonary {
	public String alienOrder(String[] words) {
		List<List<Character>> chars = new ArrayList<>();
		HashMap<Character, edge> graph = new HashMap<>();
		for(String s : words) {
			for(int i = 1; i < s.length(); i++) {
				char curr = s.charAt(i);
				char prev = s.charAt(i - 1);
				if(curr == prev) {
					continue;
				}
				if(graph.containsKey(curr)) {
					graph.get(curr).incoming.add(prev);
				} else {
					edge inc = new edge();
					inc.incoming = new HashSet<>();
					inc.outcoming = new HashSet<>();
					inc.incoming.add(prev);
					graph.put(curr, inc);
				}
				if(graph.containsKey(prev)) {
					edge e = graph.get(prev);
					e.outcoming.add(curr);
				} else {
					edge outc = new edge();
					outc.outcoming = new HashSet<>();
					outc.incoming = new HashSet<>();
					outc.outcoming.add(curr);
					graph.put(prev, outc);
				}
			}
		}
		
		Set<Character> nodes = graph.keySet();
		ArrayList<Character> order = new ArrayList<>();
		ArrayList<Character> noincoming = new ArrayList<>();
		
		for(Character node : nodes) {
			if(graph.get(node).incoming.size() == 0) {
				noincoming.add(node);
			}
		}
		
		while(noincoming.size() != 0) {
			char curr = noincoming.get(0);
			noincoming.remove(0);
			order.add(curr);
			
			Set<Character> neighbors = graph.get(curr).outcoming;
			for(char neighbor : neighbors) {
				graph.get(neighbor).incoming.remove(new Character(curr));
				if(graph.get(neighbor).incoming.size() == 0) {
					noincoming.add(neighbor);
				}
			}
		}
		
		if(order.size() != nodes.size()) {
			return "";
		} else {
			StringBuilder finalOrder = new StringBuilder();
			for(char c : order) {
				finalOrder.append(c);
			}
			return finalOrder.toString();
		}
		
	
	}
	
	class edge {
		
		Set<Character> incoming;
		Set<Character> outcoming;
	}
	
	public static void main(String[] args) {
		AlienDictonary ad = new AlienDictonary();
		String[] dict = {"wrt",
				  "wrf",
				  "er",
				  "ett",
				  "rftt",
				};
		System.out.println(ad.alienOrder(dict));
	}
}
