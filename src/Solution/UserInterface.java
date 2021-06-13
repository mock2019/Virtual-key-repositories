package Solution;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class UserInterface {
	
	String directoryName = "./VirtualKey/";
	
	public void mainMenu() throws IOException {
		System.out.println("Main menu of the Application\n");
		System.out.println("1.Show list of Files ");
		System.out.println("2.File operation ");
		System.out.println("3.Close the application \n");
		
		System.out.println("Please enter your option");
		
		File directory = new File(directoryName);
		if(!directory.exists()){

            directory.mkdir();
		}
		Scanner mainOption = new Scanner(System.in);
		String name=mainOption.next();
		int result = Integer.parseInt(name);
		switch(result) {
		case 1:listofFiles();break;  
		case 2:filesOperationsMenu();break;
		case 3:System.exit(0);break;
		default:System.out.println("Please enter the valid option"); mainMenu(); break;
		}
	}
	public void listofFiles() throws IOException{
		
		System.out.println("Below are the list available file names\n");
		
		
		File file = new File(directoryName);
		System.out.println(file);
		String fileList[] = file.list();  
		if(fileList.length> 0) {
			Arrays.sort(fileList);
			
			for(int i=0; i<fileList.length; i++) {
		         System.out.println(i+1 +"."+fileList[i]);
		      }
		}else {
			System.out.println("No files available \n");
		}
			
		
         mainMenu();
		
	}
	public void addFile () throws IOException {
		
		System.out.println("Please enter the file name\n");
		
		Scanner name = new Scanner(System.in);
		String str = name.next();
		File file = new File(directoryName+str+".txt");
         
         if(file.createNewFile())System.out.println("Success!");
         else System.out.println ("Error, file already exists.");
         filesOperationsMenu();
		
	}
	
	
	
	public void deleteFile () throws IOException {
		
		System.out.println("Please enter the file name\n");
		
		Scanner name = new Scanner(System.in);
		String str = name.next();
		File file = new File(directoryName+str+".txt");
         
         if(file.delete())System.out.println("Success!");
         else System.out.println ("Error, file not exists.");
         filesOperationsMenu();
		
	}
	
	public void serachFile() throws IOException {
		
		System.out.println("Please enter the file name\n");
		
		Scanner name = new Scanner(System.in);
		String str = name.next();
		File file = new File(directoryName+str+".txt");
         
         if(file.exists())System.out.println("Success!"+ str+".txt"+ " file exists");
         else System.out.println ("Error, file not exists.");
         filesOperationsMenu();
	}
	
	
	public void filesOperationsMenu() throws IOException {
		
		System.out.println("\n1.Add file ");
		System.out.println("2.Delete file ");
		System.out.println("3.Serach file ");
		System.out.println("4.Return to main menu\n ");
		
		System.out.println("Please enter your option\n");
		
		Scanner mainOption = new Scanner(System.in);
		String name=mainOption.next();
	//	int result = Integer.parseInt(name);
		switch(name) {
		case "1": addFile();break; 
		case "2":deleteFile();break;
		case "3":serachFile();break;
		case "4":mainMenu();break;
		default:System.out.println("Please enter the valid option"); filesOperationsMenu(); break;
		}
		
	}

}
