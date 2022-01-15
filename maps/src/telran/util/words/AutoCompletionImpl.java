package telran.util.words;
import java.util.*;
public class AutoCompletionImpl implements AutoCompletion {
	private TreeSet<String> words = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
 public AutoCompletionImpl() {
		
	}
 public AutoCompletionImpl(Collection<String> collection) {
		words.addAll(collection);
	}
 
	@Override
	public boolean addWord(String word) {
		
		return words.add(word);
	}

	@Override
	public boolean removeWord(String word) {
		
		return words.remove(word);
	}

	@Override
	public Iterable<String> getCompletionOptions(String prefix) {
		
		return words.subSet(prefix, getPrefixLimit(prefix));
	}
	// V.R. Code duplication! The same code is used by AutoCompletionMapImpl.
	// The ways to prevent code duplication were discussed at the last webinar
	public   String getPrefixLimit(String prefix) {
		char lastChar = prefix.charAt(prefix.length() - 1);
		char limitChar = (char) (lastChar + 1);
		return prefix.substring(0, prefix.length() - 1) + limitChar;
	}

}