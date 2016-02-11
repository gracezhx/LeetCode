import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class Solution {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		if(beginWord == null || endWord == null || wordList == null || beginWord.length() != endWord.length()
				||beginWord.length() == 0 || endWord.length() == 0||wordList.size() == 0){
			return 0;
		}
		if(beginWord.equals(endWord)){
			return 0;
		}
		Queue<String> q = new LinkedList<String>();
		int level = 1;
		//用来标记一层是否走完了
		int lastWord = 1;
		int currWord = 0;

		q.add(beginWord);
		wordList.remove(beginWord);
		while(!q.isEmpty()){
			
			String temp = q.remove();
			lastWord--;
//			System.out.println("temp :" + temp);
//			System.out.println("in loop!!!!!!!!!!!" );
			
			for(int i = 0; i < endWord.length(); i++){
				char[] arr = temp.toCharArray();

				char ch = arr[i];
				for(char subch = 'a'; subch <= 'z'; subch++){
					

					if(subch == ch){
						continue;
					}
					arr[i] = subch;
					
					String substr =String.valueOf(arr);
					
				
					if(wordList.contains(substr)){
						System.out.println("contained substr :" + substr);
						if(substr.equals(endWord)){
							return level+1;
						}
						else{
							q.add(substr);
							System.out.println("q :" + q);
							currWord++;
							wordList.remove(substr);
						}
					}
				}
			}
			if(lastWord == 0){
				lastWord = currWord;
				currWord = 0;
				level++;
				System.out.println("level :" + level);
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String beginWord = "hit";
		String endWord = "cog";
		Set<String> wordList = new HashSet<String>();
		wordList.add("hot");
		wordList.add("cog");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("hit");
		wordList.add("lot");
		wordList.add("log");

		System.out.println(s.ladderLength(beginWord, endWord,wordList ));

	}

}
