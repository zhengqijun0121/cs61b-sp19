import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("1 222 1"));
        assertTrue(palindrome.isPalindrome("&^^&"));
        assertTrue(palindrome.isPalindrome("level"));
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("nhh"));
        assertFalse(palindrome.isPalindrome("12345"));
        assertFalse(palindrome.isPalindrome("&^#@^&"));
        assertFalse(palindrome.isPalindrome("accept"));
    }

    @Test
    public void testIsPalindromeRecursive() {
        assertTrue(palindrome.isPalindromeRecursive(""));
        assertTrue(palindrome.isPalindromeRecursive("a"));
        assertTrue(palindrome.isPalindromeRecursive("noon"));
        assertTrue(palindrome.isPalindromeRecursive("1 222 1"));
        assertTrue(palindrome.isPalindromeRecursive("&^^&"));
        assertTrue(palindrome.isPalindromeRecursive("level"));
        assertFalse(palindrome.isPalindromeRecursive("cat"));
        assertFalse(palindrome.isPalindromeRecursive("nhh"));
        assertFalse(palindrome.isPalindromeRecursive("12345"));
        assertFalse(palindrome.isPalindromeRecursive("&^#@^&"));
        assertFalse(palindrome.isPalindromeRecursive("accept"));
    }

    @Test
    public void testIsPalindrome2() {
        CharacterComparator cc = new OffByN(2);

        assertTrue(palindrome.isPalindrome("", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("cee", cc));
        assertTrue(palindrome.isPalindrome("adrtfc", cc));
        assertFalse(palindrome.isPalindrome("noon", cc));
        assertFalse(palindrome.isPalindrome("12345", cc));
        assertFalse(palindrome.isPalindrome("&^#@^&", cc));
        assertFalse(palindrome.isPalindrome("accept", cc));
    }
}
