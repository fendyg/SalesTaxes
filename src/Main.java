import java.io.File;
import java.util.ArrayList;


public class Main {
	
	/*Get all files in a specified directory and return their names
	 * directoryName	[String]: The relative path of the directory to be listed
	 * */
	public static File[] listFiles(String directoryName){
		File directory = new File(directoryName);
		
		File[] fileList = directory.listFiles();
		
		return fileList;
	}
	
	public static void main(String[] args) {
		String inputDirectory = "input";
		int inputCount = 1;
		
		//Get all files in input directory
		File[] fileList = listFiles(inputDirectory);
		
		FileReader fr = new FileReader();
		InputParser parser = new InputParser();
		FileWrite fw = new FileWrite();

		//Read, Parse all input files and produce output 
		for (File file : fileList) {
			ArrayList<String> list = fr.readFile(file.getAbsolutePath());
			
			//Parse each input file
			ArrayList<String> output = parser.parse(list);
			
			//Write output file
			fw.writeFile(output, inputCount);
			
			inputCount++;
		}
	}

}
