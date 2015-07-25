package LRUcache;

import java.util.HashMap;

public class LRUCache {
	private class Node{
		public Node prev;
		public Node next;
		public int Key;
		public int value;
		
		public Node(int key,int value){
			this.Key=key;
			this.value=value;
		}
		public void setPrev(Node prev){
			this.prev=prev;
		}
		public void setNext(Node next){
			this.next=next;
		}
		public void setValue(int value){
			this.value=value;
		}
		
	}
	
	int capacity;
	HashMap<Integer,Node> nodes;
	int currentSize;
	Node head;
	Node tail;
	
	public LRUCache(int capacity){
		this.capacity=capacity;
		currentSize=0;
		nodes=new HashMap<Integer,Node>();
	}
	
	public int get(int key){
		Node item=nodes.get(key);
		if(item!=null){
			moveToHead(item);
			return item.value;	
		}else{
			return -1;
		}
		
	}
	/**
	 * 
	 * @param key
	 * @param value
	 * if nodes exist
	 * update value
	 * 
	 * if node does not exist
	 *    if cache is full
	 *     delete last one
	 *     insert head 
	 *     size increase
	 *     
	 *     if cache is not full
	 *     insert head 
	 *     size increase 
	 * 
	 */
	public void set(int key, int value){
		Node getItem=nodes.get(key);
		if(getItem==null){
			if(currentSize>=capacity){
				deleteTail();
			}
			Node newItem=new Node(key,value);
			
		    if(currentSize==0){
		    	head=newItem;
		    	tail=newItem;
		    	
		    	
		    }else{
			
		    Node oldHead=head;
		    oldHead.prev=newItem;
		    newItem.next=oldHead;
		    head=newItem;
		    
		    
		    }
		    
		    currentSize++;
		    nodes.put(key, newItem);
		}else{
			getItem.setValue(value);
			nodes.put(key,getItem);
			moveToHead(getItem);
		}
		
	}
	
	
	
	
	
	private void moveToHead(Node item){
		if(item==head){
			return;
		}else if(item==tail){
			Node secondLast=item.prev;
			secondLast.next=null;
		    head.prev=item;
		    item.next=head;
		    head=item;
		    tail=secondLast;
			
		}else{
			item.prev.next=item.next;
			item.next.prev=item.prev;
			item.prev=null;
			item.next=head;
			head.prev=item;
			head=item;
			
		}
		
	}
		
		
		
	
	private void deleteTail(){
		if(currentSize==0){
			return;
		}else if(currentSize==1){
			nodes.remove(tail.Key);
			head=null;
			tail=null;
			currentSize--;
			return;
		}else{
			nodes.remove(tail.Key);
		    Node secondLast=tail.prev;
			secondLast.next=null;
			tail=secondLast;
			currentSize--;
			return;
	}
		
	}
	public void printCache(){
		Node curNode=head;
		System.out.print("cache= ");
		while(curNode!=null){
			System.out.print(curNode.value+"; ");
			curNode=curNode.next;
		}
		System.out.print("\n");
		
	}
	
public static void  main(String[] args){
	/*
		LRUCache cache1=new LRUCache(4);
		cache1.set(1,1);
		cache1.printCache();
		cache1.set(2,2);
		cache1.printCache();
		cache1.set(3, 3);
		cache1.printCache();
		cache1.set(4, 4);
		cache1.printCache();
		cache1.set(5, 5);
		cache1.printCache();
		cache1.set(6, 6);
		cache1.printCache();
		cache1.set(7, 7);
		cache1.printCache();
		*/
		LRUCache cache2=new LRUCache(4);
		cache2.set(1, 1);
		cache2.set(2,2);
		cache2.printCache();
		System.out.println("get 1="+cache2.get(1));
		cache2.printCache();
		cache2.set(3, 3);
		System.out.println(-1==cache2.get(10));
		cache2.set(3,33);
		cache2.printCache();

		cache2.set(2,22);
		cache2.printCache();

		cache2.set(1,11);
		cache2.printCache();
		
		cache2.set(4,4);
		cache2.printCache();
		cache2.set(5,5);
		cache2.printCache();
		System.out.println(-1==cache2.get(3));
		System.out.println(4==cache2.get(4));
		cache2.printCache();

		
		
		
		
		
		
	}
}
