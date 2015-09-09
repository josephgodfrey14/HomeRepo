public class day1hw{
	public static void main(String[] args){
		String[] words = {"sunny", "cloudy", "rainy", "cloudy", "clear",};
		System.out.println(countTarget(words, "cloudy"));
	}
	public static int countTarget(String[] words, String target){
		int count = 0;
		for (int i=0; i<words.length; i++){
			if (target.equals(words[i])){
				count++;
			}
		}
		return count;
	}
}
