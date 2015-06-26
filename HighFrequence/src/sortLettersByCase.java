/*
 * Given a string which contains only letters. Sort it by lower case first and upper case second.
Example

For "abAcD", a reasonable answer is "acbAD"
Note

It's not necessary to keep the original order of lower-case letters and upper case letters.
Challenge

Do it in one-pass and in-place.

 */
public class sortLettersByCase {
	/** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        if (chars == null || chars.length == 0)
            return;
        int small = 0;
        int large = 0;
        while (true) {
            while (large < chars.length && !isUpper(chars[large]))
                large++;
            small = large+1;
            while (small < chars.length && isUpper(chars[small]))
                small++;
            if (small < chars.length && large < chars.length)
                swap(chars, small, large);
            else
                break;
        }
        return;
    }
    private boolean isUpper(char c) {
        if (c - 'a' >= 0 && c-'a' < 26)
            return false;
        else
            return true;
    }
    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
