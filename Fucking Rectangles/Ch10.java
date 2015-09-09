import java.util.*;

public class Ch10 {
	public static void main(String[] args){
		ArrayList<String> list = new ArrayList<String>();
		list.add("A");list.add("C");list.add("D");list.add("G");list.add("I");list.add("K");
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("B");list2.add("E");list2.add("F");list2.add("H");list2.add("J");list2.add("L");
		System.out.println(merge(list, list2));
	}
	
	public static ArrayList<String> merge(ArrayList<String> list, ArrayList<String> list2){
		
		ArrayList<String> newList = new ArrayList<String>();
		
		int loc1=0;
		int loc2=0;
		
		for (int i=0; i<list.size()+list2.size(); i++){
			if((list.get(loc1).compareTo(list2.get(loc2)))<0){
				newList.add(list.get(loc1));
				if (loc1<list.size()-1){
					loc1++;
				}
			}else{
				newList.add(list2.get(loc2));
				if (loc2<list2.size()-1){
					loc2++;
				}
			}
			if (i==list.size()+list2.size()-2){
				
				if(loc1==list.size()-1){
					newList.add(list2.get(loc2));
				}else if(loc2==list2.size()-1){
					newList.add(list.get(loc1));	
				}
				i++;
			}
		}
		return newList;	
	}
}
