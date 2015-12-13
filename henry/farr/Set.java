package henry.farr;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Set {

	List<String> nameList;
	HashSet<String> hashList;
	int[] indexOfAmt;
	
	String setName;
	int totalEntries;
	int nextArrayIndex;
	
	List<Object> subsets;
	
	public Set(String setName) {
		this.setName = setName;
		
		subsets = new ArrayList<Object>();
		nameList = new ArrayList<String>();
		hashList = new HashSet<String>();
		indexOfAmt = new int[9999999];
		totalEntries = 0;
		nextArrayIndex = 0;
	}
	public Set newSubset(String name) {
		
		subsets.add(new Set(name));
		return (Set) subsets.get(subsets.size() - 1);
	}
	
	public String finish() {
		
		StringBuilder sb = new StringBuilder();
		
		
		System.out.println("Finishing set: " + this.setName);
		System.out.println(subsets.size());
		
		sb.append(setName);
		for (int i = 0; i < subsets.size(); i++) {	//this used to be i < nameList.size() but fairly certain it needs to be subset.size
			sb.append(System.lineSeparator());
			sb.append("\n" + ((Set) subsets.get(i)).finish());
			
	
		}
		
		int i = 0;
		System.out.println(i + " " + nextArrayIndex);
		while (i < nextArrayIndex) {
			//Format later
//			System.out.println(setFinal + ", " + "\n" + nameList.get(i) + ": " + (indexOfAmt[i] / totalEntries));
			System.out.println("Last while loop indOfAmt: " + indexOfAmt[i] + ", totalEntries: " + totalEntries);
			sb.append("\n" + nameList.get(i) + ": %" + displayAsPercent(100* ((double) indexOfAmt[i] / (double) totalEntries)));
			i++;
		}
		
		return sb.toString();
	}
	
	
	
	public boolean addToList(String name) {

		System.out.println();
		System.out.println(subsets.size() + " " + this.setName);
		
		
		if (subsets.size() > 0) {
			System.out.println("I am a subset!");
			return ((Set) subsets.get(subsets.size() - 1)).addToList(name);
			
		} else {
			System.out.println("Adding: " + name);
			
			boolean temp = hashList.add(name);
			if (temp) {
				nameList.add(name);
				indexOfAmt[nextArrayIndex] = 0;
				nextArrayIndex++;
			}
			
			totalEntries++;
			incrementIndex(nameList.lastIndexOf(name));
			
			return temp;

		}
	}
	
	private void incrementIndex(int index) {

		indexOfAmt[index]++;
		System.out.println(index + " " + indexOfAmt[index]);
	}

	private String displayAsPercent(double num) {
		
		DecimalFormat dec = new DecimalFormat("#.00");
		
		return dec.format(num);
	}
	
	
}
