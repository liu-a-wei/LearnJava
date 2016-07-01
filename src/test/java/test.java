import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class test {
	public static void main(String[] args) {
		
		String msg = "ghgk.123.";
		
		System.out.println(msg.lastIndexOf("."));
		
		
		
		
		
		System.out.println("-------------------------------");
		
		
		
		
		String str2 = ",0,,";
		String[] arr2 = str2.split(",");
		for(int i = 0; i < arr2.length; i++){
			String string = arr2[i];
			System.out.println(string);
		}
		String str = "大幅度,undfined,33,44--大发大水发呆,1,333,333";
		String[] arr = str.split("-");
		for(int i = 0; i < arr.length; i++){
			String string = arr[i];
			System.out.println(string);
		}
		
		System.out.println(System.currentTimeMillis());
	}
}
