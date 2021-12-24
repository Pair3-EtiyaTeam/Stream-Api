package streamApiPresentation;

import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamMain {

	public static void main(String[] args) {
		
		
		/*
			Stream API, Collection nesnelerini ( Collectionlar, diziler, listeler v.b) işlemek için kullanılır. Stream bir veri yapısı değildir.
		Bunun yerine Collectionlar, diziler gibi yığın verileri girdi alır.
		Stream API orijinal veri yapısını değiştirmez, yalnızca ardışık düzen yöntemlerine göre sonuç sağlar.
		 
		Stream bir interface dir bu yüzden dogrudan nesnesi oluşturulamaz.
		
		1.Stream - dizi liste ve değişkenler gibi içerisinde veri saklamaz.
		
		2.Stream dizi ve listelerimizin elemanları üzerinde işlem yapmamızı olanak sağlar.
		
		3.çeşitli hazır fonksiyonları sayesinde listemizdeki bütün elemanları işledikten sonra sonuç üretebilir.
		
		4.veri saklayan yapıları kullanarak üzerinde işlem yapar ve orjinal verilerimizi değiştirmez.
		
		5.Stream içerisinde elemanlar sadece 1 kez ziyaret edilir. Aynı elemanı tekrar işleme sokabilmek için yeni bir stream oluşturmalırdır.
		
		6.Stream kullanılırken lambda expression syntaxı kullanılmaktadır.
		
		7.Paralel stream çok çekirdekli işlemcilerden yararlanır Stream sıralı şekilde yani bir iş bitmeden diger işe geçmez ama paralel streamde 
		aynı anda bir den çok iş yapılır(avantajları=çok daha hızlı olması 
		dezavantaj= forech gibi sırası ile çalışmasını istedıgımız yerlerde veriler karışa bilir).
		
		8.büyük verilerde ilk başta filter kullanılıp daha az veri ile işlem yapılması tercih ediliyor.

		 */
		//-------------------------------------------------------------------------------------------------
		/*
		HashMap<String, String> Car = new HashMap<String, String>();
		Car.put("color", "mavi");
		Car.put("brand", "bmw");
		Car.put("km", "10000");
		Car.put("model", "2000");
		*/
		
		
		
		
		
		List<String> stringList = new ArrayList<String>();

        stringList.add("ONE");
        stringList.add("TWO");
        stringList.add("THREE");

		Stream<String> items = stringList.stream();
		
		System.out.println( items.collect(Collectors.toList())+ "\n----------------------------------------------------------------------------");
		
		//items.map(v ->  v.toLowerCase()).forEach(System.out::println);
		
		List<String> map = stringList.stream()
				.map(v ->  v.toLowerCase())
				
				.collect(Collectors.toList());
		
		System.out.println(map.toString());
		
		//filter ve count -----------------------------------------------------------------------------------------------------------------------------------------------------
		/*
		filter(): verilen kriterlere gore filtreleme yapar
		içerisindeki şartı saglayan yani true dödüğünde işlemi gerçekleştirir.
		
		count(): elementlerin sayısını verir.
		  */
		Long count = stringList.stream()
				.filter(x -> x.length() > 3)
	            .count(); 

		System.out.println(count + "\n----------------------------------------------------------------------------");

		//sorted----------------------------------------------------------------------------------------------------------------------------------------------		
		/*
		 * sorted(): Sıralama yapmamızı saglar. String ise harf sırasına göre int ise küçükten büyüge dogru sıralar
		 * */
		List<String> sort = stringList.stream()
				.sorted()
				.sorted(Collections.reverseOrder())
				.collect(Collectors.toList());
		System.out.println(sort.toString()+"\n-----------------------------------------------------------------------------------");
		
		//forEach-------------------------------------------------------------------------------------------------------------------------------------------------------
		
		List<Integer> num = Arrays.asList(2,3,3,4,5);
		List<Integer> sqr = num.stream()
				.filter(x -> x>2)
				.distinct()//tekrar eden değerlerin sadece birinialıcak.
				.map(x -> x*x)// her bir elemanın  kareseini alacak.
				.collect(Collectors.toList());//list tipinde değer döndürecek.
		
		sqr.stream().forEach(x -> System.out.println(x));
		
		System.out.println(" limit(2)----------------------------------------------------------------------------");
		sqr.stream().limit(2).forEach(x -> { System.out.println(x+1);});
		
		System.out.println("----------------------------------------------------------------------------");
		sqr.stream().forEach(System.out::println);
		
	}

}
