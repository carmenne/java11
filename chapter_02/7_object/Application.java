import java.util.Comparator;
import java.util.Objects;
import java.util.List;

public class Application {
	public static void main(String... args) {
		int res = Objects.compare(3, 5, Comparator.naturalOrder()); 
		print(res); // -1
		res = Objects.compare(3, 3, Comparator.naturalOrder()); 
		print(res); // 0
		res = Objects.compare(5, 3, Comparator.naturalOrder()); 
		print(res); // 1
		res = Objects.compare(5, 3, Comparator.reverseOrder()); 
		print(res); // -1
		res = Objects.compare("5", "3", Comparator.reverseOrder()); 
		print(res); // -2
		res = Objects.compare(null,null,Comparator.naturalOrder());
		print(res); // 0
		//Objects.compare(null, "c", Comparator.naturalOrder());  -> throws NullPointerException
		//Objects.compare("a", null, Comparator.naturalOrder());  -> throws NullPointerException
		
		// toString(Object obj, String nullDefault)
		System.out.println(Objects.toString("a")); //prints: a
		System.out.println(Objects.toString(null)); //prints: null
		System.out.println(Objects.toString("a", "b")); //prints: a
		System.out.println(Objects.toString(null, "b"));//prints: b
		
		// int checkIndex(int index, int length)
		List<Integer> list = List.of(1, 2);
		try {
			Objects.checkIndex(3, list.size());
		} catch (IndexOutOfBoundsException ex){
			System.out.println(ex.getMessage()); 
			//prints: Index 3 out-of-bounds for length 2
		}
		
		// int checkFromIndexSize(int fromIndex, int size, int length)
		
		
	}
	
	private static void print(int res) {
		System.out.println("Result: " + res); 
	}
}
