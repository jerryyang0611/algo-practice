You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.

1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45


class Solution {
    public int climbStairs(int n) {
        // Find the minimum repetitive pattern (找最近重複子問題，切記別太遠) // 

        // Option 1: Fibonacci series: f(n) = f(n-1) + f(n-2) --> overtime 超時.. (X)
        // if (n == 0 || n == 1) 
        //     return 1;
        // else    
        //     return climbStairs(n-1) + climbStairs(n-2);

        // Option 2: Only keep the record of last three numbers and upate each time, no need an array to store all history. 
        if (n<=2) return n;
        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}