import java.util.*;
public class solution{
	
	static class TrieNode {
		 char data;
		 HashMap<Character, TrieNode> children = new HashMap<>();     
		 boolean isEnd = false;

		 TrieNode(char c) {
			 this.data = c;
		 }
	}
 
	static class Trie {
		
		TrieNode root = new TrieNode(' ');

		void insert(String word) {
			 TrieNode node = root;
			 for (char ch : word.toCharArray()) {
			     if (!node.children.containsKey(ch)) 
			         node.children.put(ch, new TrieNode(ch));			     
			     node = node.children.get(ch);			      		    			    	 			     
			 }
			 node.isEnd = true;	
		}
		 
		List<String> autocomplete(String prefix) {
			 List<String> res = new LinkedList<String>();	     
			 TrieNode node = root;
			 for (char ch : prefix.toCharArray()) {
				 if (node.children.containsKey(ch)) 
			         node = node.children.get(ch);
			     else 
			    	 return res;			     
			 }
			 helper(node, res, prefix.substring(0, prefix.length()-1));
			 return res;
		}
		
		void helper(TrieNode node, List<String> res, String prefix) {
			 if (node.isEnd) 
				 res.add(prefix + node.data);
			 for (Character ch : node.children.keySet()) 
			     helper(node.children.get(ch), res, prefix + node.data);
		}
	}
