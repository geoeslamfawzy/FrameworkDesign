package constants;

public final class FrameworkConstants {
    private static final String CHROMEDRIVERPATH = System.getProperty("user.dir")+ "\\drivers\\chromedriver.exe";
    private static final String CONFIGFILEPATH = System.getProperty("user.dir")+"\\src\\test\\java\\config\\config.properties";
    private static final int EXPLICITWAIT = 10;
    public static final String RESOURCESPATH = System.getProperty("user.dir") + "\\src\\test\\java\\data\\";


    public static String getChromePath(){
        return CHROMEDRIVERPATH;
    }
    public static String getConfigFilePath(){
        return CONFIGFILEPATH;
    }
    public static int getExplicitwait(){
        return EXPLICITWAIT;
    }
    public static String readDataFile(String fileName){
        return RESOURCESPATH + fileName;
    }



}
