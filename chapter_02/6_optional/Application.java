import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Application {
	public static void main(String... args) {
		
		Application app = new Application();
		// Optional<Integer> prize = Optional.of(null);  -> java.lang.NullPointerException
		Optional<Integer> prize1 = Optional.empty();
		System.out.println("Object is equal with itself: " + prize1.equals(prize1)); //prints: true
		
		Optional<Integer> prize2 = Optional.ofNullable(null);
		System.out.println("Empty optional is equal to optional that wraps null: " + prize1.equals(prize2)); //prints: true
		
		Optional<Integer> prize3 = Optional.empty();
		System.out.println("They are equal even if references are not equal prize1 != prize3: " + prize1.equals(prize3)); //prints: true
		
		Optional<String> congrats1 = Optional.empty();
		System.out.println("Objets of different types (Integer, String) are equal: " + prize1.equals(congrats1)); //prints: true
		
		// Use or(Suppier<Optional<T>> supplier)
		Optional<Integer> lotteryPrize = Optional.ofNullable(null);
		int prize = lotteryPrize.or(() -> Optional.of(0)).get();
		System.out.println("Prize is: " + prize);
		app.processOrGet(lotteryPrize);
		app.processIfPresentOrElse(lotteryPrize);
		
		lotteryPrize = Optional.ofNullable(-8);
		lotteryPrize.ifPresent(app::checkResultAndShare);
		
		List<Optional<Integer>> list = List.of(Optional.empty(),
										Optional.ofNullable(null),
										Optional.of(100000));
		app.useFlatMap(list);
	}
	
	private void processOrGet(Optional<Integer> lotteryPrize) {
		int prize = lotteryPrize.orElseGet(() -> 42);
		lotteryPrize.ifPresentOrElse(p->checkResultAndShare(p),
					() -> System.out.println("Better " + prize 
                                     + " than nothing..."));
	}
	
	private void checkResultAndShare(int prize){
		if(prize <= 0){
			System.out.println("We've lost again...");
		} else {
			System.out.println("We've won! Your half is " + 
					   Math.round(((double)prize)/2) + "!");
		}
	}
	
	private void processIfPresentOrElse(Optional<Integer> lotteryPrize){
		Consumer<Integer> weWon = prize -> checkResultAndShare(prize);
		Runnable weLost = () -> System.out.println("We've lost again...");
		lotteryPrize.ifPresentOrElse(weWon, weLost);
	}
	
	private void processOrThrow(Optional<Integer> lotteryPrize){
		int prize = lotteryPrize.orElseThrow(() -> 
			   new RuntimeException("We've lost again..."));
		checkResultAndShare(prize);
	}
	

	void useFlatMap(List<Optional<Integer>> list){
		Function<Optional<Integer>, Stream<Optional<Integer>>> tryUntilWin = opt -> {
			List<Optional<Integer>> opts = new ArrayList<>();
				if(opt.isPresent()){
					opts.add(opt);
				} else {
					int prize = 0;
					while(prize == 0){
					double d = Math.random() - 0.8;
					prize = d > 0 ? (int)(1000000 * d) : 0;
					opts.add(Optional.of(prize));
				}
			}
			return opts.stream();
		};
	
		list.stream().flatMap(tryUntilWin).forEach(opt -> checkResultAndShare(opt.get()));
	}
}
