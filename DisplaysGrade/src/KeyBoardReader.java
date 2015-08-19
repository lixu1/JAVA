import java.io.*;   

public class KeyBoardReader{   
       
    private BufferedReader br;   
       
    public KeyBoardReader(){   
        br = new BufferedReader(new InputStreamReader(System.in));   
    }   
       
    public BufferedReader getReader(){   
        return this.br;   
    }   
       
    public void setReader(BufferedReader br){   
        this.br = br;   
    }   
       
    public double readDouble(){   
        double value = 0.0;   
        try{   
            String s = br.readLine();   
            System.out.println("s: " + s);   
            value = Double.parseDouble(s);   
        }   
        catch(Exception e){   
            System.out.println("Exception: " + e.getMessage());   
        }   
        return value;   
    }   
       
    public static void main(String[] args){   
        KeyBoardReader input = new KeyBoardReader();   
        System.out.println("please input double: ");   
        double radio = input.readDouble();   
        System.out.println("radio: " + radio);   
    }   
       
}  