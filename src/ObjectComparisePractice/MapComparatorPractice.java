package ObjectComparisePractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MapComparatorPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> game = new HashMap<String, Integer>();
		game.put("LOL", 50);
		game.put("Overwatch", 70);
		game.put("HOS", 20);
		game.put("SC", 40);
		
		//Sort By Value using Lambda
		game = game.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(Arrays.toString(game.entrySet().toArray()));
		
		
		//Sort By Key using TreeMap
		TreeMap<String, Integer> sorted_game = new TreeMap<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		sorted_game.putAll(game);
		System.out.println(Arrays.toString(sorted_game.entrySet().toArray()));
		
		//Sort By Value using TreeMap
		sorted_game = new TreeMap<>(new TreeComparator(game));
		sorted_game.putAll(game);
		System.out.println(Arrays.toString(sorted_game.entrySet().toArray()));
	}
}

class TreeComparator implements Comparator<String>{

	private Map<String, Integer> map;
	
	public TreeComparator(Map<String, Integer> base) {
		// TODO Auto-generated constructor stub
		this.map = base;
	}

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return map.get(o1)-map.get(o2);
	}
	
}
