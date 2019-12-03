package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIO {

	
	public void writeInFileFromConsole(String filename)
	{
		// write the content in file 
		
			
			FileWriter fileWriter;
			try {
				fileWriter = new FileWriter(filename);
				System.out.println("Enter file content.....");
				Scanner sc = new Scanner(System.in);
				while(sc.hasNextLine())
				{
					fileWriter.write(sc.nextLine());
				}
				sc.close();
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	public void copyFile(String filename)
	{
		FileWriter fw;
		File f;
		try {
			
			f = new File(filename);
			Scanner sc  = new Scanner(f);
			
			fw = new FileWriter(f);
			
			while(sc.hasNextLine())
			{
				fw.write(sc.nextLine());
			}
		}catch (FileNotFoundException e) {
			System.out.println("File not Found");
			e.printStackTrace();
		}		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readFileLineByLine(String filename)
	{
		File file = new File(filename);
		
		Scanner sc;
		try {
			sc = new Scanner(file); // default delimiter is whitespace
			
			while(sc.hasNextLine())
				System.out.println(sc.nextLine());
			
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readEntireFile(String filename)
	{
		File file = new File(filename);
		
		try {
			Scanner sc = new Scanner(file);
			
			sc.useDelimiter("\\Z");  //delimiter 
			
			System.out.println(sc.next());
			
			sc.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		

	}

}
