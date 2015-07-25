package MultiThreadOne;

public class RunThreads implements Runnable {

	public static void main(String[] args){
		RunThreads runner =new RunThreads();
		Thread alpha=new Thread(runner);
		Thread beta=new Thread(runner);
		alpha.setName("Alpha");
		beta.setName("beta");
		alpha.start();
		beta.start();
		
	}
	
	public void run(){
		for(int i=0;i<10;i++){
			String threadName=Thread.currentThread().getName();
			System.out.println(threadName+" isRuning");
		}
	}
}
