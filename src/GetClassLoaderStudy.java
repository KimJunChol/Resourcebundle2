import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;

public class GetClassLoaderStudy {

//	private Logger logger = null;
	
	private final String Message_ID = "messageId";
	
	private final String DENBUN_ID = "denbunId";
	
	private final String NODE_NAME = "nodeName";
	
	private final String LOG_CLASS = "logClass";
	
	private final String USER_ID = "userId";
	
	private final String SPACE = " ";
	
//	private final String propertiesPath = LogControl.class.getClassLoader.getResource("message.properties").getPath();
	
	// property를 static class변수로 선언
	// Resourcebundle을 사용해서 수정해보기
	// 여러번 LogProperty를 불러오는 경우는 없으므로 Constructor를 @Postconstruct로 선언한 메소드로 프로퍼티를 한번만 읽어들이기
	
//	static Locale locale = new Locale("ja_jp");
//	static ResourceBundle config = ResourceBundle.getBundle("message");
//	static URL url = ClassLoader.getSystemResource("message.properties");
	
	static ResourceBundle resourceBulde = ResourceBundle.getBundle("message");
	
//	@PostConstruct
//	static void getResourceBundle() {
//		resourceBulde = ResourceBundle.getBundle("message");
//	}
	
	public static void main(String[] args) {
//		System.out.println(url);
//		String bundleLocation = url.toString();
//		System.out.println(bundleLocation);
//		
//		URL[] urls = { url };
//		
//		ResourceBundle config = ResourceBundle.getBundle("message", Locale.JAPANESE, new URLClassLoader(urls));
//		System.out.println(config);
//		System.out.println(config.getString("test1"));
		
		Enumeration<String> e = resourceBulde.getKeys();
		
		try {
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				
				String value = resourceBulde.getString(key);
				
				// 한글을 사용할경우 인코딩처리
				String value2 = new String(resourceBulde.getString(key).getBytes("ISO-8859-1"), "euc-kr");
				
				System.out.println( "value1 = " + value);
				System.out.println( "value2 = " + value2);
				System.out.println("#####");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
