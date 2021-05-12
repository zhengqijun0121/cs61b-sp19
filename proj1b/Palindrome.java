public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> chars = wordToDeque(word);
        while (chars.size() >= 2) {
            if (chars.removeFirst() != chars.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeRecursive(String word) {
        Deque<Character> chars = wordToDeque(word);
        return isPalindromeHelper(chars);
    }

    private boolean isPalindromeHelper(Deque<Character> chars) {
        if (chars.size() <= 1) {
            return true;
        } else if (chars.removeFirst() == chars.removeLast()) {
            return isPalindromeHelper(chars);
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int n = word.length() / 2;
        Deque<Character> chars = wordToDeque(word);
        for (int i = 0; i < n; i++) {
            char first = (char) chars.removeFirst();
            char last = (char) chars.removeLast();
            if (!cc.equalChars(first, last)) {
                return false;
            }
        }
        return true;
    }
}
