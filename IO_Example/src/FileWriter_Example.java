import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;


public class FileWriter_Example {
	public static void main(String args[])
	{
		read();
	}
	static void read()
	{
		char[] s=new char[1000];
		FileReader reader;
		try 
		{
			reader = new FileReader("a.txt");
			reader.read(s);
			System.out.println(s);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void write()
	{
		String a="»¶Ó­";
		FileWriter writer;
		try 
		{
			writer =new FileWriter("a.txt",true);
			writer.write(a);
			writer.write("ergdfgdfs");
			writer.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
