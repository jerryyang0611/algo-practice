Given two strings a and b, return true if you can swap two letters in a so the result is equal to b, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at a[i] and b[j]. For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

Example 1:

Input: a = "ab", b = "ba"
Output: true
Explanation: You can swap a[0] = 'a' and a[1] = 'b' to get "ba", which is equal to b.
Example 2:

Input: a = "ab", b = "ab"
Output: false
Explanation: The only letters you can swap are a[0] = 'a' and a[1] = 'b', which results in "ba" != b.
Example 3:

Input: a = "aa", b = "aa"
Output: true
Explanation: You can swap a[0] = 'a' and a[1] = 'a' to get "aa", which is equal to b.
Example 4:

Input: a = "aaaaaaabc", b = "aaaaaaacb"
Output: true
 

Constraints:
1 <= a.length, b.length <= 2 * 104
a and b consist of lowercase letters.


// ------------- Code ---------------

class Solution {
    public boolean buddyStrings(String a, String b) {
        // two pointers.
        if (a.length() != b.length()) return false;
        // edge case
        // consider 'a', 'a' => false & 'aaaaa','aaaaa' => true, 'ababab', 'ababab'    
        
        if (a.equals(b)) {
            Set<Character> unique_chars = new HashSet<>();
            for (char c : a.toCharArray()) {
                unique_chars.add(c);
            }
            return  unique_chars.size() < a.length() ? true : false;   // for 'a' 'a' => false checking...  
        } 

        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff.add(i);
            }
        }

        // do some checking -> consider :  "abcaa", "abcbb" ==> false, "ab", "bc" ==> false.
        return (diff.size() == 2 && 
                a.charAt(diff.get(0)) == b.charAt(diff.get(1)) && 
                b.charAt(diff.get(0)) == a.charAt(diff.get(1))) ? true : false;   
    }
}