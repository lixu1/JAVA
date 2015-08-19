class base {
	int a=9;
}
class mine extends base{
	static char b='q';
}
public class ss{
	public static void main(String args[]){
		mine x=new mine();
		base mm=x;
		x=(mine) mm;
		System.out.println("sss"+mm.a);
	}
}
