
package LuoYangTraveling;

//import LuoYangTraveling.BinarySearchTree.BinaryNode;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>{

	
	private static class BinaryNode<AnyType>{
		BinaryNode(AnyType theElement){
			this(theElement,null,null);
		}
		BinaryNode(AnyType theElement, BinaryNode<AnyType> lt,BinaryNode<AnyType> rt){
			element=theElement;
			left=lt;
		}
		AnyType element;
		BinaryNode<AnyType> left;
		BinaryNode<AnyType> right;
	}
	
	private BinaryNode<AnyType> root;
	
	public BinarySearchTree(){
		root=null;
	}
	public void makeEmpty(){
		root=null;
	}
	public boolean isEmpty(){
		return root==null;
	}
	public boolean contains(AnyType x){
		return contains(x,root);
	}
	public boolean contains(AnyType x, BinaryNode<AnyType> t){
		if(t==null)
			return false;
        	
	    int compareResult=x.compareTo(t.element);
	    if(compareResult<0){
	    	return contains(x,t.left);
	    }else if(compareResult>0){
	    	return contains(x,t.right);
	    }else{
	    	return true;
	    }
	    
	   
	}
	
	public AnyType findMin() throws UnderflowException{
		if(isEmpty()){ 
			throw new UnderflowException();
		}else{
			return findMin(root).element;
		}
		
	}
	public BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
		if(t==null){
			return null;
		}else if(t.left == null)
			return t;
		return findMin(t.left);
		
		
	}
	public AnyType findMax() throws UnderflowException{
		if(isEmpty()){ 
			throw new UnderflowException();
		}else{
			return findMax(root).element;
		}
	
	}
	
	public BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
		if(t!=null){
			while(t.right!=null){
				t=t.right;
			}
		}
		return t;
	}
	public void insert(AnyType x){
		root=insert(x,root);
	}
	public BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t){
		if(t==null){
			return new BinaryNode<AnyType>(x,null,null);
		}
		int compareResult=x.compareTo(t.element);
		if(compareResult<0){
			t.left=insert(x,t.left);
		}else if(compareResult>0){
			t.right=insert(x,t.right);
		}else{
			
		}
		
		return t;
	}
	
	public void printTree(){
		if(isEmpty()){
			System.out.println("empty tree");
		}else{
			printTree(root);
		}
	}
	private void printTree(BinaryNode<AnyType> t){
		if(t!=null){
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}
	public void remove(AnyType x){
		root=remove(x,root);
	}
	private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t){
		if(t==null){
			return t;
		}
		int compareResult=x.compareTo(t.element);
		if(compareResult<0){
			t.left=remove(x,t.left);
		}else if(compareResult>0){
			t.right=remove(x,t.right);
		}else if(t.left!=null && t.right!=null){
			t.element=findMin(t.right).element;
			t.right=remove(t.element,t.right);
		}else{
			t=(t.left!=null)?t.left:t.right;
		}
		return t;
		
	}
	
	public static void main(String[] args) throws UnderflowException{
		
		BinarySearchTree<Integer> tree1=new BinarySearchTree<Integer>();
		tree1.insert(0);
		tree1.insert(1);
		tree1.insert(2);
		tree1.printTree();
		System.out.println("max= "+tree1.findMax());
		System.out.println("min= "+tree1.findMin());
		
		System.out.println(tree1.contains(0));
		System.out.println(tree1.contains(10)==false);
		
		tree1.remove(0);
		System.out.println(tree1.contains(0)==false);
		
		
		
		
	}
	
	
	
	
	
}
