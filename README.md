# Convert CSV data file to Weka's Arff format
Converter.jar converts the csv datafile into Weka's Arff file format
##A. Requirements: 
In order to run the jar, Java 1.7+ is required, other necessary libraries are packaged into jar itself. 

##B. Steps to run the converter jar file:
1. Open the command line; Navigate to the location where the converter jar is stored.
2. The converter jar takes two runtime arguments: name of the dataset and csv dataset file. Run the following Command:

         java -jar converter.jar [name of the datatset] [csv dataset file]

         e.g.: java -jar converter.jar polarity trainpolarity.csv
3. The new Arff file is stored in the /data folder
