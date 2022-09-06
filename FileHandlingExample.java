package divisha;
import java.io.*;
import java.util.Scanner;
public class FileHandlingExample {
   public static void main(String args[]) throws FileNotFoundException, IOException{
	   System.out.println("Please select one of the below operations");
	   System.out.println("w for write mode");
	   System.out.println("r for read mode");
	   System.out.println("a for append mode");
	   Scanner sc=new Scanner(System.in);
	   String s=sc.nextLine();
	   if(s.equalsIgnoreCase("r"))
	   {
		   new FReading();
	   }
	   else if(s.equalsIgnoreCase("w")||s.equalsIgnoreCase("a"))
	   {
		   writingToFile(s);
	   }
	   else
		   System.out.println("Sorry you try to do unexpected, better luck next time");
	   sc.close();
   }
   
   public static void writingToFile(String s)
   {
	   Scanner sc=null;
	   try
	   {
		   String source="";
		   File f= new File("file1.txt");
		   BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		   FileWriter f0=null;
		   if(s.equalsIgnoreCase("w"))
		   {
			   f0=new FileWriter(f,false);
			   System.out.println("Caution>> Please understand it will overwrite the content of the file");
			   System.out.println("Type 'no' to exit");
			   System.out.println("Do you want to proceed : type 'yes'");
			   sc=new Scanner(System.in);
			   String s1=sc.nextLine();
			   if(s1.equalsIgnoreCase("no"))
				   System.exit(0);
			   System.out.println("Write 'stop' when you finish writing file");
			   f.delete();
			   f.createNewFile();
			   while(!(source=bf.readLine()).equalsIgnoreCase("stop"))
			   {
				   f0.write(source+System.getProperty("line.separator"));
			   }
			   sc.close();
		   }
	    }
	   catch(Exception e)
	   {
		   System.out.println("Error : ");
		   e.printStackTrace();
		   
	   }
}
}
class FReading{
	public static String str="";
	public FReading() {
		try {
			File f5=new File("file1.txt");
			if(! f5.exists())
				f5.createNewFile();
			FileReader f1=new FileReader(f5);
			BufferedReader bf=new BufferedReader(f1);
			while((str=bf.readLine())!=null) {
				System.out.println(str);
			}
			f1.close();
			}
		  catch(Exception e)
		   {
			   System.out.println("Error : ");
			   e.printStackTrace();
			   
		   }
	}
}
