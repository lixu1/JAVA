
public class anArray {
	public static void main(String args[]){
		int []a=new int[100];
		for(int i=0;i<100;i++)
			a[i]=i;
		int sum=0;
		for(int i=0;i<100;i++)
			sum+=a[i];
		int average=sum/100;
		System.out.println("数组的平均值为："+average);
	}
}
