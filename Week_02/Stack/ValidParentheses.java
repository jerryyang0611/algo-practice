Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

class Solution {
    public boolean isValid(String s) {
        // 1. Brute force (replace the char with "" if the prrentheses are matched.) => time consuming.. 
        //  O (N^2) -- time complexity too high..
        // if (s.length() % 2 != 0) return false;
        // for (int i = 0; i < s.length; i++) {
        //     if (s[i] == '(' && s[i+1]==')')  
        // }


        // 2. Use Stack O(N)  
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {    // put the corresponding matching char into stack 
            if (c == '(')   
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || c != stack.pop()) // pop it and compare to the right parenthese ones
                return false;     // if stack is already empty for comparison or it's not euqal -> false.
        }
        return stack.isEmpty();   

        // 3. Stack 2 
        // if(s==null||s.length()%2==1)
        //     return false;
        // Stack<Character> stack = new Stack<>();
        // for(int i=0;i<s.length();i++){
        //     char c = s.charAt(i);
        //     if(c=='['||c=='{'||c=='(')
        //         stack.push(c);
        //     else{
        //         if(stack.isEmpty())
        //             return false;
        //         else if(c==']' && stack.pop()!='[')
        //             return false;
        //         else if(c==')' && stack.pop()!='(')
        //             return false;
        //         else if(c=='}' && stack.pop()!='{')
        //             return false;
        //     }
        // }
        // return stack.isEmpty();
    }
}