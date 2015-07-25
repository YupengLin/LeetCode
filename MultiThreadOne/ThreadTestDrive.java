package MultiThreadOne;

public class ThreadTestDrive {
	
	public static void main(String[] args){
		Runnable threadJob=new MyRunable();
		Thread myThread=new Thread(threadJob);
		myThread.start();
		System.out.println("back in main");
	}

}
