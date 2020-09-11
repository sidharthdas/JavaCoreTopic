package playbookITC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*22.	There is a list or array of Strings containing IP addresses. We need to find the IPs with maximum occurrences*/

public class MainClass22 {

	public static void main(String[] args) {

		int max = 0;
		final int mainMax;
		List<String> ips = new ArrayList<>();

		Map<String, Integer> ipsMap = new HashMap<>();

		for (String ip : ips) {
			if (ipsMap.containsKey(ip)) {
				ipsMap.put(ip, ipsMap.get(ip) + 1);
			} else {
				ipsMap.put(ip, 1);
			}
		}

		for (Map.Entry<String, Integer> map : ipsMap.entrySet()) {
			if (map.getValue() > max) {
				max = map.getValue();
			}
			
		}
		mainMax = max;
		Map<String, Integer> newipsMap = ipsMap.entrySet().stream().filter(x -> x.getValue() == mainMax)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		
		System.out.println(newipsMap);
	}

}
