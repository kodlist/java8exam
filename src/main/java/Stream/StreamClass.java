package Stream;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamClass {
	
	public static void main(String[] args) {
		
		Stream<String> words = Stream.of("lower", "case", "text");
		System.out.println(words);
		List<String> list = words
		                        .peek(s -> System.out.println(s))
		                        .map(s -> s.toUpperCase())
		                        .collect(Collectors.toList());
		
		System.out.println(" -> "+list);
		
		System.out.println("====================");
		
		/*********************/
		
		List<String> list2 = Arrays.asList("Java", "is", "not", "great");
		Optional<String> result = list2.stream()
		                               .filter(item -> item.contains("t"))
		                               .findAny();
		System.out.println(result.get());

		System.out.println("====================");

		List<Integer> names = Arrays.asList(1, 2,3);
		System.out.println(names.stream().mapToInt(x->x).sum());

		ToIntFunction<Integer> mapper = (x) -> x ;
		System.out.println(names.stream().mapToInt(mapper).sum());

		ToIntFunction<Integer> mapper1 = new ToIntFunction() {
			@Override
			public int applyAsInt(Object value) {
				if( value instanceof  Integer)
				{
					return (Integer) value;
				}
				return 0;
			}
		} ;
		System.out.println(names.stream().mapToInt(mapper1).max().getAsInt());

		System.out.println("====================");

		System.out.println(names.stream().reduce(0, (a, b)->a+b));

		//System.out.println(names.stream().reduce(0, (a, b)->a+b));
		System.out.println("======== IntSummaryStatistics> ============");
		System.out.println(names.stream().collect(Collectors.mapping(x->x, Collectors.summarizingInt(x->x))).getSum());

		System.out.println(names.stream().collect(Collectors.summarizingInt(x->x)).getSum());

		System.out.println("===============================================");
		System.out.println("============ Stream contains ==================");

		Stream<List<String>> s1 = Stream.of(  Arrays.asList("a", "b"),   Arrays.asList("a", "c")  );

		Stream<String> news = s1.filter(s->s.contains("c")).flatMap(olds -> olds.stream());
		news.forEach(System.out::print);
		System.out.println("============ Stream flatmap ==================");
		s1 = Stream.of(  Arrays.asList("a", "b"),   Arrays.asList("a", "c")  );
		s1.flatMap( f-> f.stream()).forEach(c -> System.out.println(c));



	}

}
