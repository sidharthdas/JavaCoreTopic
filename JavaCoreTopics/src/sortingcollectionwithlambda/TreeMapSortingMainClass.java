package sortingcollectionwithlambda;

import java.util.HashMap;
import java.util.TreeMap;

public class TreeMapSortingMainClass {

	public static void main(String[] args) {

		TreeMap<Integer, String> map = new TreeMap<Integer, String>((I1, I2) -> I1 > I2 ? 1 : (I1 < I2) ? -1 : 0);
	}

}
