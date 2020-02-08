public class Exercises {
	public static void main(String[] args) {
		
		// Write code to determine wether the toString and substring 
		// methods of StringBuilder and String class return an interned 
		// string or not
		
		// String -> toString()
		String stringObject = new String("hello");
		System.out.printf("is toString method of String interned? %b\n",  
			stringObject.toString() == "hello"); // false
		
		// String -> substring(start, end);
		String subStringObject = stringObject.substring(0,2);
		System.out.printf("is substring method of String interned? %b\n",  
			subStringObject == "he");

		// String -> toString()
		String literal = "hello";
		System.out.printf("is toString method of literal interned? %b\n",  
			literal.toString() == "hello"); // true
		System.out.printf("is substring method of literal interned? %b\n",  
			literal.substring(0,2) == "he");
		
		StringBuilder stringBuilder = new StringBuilder("hello");
		System.out.printf("is toString method of StringBuilder interned? %b\n", 
			stringBuilder.toString() == "hello"); // false
		
		String subStringBuilder = stringBuilder.substring(0,2);
		System.out.printf("is substring method of StringBuilder interned? %b\n", 
			subStringBuilder.toString() == "he");
	}
}
