package AddAndSearchWord;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Trie {
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		if(word == null || word.length() == 0) {
			return;
		}
		TrieNode prev = root;
		for(int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			int index = letter - 'a';
			TrieNode currNode = prev.nodes.get(index);
			if(currNode != null) {
				prev = currNode;
			} else {
				currNode = new TrieNode(letter);
				prev.nodes.set(index, currNode);
				prev = currNode;
			}
			if(i == word.length() - 1) {
				currNode.isEnd = true;
			}
		}
	}
	
	
	public boolean dfsSearch(String word) {
		return dfs(word, 0, word.length(), root);
	}
	
	public boolean dfs(String word, int curr, int L, TrieNode root) {
		if(root == null) return false;
		if(curr >= L) return root.isEnd;
		char letter = word.charAt(curr);
		if(letter == '.') {
			for(int i = 0; i < 26; i++) {
				TrieNode next = root.nodes.get(i);
				if(next == null) continue;
				if(dfs(word, curr + 1, L, next)) return true;
			}
		} else {
			TrieNode next = root.nodes.get(letter - 'a');
			if(dfs(word, curr + 1, L, next)) return true;
		}
		
		return false;
		
	}
	
	public boolean search(String word) {
		if(word == null || word.length() == 0) {
			return false;
		}
		//TrieNode prev = root;
		List<TrieNode> prev = new ArrayList<TrieNode>();
		prev.add(root);
		for(int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			int index = letter - 'a';
			List<TrieNode> curr = new ArrayList<TrieNode>();
			if(prev.isEmpty()) return false;
			if(letter == '.') {
				for(TrieNode node : prev) {
					for(TrieNode child : node.nodes) {
						if(child != null) curr.add(child);
					}
				}
				System.out.println("match node size = " + curr.size());
			} else {
				for(TrieNode node : prev) {
					TrieNode match = node.nodes.get(index);
					if(match != null) curr.add(match);
				}
				
			}
			if(curr.isEmpty()) return false;
			prev = curr;
		}
		return true;
	}
	
	public boolean startsWith(String prefix) {
		if(prefix == null || prefix.length() == 0) {
			return false;
		}
		//if(prefix )
		TrieNode prev = root;
		for(int i = 0; i < prefix.length(); i++) {
			char letter = prefix.charAt(i);
			int index = letter - 'a';
			TrieNode currNode = prev.nodes.get(index);
			if(currNode == null) {
				return false;
			}
			prev = currNode;
			
		}
		return true;
	}
	
public static void main(String[] args) {
		Trie prefixTree = new Trie();
		System.out.println(prefixTree.root.letter);
		//prefixTree.insert("abc");
		
		//System.out.println(prefixTree.dfsSearch("abc"));
		//System.out.println(prefixTree.search("ab"));
		prefixTree.insert("ab");
		//System.out.println(prefixTree.search("ab"));	
		prefixTree.insert("bad");
		prefixTree.insert("dad");
		prefixTree.insert("mad");
		System.out.println(prefixTree.dfsSearch("b.."));
		
	}
}


class TrieNode {
	char letter;
	boolean isEnd;
	List<TrieNode> nodes = new ArrayList<TrieNode>(26); 
	
	public TrieNode() {
		letter = '.';
		for(int i = 0; i < 26; i++) {
			nodes.add(null);
		}
	}
	
	public TrieNode(char c) {
		this.letter = c;
		for(int i = 0; i < 26; i++) {
			nodes.add(null);
		}
	}
	
}