import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class FileReader {
	
	/* Read input file contents and return result as ArrayList<String>
	 * 
	 * filePath	[String]: Path of file to be read 
	 */
	public ArrayList<String> readFile(String filePath) {
		FileInputStream fstream;
		ArrayList<String> list = new ArrayList<String>();
		String strLine;
		
		try {
			fstream = new FileInputStream(filePath);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			//Read file until EOF
			while ((strLine = br.readLine())!= null) {
				list.add(strLine);
			}
			
			//close FileInputStream
			fstream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
