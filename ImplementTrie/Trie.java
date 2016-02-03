package ImplementTrie;

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
	
	public boolean search(String word) {
		if(word == null || word.length() == 0) {
			return false;
		}
		TrieNode prev = root;
		for(int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			int index = letter - 'a';
			TrieNode currNode = prev.nodes.get(index);
			if(currNode == null) {
				return false;
			}
			prev = currNode;
			if(i == word.length() - 1) {
				return currNode.isEnd ? true : false;
			}
		}
		return false;
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
		prefixTree.insert("abc");
		System.out.println(prefixTree.search("abc"));
		System.out.println(prefixTree.search("ab"));
		prefixTree.insert("ab");
		System.out.println(prefixTree.search("ab"));	
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