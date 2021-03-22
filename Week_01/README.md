学习笔记
Week 1 Note: 

Just start reveiwing arraylist and more. 

1. MoveZero.java

2. ContainerWithMostWater.java

3. ClimbingStairs.java  
-- 1. Fibonacci series (overtime ... dont do this....)  
-- 2. only record the last three nums of steps f1, f2, f3   

4. twoSums.java (easier version of 3Sum)  
-- 1. double for loop iterate through  
-- 2. Hashmap ...  

5. 3Sum.java
 - two pointers 

6. ImplementStrStr

<center>
<img src="https://pic.leetcode-cn.com/Figures/28/substrings.png">	
</center>

* Option 1 - for loop + substring()

### 复杂度分析

	* 时间复杂度：O((N - L)L)，其中 N 为 haystack 字符串的长度，L 为 needle 字符串的长度。内循环中比较字符串的复杂度为 L，总共需要比较 (N - L) 次。
	* 空间复杂度：O(1)

7. Valid Parantheses  
-- Use Stack

8. Remove Duplicates from Sorted Array  
-- Two pointers 

9. mergeSortedArray  
-- three pointers (從後面遍歷) in-place, no need extra space

10. reverseLinkedList  
> Iteration: [Solution](https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/)  

##### 复杂度分析

	* 时间复杂度：O(n + m)O(n+m)，其中 nn 和 mm 分别为两个链表的长度。因为每次循环迭代中，l1 和 l2 只有一个元素会被放进合并链表中， 因此 while 循环的次数不会超过两个链表的长度之和。所有其他操作的时间复杂度都是常数级别的，因此总的时间复杂度为 O(n+m)O(n+m)。
	* 空间复杂度：O(1)O(1)。我们只需要常数的空间存放若干变量。

> Recursion: [Solution](https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484467&idx=1&sn=beb3ae89993b812eeaa6bbdeda63c494&chksm=9bd7fa3baca0732dc3f9ae9202ecaf5c925b4048514eeca6ac81bc340930a82fc62bb67681fa&scene=21#wechat_redirect)
##### 复杂度分析
	* 时间复杂度：O(n + m)O(n+m)，其中 nn 和 mm 分别为两个链表的长度。因为每次调用递归都会去掉 l1 或者 l2 的头节点（直到至少有一个链表为空），函数 mergeTwoList 至多只会递归调用每个节点一次。因此，时间复杂度取决于合并后的链表长度，即 O(n+m)O(n+m)。

	* 空间复杂度：O(n + m)O(n+m)，其中 nn 和 mm 分别为两个链表的长度。递归调用 mergeTwoLists 函数时需要消耗栈空间，栈空间的大小取决于递归调用的深度。结束递归调用时 mergeTwoLists 函数最多调用 n+mn+m 次，因此空间复杂度为 O(n+m)O(n+m)。

11. PalindromeLinkedList  
> 1. Two pointers, store the linked list in a new arraylist first, then reverse it and compare.
> 2. Recursion
> 3. Slow, fast pointer. reversed the second half of the linkedlist and compare each node through iteration.

12. [removeLinkedListElement](./linkedList/removeLinkedListElement.java)  
> 1. Iteration
> 2. Recursion

13. [removeDuplicateFromSortedArray](./linkedList/removeDuplicateFromSortedArray.java)
> 1. Two pointers  
> 2. Hash Set

