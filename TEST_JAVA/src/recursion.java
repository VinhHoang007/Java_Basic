
public class recursion {

	public static void main(String[] args) {

	    String maKH = "KH0002";
	    int n= maKH.length()-2;
	    char arr[] = new char[maKH.length()];
	    arr = maKH.toCharArray();

	    char arr1[] = new char[n];
	    int count =0;
	    for(int i=2;i<n;i++) {
	    	arr1[count] = arr[i];
	    	count++;
	    }
	    
	    for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
//	    int newArr[] = new int[n];
//	    for(int i=0;i<arr.length;i++) {
//	    	newArr[i] = Integer.parseInt(String.valueOf(arr[i]));
//	    }
//	    if(arr[n-1]>='0' && arr[n-1]<='8') {	 
//	    	arr[n-1]+='1';
//	    }
//	    System.out.println(arr[n-1]);

	}

}
