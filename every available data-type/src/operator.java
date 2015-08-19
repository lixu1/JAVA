
public class operator {
	public static void main(String args[]){
		boolean a=true,b=!a;
		System.out.println("byte 类型：a="+a+" b="+b);
		
		char c='A';
		System.out.println("char 类型：c="+c);
		
		byte d=1,e=2;
		byte f=(byte)(d + e);
		System.out.println("byte 类型："+d+"+"+e+"="+f);
		
		short r=5,s=5,t=(short)(r+s);
		System.out.println("short 类型："+r+"+"+s+"="+t);
		
		int g=11,h=22,i=g+h;
		System.out.println("int 类型："+g+"+"+h+"="+i);
		
		long j=12345678912L;
		long k=j+j;
		System.out.println("long 类型："+j+"+"+j+"="+k);
		
		float l=0.1f,m=0.2f;
		float n=l+m;
		System.out.println("float 类型："+l+"+"+m+"="+n);
		
		double o=0.01,p=0.1,q=o+p;
		System.out.println("double 类型："+o+"+"+p+"="+q);
		
		
		
	}

}
