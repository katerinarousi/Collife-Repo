import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.*;
import java.io.IOException;

public class UnilinkFile {
	File myfile = new File("UnilinkUser.txt");
	public void deleteUnilinkFile() {
		if (myfile.delete()) {
			System.out.println("File Deleted Successfully");
		} else {
			System.out.println("Failed to Delete the File");
		}
	}


	public void createUnilinkFile() {
		try {
			if (myfile.createNewFile()) {
						myfile.getName();
			} else {
						System.out.println("File Exists Already");
			}
		 } catch (IOException e) {
		 }
	 }
 }




