package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamClass {
	
	public static void main(String[] args) {
		
		Stream<String> words = Stream.of("lower", "case", "text");
		List<String> list = words
		                        .peek(s -> System.out.println(s))
		                        .map(s -> s.toUpperCase())
		                        .collect(Collectors.toList());
		
		System.out.println(list);
		
		System.out.println("====================");
		
		/*********************/
		
		List<String> list2 = Arrays.asList("Java", "is", "not", "great");
		Optional<String> result = list2.stream()
		                               .filter(item -> item.contains("t"))
		                               .findAny();
		System.out.println(result.get());
	}

}
