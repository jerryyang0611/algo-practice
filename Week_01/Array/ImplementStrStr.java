// Implement strStr().

// Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

// Clarification:

// What should we return when needle is an empty string? This is a great question to ask during an interview.
// For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().


// Example 1:

// Input: haystack = "hello", needle = "ll"
// Output: 2
// Example 2:

// Input: haystack = "aaaaa", needle = "bba"
// Output: -1
// Example 3:

// Input: haystack = "", needle = ""
// Output: 0
//  
// Constraints:
// 0 <= haystack.length, needle.length <= 5 * 104
// haystack and needle consist of only lower-case English characters.



// Option 1 : indexOf() (use built-in function)
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}


// Option 2: sliding Windows. (use built-in function: substring())
class Solution {
  public int strStr(String haystack, String needle) {
    int L = needle.length(), n = haystack.length();

    for (int start = 0; start < n - L + 1; ++start) {
      if (haystack.substring(start, start + L).equals(needle)) {
        return start;
      }
    }
    return -1;  // 都沒找到 return -1 
  }
}

class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length()-needle.length()+1; i++){
            if (haystack.substring(i,i+needle.length()).equals(needle)) return i;
        }
        return -1;
    }
}


// Option 3: brute force. two pointers

class Solution {
  public int strStr(String haystack, String needle) {
    for (int i = 0; ; i++) {
      for (int j = 0; ; j++) {
        if (j == needle.length()) return i;
        if (i + j == haystack.length()) return -1;
        if (needle.charAt(j) != haystack.charAt(i + j)) break;
      }
    }
  }
}

// or 

class Solution {
  public int strStr(String haystack, String needle) {
    if (haystack == null || needle == null)
      return -1;
    
    for (int i = 0; i < haystack.length() - needle.length() + 1; i++){
      int count = 0;
      while (count < needle.length() && haystack.charAt(i+count) == needle.charAt(count)){
          count++;
      }
      if (count == needle.length()) return i;
    }
    return -1; 
  }
}


