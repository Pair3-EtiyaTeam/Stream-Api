import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public interface api {

	public static void main(String[] args) {
		// FILTER KOMUTU
		List<String> name = Arrays.asList("MUHAMMET", "SAGLAM", "TRABZON");
		List result = name.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
		System.out.println(result);
		System.out.println("*********************************");

		
		
		// CONTAINS KOMUTU KELIME ICERISINDEKI HARFE GORE ARAMA YAPAR
		List<String> ad = Arrays.asList("ISTANBUL", "ANKARA", "TRABZON");
		List sonuc = ad.stream().filter(s -> (s.contains("T")) && (s.contains("A"))).collect(Collectors.toList());
		System.out.println(sonuc);
		System.out.println("*********************************");
		
		
		// SORTED KOMUTU SIRALAMA YAPMAYI SAGLAR
		List<String> isim = Arrays.asList("MUHAMMET", "KAAN", "OSMAN");
		List<String> test = isim.stream().sorted().collect(Collectors.toList());
		System.out.println(test);
		System.out.println("*********************************");
		
		
		// REVERSE ORDER ILE LISTE TERSTEN SIRALANABILIR
		List<String> sayi = Arrays.asList("5", "2", "1", "3");
		List<String> tester = sayi.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(tester);
		System.out.println("*********************************");
		
		
		
		//REDUCE KOMUTU ILE ISLEMLERI ADIMLAYARAK GOSTERIR
		List<Integer> number = Arrays.asList(5, 3, 2, 8);
		int newNumber = number.stream().reduce(1, (i, i1) -> {
		    System.out.println(i * i1);
		    return i * i1;
		});
		System.out.println("*********************************");
		
		
		
		//MAP KOMUTU STREAM ICINDEKI ELEMANLARI FOREACH BASKA TIPLERE DONDURMEK ICIN KULLANILIR
		List<String> eleman = Arrays.asList("MUHAMMET", "  SAGLAM");
		eleman.stream().map(s -> "  EKLENTÝ 1  " + s + "  EKLENTÝ 2  ").forEach(System.out::println);
		System.out.println("*********************************");
		
		
		
		//DOUBLE GIRILEN VERIYI MAP ILE INT CEVIRME
		DoubleStream doubleStream = DoubleStream.of(0.5, 1.2, 3.1, 12.2);
		doubleStream.mapToInt(v -> (int) v).forEach(System.out::println);
		System.out.println("*********************************");
		
		
		
		//DISTINCT ILE LISTEDE TEKRAR EDEN VERILERI TEK VERIYE DONUSTURUR
		List<String> names= new ArrayList<String>();
		names.add("MUHAMMET");
		names.add("MUHAMMET");
		names.add("SAGLAM");
		names.add("SAGLAM");
		names.add("TRABZON");
		names.add("TRABZON");
		names.add("MUHAMMET");
		names.add("SAGLAM");
		names.add("TRABZON");
		names.stream().distinct().forEach(System.out::println);
		System.out.println("*********************************");
		
		
		
		//COUNT ILE ARALIKTAKI VERI SAYISINI GOSTERIR
		long x = IntStream.range(10, 30).count();
		System.out.println(x);
		System.out.println("*********************************");
					
	}
}
