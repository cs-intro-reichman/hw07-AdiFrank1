

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		System.out.println (existInDictionary(hashTag, dictionary));
		hashTag = hashTag.toLowerCase();
		breakHashTag(hashTag, dictionary);
	}

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
		// Your code here

		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) 
	{

		for (int i=0;i<dictionary.length; i++)
		{
			if (dictionary[i] != null && dictionary[i].equals(word))
				return true;;
		}

		return false;

		// Your code here
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.

        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();
		hashtag = hashtag.toLowerCase();


        for (int i = 1; i <= N; i++)

			{
				String subster = hashtag.substring(0,i);	
				if (existInDictionary (subster,dictionary))
				{
					System.out.println (subster);
					breakHashTag(hashtag.substring(i), dictionary);
					return;
				}
			}

	}

}
