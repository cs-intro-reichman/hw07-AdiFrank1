
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
		System.out.println(tail (word));
		System.out.println (levenshtein("love","i"));
	}

	public static String tail(String str)
	{
		String newStr = str;

		if (newStr.length() ==1)
		{	
			return null; 
		
		}

			newStr = newStr.substring(1,newStr.length());

		return newStr;
	
		// Your code goes here
	}

	public static int levenshtein(String word1, String word2)
	{

		if (word1 == null)
			return (word2 !=null ? word2.length() : 0 );

		if (word2== null)
			return word1.length();

		if (word1.length()==0)
			{
				return word2.length();
			}
			if (word2.length()==0)

			{
				return word1.length();
			}
			
		if (word1.charAt(0) == word2.charAt(0))
			{
				return levenshtein (tail(word1),tail(word2));
			}

		int option1 = levenshtein (tail(word1),word2);
		int option2= levenshtein (word1, tail(word2));
		int option3 = levenshtein (tail(word1),tail(word2));

			return 1+ (Math.min ((Math.min (option1,option2)),option3));
		}
		// Your code goes here
	

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);
		for (int i=0;i<dictionary.length-1; i++)
			{
				if (in != null && !in.isEmpty())
				{
					String word = in.readLine();
					dictionary[i]= word;
				}
			}

		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) 
	{
		String fits = " ";
		int minMatch = Integer.MAX_VALUE; 

		for (int i=0; i<dictionary.length; i++ )
		{
			int distance = levenshtein(dictionary[i],word);

			if (distance <= threshold && minMatch > distance)
			{
				fits = dictionary[i];
				minMatch = distance;
			}
		}

			if (!fits.isEmpty() )
			{
				return fits;
			} 
			else
			{
				return word;
			}

		// Your code goes here
	}

}
