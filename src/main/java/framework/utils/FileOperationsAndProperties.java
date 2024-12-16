package framework.utils;

import java.io.*;
import java.util.Properties;

public class FileOperationsAndProperties {

    private static final String CAMINHO_RESOURCES = System.getProperty("user.dir") + File.separator +
            "src" + File.separator + "main" + File.separator + "resources" + File.separator;

    public static Properties getProperties(String fileName) throws IOException {
        InputStream inputStream = null;
        Properties prop = new Properties();
        try {
            File file = new File(fileName);
            inputStream = new FileInputStream(CAMINHO_RESOURCES + file);
            prop.load(inputStream);
            return prop;
        } catch (Exception e){
            System.out.println("Passando exception "+ e.getMessage());
        } finally {
            inputStream.close();
        }
        return prop;
    }

    public static void setProperties(String fileName, String propKey, String propValue) throws IOException {
        Properties prop = getProperties(fileName);
        try {
            OutputStream outputStream = new FileOutputStream(CAMINHO_RESOURCES + fileName);
            prop.setProperty(propKey, propValue);
            prop.store(outputStream, null);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getPropertiesData(String fileName, String property){
        try {
            Properties properties = getProperties("properties"+ File.separator + fileName +".properties");
            return properties.getProperty(property);
        } catch(Exception e){
            System.out.println("Não foi possível ler o arquivo"+e.getMessage());
            return null;
        }
    }

    public static void setPropertiesData(String fileName,String propKey,String propValue){
        try {
            setProperties("properties"+ File.separator + fileName + ".properties",propKey,propValue);
        } catch(Exception e){
            System.out.println("Não foi possível ler o arquivo"+e.getMessage());
        }
    }

}
