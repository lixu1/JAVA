import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class www {
	public  static void main(String args[]){
	 try{
	        File f = new File("file.txt") ;
	        OutputStream out = new FileOutputStream (f);
	     }
	catch(IOException e )
	    {}

	}
}
