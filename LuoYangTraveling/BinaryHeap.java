package LuoYangTraveling;

public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {
	
	private static final int DEFAULT_CAPACITY=10;
	
	private int currentSize;
	private AnyType[] array;
	
	public BinaryHeap(){
	  this(DEFAULT_CAPACITY);
	}
	@SuppressWarnings("unchecked")
	public BinaryHeap(int capacity){
		currentSize=0;
		array=(AnyType[])new Comparable[capacity];
		
	}
	public void printHeap(){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+"; ");
		}
		System.out.println("");
	}
	
	
	public void insert(AnyType x){
		
		int hole=++currentSize;
		for(array[0]=x;x.compareTo(array[hole/2])<0;hole/=2)
			array[hole]=array[hole/2];
		array[hole]=x;
		
	}
	public static void main(String[] args){
		BinaryHeap<Integer> heap=new BinaryHeap<Integer>();
		heap.insert(1);
		heap.printHeap();
		heap.insert(2);
		heap.printHeap();
		heap.insert(3);
		heap.printHeap();
		heap.insert(4);
		heap.printHeap();
		heap.insert(-5);
		heap.printHeap();
		
		
	}
	

}
