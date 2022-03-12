package ASSIGNMENT_DAY6_7;
//Chuyển đổi String thành int trong java
public class Assignment29_9_String {
	public static void stringtoInt() {
		String s = "100";
        int i = Integer.parseInt(s);
        System.out.println(s + 50);//10050
        System.out.println(i + 50);//150
	}
	public static void inttoString() {
		int i = 100;
        String s = String.valueOf(i);
        // 160 vì + là thao tác cộng số nguyên
        System.out.println(i + 60);
        // 10060 vì + là thao tác nối string
        System.out.println(s + 60);
	}
	public static void main(String[] args) {
		
		stringtoInt();
		inttoString();

	}

}
