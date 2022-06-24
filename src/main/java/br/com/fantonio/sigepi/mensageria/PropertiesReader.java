package br.com.fantonio.sigepi.mensageria;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	private static File file;
	private static Properties props;
	private static FileInputStream fis;
	
	public static Properties getProperties(final String path)  {
		
        file = new File(path);      
        props = new Properties();  
        fis = null;  
        try {  
            fis = new FileInputStream(file);  
            props.load(fis);    
            fis.close();  
        }  
        catch (IOException ex) {  
            System.out.println(ex.getMessage());  
            ex.printStackTrace();  
        }  
		
        return props;
	}

	
}
