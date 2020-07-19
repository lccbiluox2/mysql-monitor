package com.neo.properties;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

public class MyProperties {

	
	
	
	 /*********************************************************/
    /**
     * @param args
     */

    public int saveProperties(String key, String value, String filePath) {
    	 ///保存属性到b.properties文件
    	Properties prop = new Properties();
    	FileOutputStream oFile;
		try {
			oFile = new FileOutputStream(filePath);
			prop.setProperty(key, value);
	    	prop.store(oFile, null);
	    	oFile.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//true表示追加打开
    	
		return 0;
    }

    
    /*********************************************************/
    /**
     * @throws IOException 
     * @throws FileNotFoundException ****************************************************************/
    public int readProperties(String key, String filePath) {
    	Properties prop = new Properties();
    	//读取属性文件a.properties
    	InputStream in;
		try {
			in = new BufferedInputStream (new FileInputStream(filePath));
			prop.load(in);     ///加载属性列表
	        Iterator<String> it=prop.stringPropertyNames().iterator();
	    	while(it.hasNext()){
	    		String strKey=it.next();
	    		String strValue =  prop.getProperty(strKey);
	    		if(strKey.equals(key) ){
	    			return Integer.parseInt(strValue);
	    		}else{
	    			return -1;
	    		}
	    	}
	    	in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return -1;
    }
    
    /*********************************************************/
}
