
public class operator {
	public static void main(String args[]){
		boolean a=true,b=!a;
		System.out.println("byte ���ͣ�a="+a+" b="+b);
		
		char c='A';
		System.out.println("char ���ͣ�c="+c);
		
		byte d=1,e=2;
		byte f=(byte)(d + e);
		System.out.println("byte ���ͣ�"+d+"+"+e+"="+f);
		
		short r=5,s=5,t=(short)(r+s);
		System.out.println("short ���ͣ�"+r+"+"+s+"="+t);
		
		int g=11,h=22,i=g+h;
		System.out.println("int ���ͣ�"+g+"+"+h+"="+i);
		
		long j=12345678912L;
		long k=j+j;
		System.out.println("long ���ͣ�"+j+"+"+j+"="+k);
		
		float l=0.1f,m=0.2f;
		float n=l+m;
		System.out.println("float ���ͣ�"+l+"+"+m+"="+n);
		
		double o=0.01,p=0.1,q=o+p;
		System.out.println("double ���ͣ�"+o+"+"+p+"="+q);
		
		
		
	}

}
