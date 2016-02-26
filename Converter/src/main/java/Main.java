import java.io.File;
import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.core.converters.ArffSaver;
public class Main {
	/**
	 * Method main reads the data from file, checks for the type of the extension of the file for csv
	 * and converts it into the weka Arff format.
	 * @param datasetname
	 * @param filename
	 * @return data
	 */


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
			Instances data = null;
			//String datasetname = "amazon";
			//String filename = "./data/amazon.arff";		
			
			String datasetname = args[0];
			String filename = args[1];
			
			File f = new File(filename);
			if (f.exists() == true) 
			{
				String fileextension = getFileExtension(filename);
				
				if(fileextension != null){
					if(fileextension.contentEquals("csv")){
						CSVLoader csvloader = new CSVLoader();
						
						try {
							csvloader.setSource(new File(filename));
							data = csvloader.getDataSet();
							System.out.println("Reading the data from csv file.");
							ArffSaver arffsaver = new ArffSaver();
							arffsaver.setInstances(data);
							
							try {
								System.out.println("Converting it into Arff format.");
								arffsaver.setFile(new File("./data/"+datasetname + ".arff"));
								arffsaver.writeBatch();
								System.out.println("Writing the formatted data to file - ./data/"+datasetname + ".arff.");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else{
						System.out.println("please pass a .csv file");
					}
				}
					
			}else{
				System.out.println("File could not be found in the specified location");
			}
			
			
	
		
		

}
	/**
	 * The method getFileExtension reads the string filename and return extension of the file if present else returns null
	 * @param filename
	 * @return file extension or null
	 */
	private static String getFileExtension(String filename){
		if(filename.lastIndexOf(".") != -1  && filename.lastIndexOf(".") !=0)
		return filename.substring(filename.lastIndexOf(".")+1);
		else
		return null;
	}
	

}
