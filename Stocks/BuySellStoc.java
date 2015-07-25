package Stocks;

public class BuySellStoc {
	public int maxProfit(int[] prices){
		if(prices==null || prices.length==0){
			return 0;
		}
		int len=prices.length;
		int minDay=0;
		int maxProfit=0;
		for(int i=1;i<len;i++){
			if(prices[i-1]<prices[minDay]){
				minDay=i-1;
			}
			if(prices[i]-prices[minDay]>maxProfit){
                maxProfit=prices[i]-prices[minDay];		
			}
		}
		return maxProfit;
	}
	
	public static void main(String[] args){
		int[] prices={1,1,2,7,10};
		BuySellStoc test=new BuySellStoc();
		System.out.println(test.maxProfit(prices));
	}

}
