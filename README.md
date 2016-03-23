#leetcode
001_Medium: Two Sum.利用哈希表（在O(1)时间复杂度内查找某个元素）。遍历数组，查找map里是否containsKey(target-nums[i])，如果则返回，否则将nums[i]放入map中(map.put(nums[i],i)。

002_Medium: Add Two Numbers。 用链表存储的两个数相加，逐位相加，记得进位。。

003_Medium: Longest Substring Without Repeating Characters. 最长无重复字串。运用滑动窗口法，也可运行HashMap. 设置数组a(长度大于ASCII个数)，ASCII第一位是' '。双指针遍历数组，移动前指针，判断a[s.charAt-' ']的值：

> true;遇到重复，移动后指针，逐位设置false,直到a[s.charAt(i)-' ']==false;

> false;设置a[s.charAt(i)-' ']=true,前指针前进。

004_Hard: Median of Two Sorted Arrays

Assume that the number of elements in A and B are both larger than k/2, and if we compare the k/2-th smallest element in A(i.e. A[k/2-1]) and the k-th smallest element in B(i.e. B[k/2 - 1]), there are three results:
(Becasue k can be odd or even number, so we assume k is even number here for simplicy. The following is also true when k is an odd number.)

> A[k/2-1] = B[k/2-1]

> A[k/2-1] > B[k/2-1]

> A[k/2-1] < B[k/2-1]

if A[k/2-1] < B[k/2-1], that means all the elements from A[0] to A[k/2-1](i.e. the k/2 smallest elements in A) are in the range of k smallest elements in the union of A and B. Or, in the other word, A[k/2 - 1] can never be larger than the k-th smalleset element in the union of A and B.

Why?
We can use a proof by contradiction. Since A[k/2 - 1] is larger than the k-th smallest element in the union of A and B, then we assume it is the (k+1)-th smallest one. Since it is smaller than B[k/2 - 1], then B[k/2 - 1] should be at least the (k+2)-th smallest one. So there are at most (k/2-1) elements smaller than A[k/2-1] in A, and at most (k/2 - 1) elements smaller than A[k/2-1] in B.So the total number is k/2+k/2-2, which, no matter when k is odd or even, is surly smaller than k(since A[k/2-1] is the (k+1)-th smallest element). So A[k/2-1] can never larger than the k-th smallest element in the union of A and B if A[k/2-1]<B[k/2-1];
Since there is such an important conclusion, we can safely drop the first k/2 element in A, which are definitaly smaller than k-th element in the union of A and B. This is also true for the A[k/2-1] > B[k/2-1] condition, which we should drop the elements in B.
When A[k/2-1] = B[k/2-1], then we have found the k-th smallest element, that is the equal element, we can call it m. There are each (k/2-1) numbers smaller than m in A and B, so m must be the k-th smallest number. So we can call a function recursively, when A[k/2-1] < B[k/2-1], we drop the elements in A, else we drop the elements in B.


We should also consider the edge case, that is, when should we stop?

> 1. When A or B is empty, we return B[k-1]( or A[k-1]), respectively;

> 2. When k is 1(when A and B are both not empty), we return the smaller one of A[0] and B[0]

> 3. When A[k/2-1] = B[k/2-1], we should return one of them

大意：更普遍的情况是找第K小的元素，每次比较 A[k/2-1]和B[k/2-1]，较小的那个(i.e. 是A[k/2-1]<B[k/2-1]),那么A[k/2-1]必定在前K个元素中，因此可以把A的前K/2个元素扔掉，递归寻找剩余数组的第(K-K/2)个元素；同时B中B[K/2-1]之后的元素肯定不在前K个元素中，因为已经至少有K个元素比他小，因此可以把这部分一同扔掉。

注意边界情况。

005_Mesium:最长回文。用简单的二维DP，isPa[i][j]表示s.substring(i,j+1)是否是回文，isPa[i][i]=true,递推式如下：

    isPa[i][j] = s.charAt(i) == s.charAt(j) && (i+1 >= j-1 || isPa[i+1][j-1])
    
006_Easy:ZigZag.参考dicuss，用二维stringBuffer存储，具体见代码。

007_Easy: 反转整数，注意负号和Integer的溢出，反转公式如下：

    while(x != 0){
    re = (re*10 + x%10);
    x /= 10;
    }
    
008_Easy: String to Integer (atoi). 注意各种情况的处理。

009_Easy: Palindrome Number. 不用额外的空间判断数字是否是回文，每次读取最后一位和第一位比较，注意每次base/=100

010_Hard:Regular Expression Matching. 比较难想到的一道dp。注意的是*表示前一个字符可以重复n次(n>=0)。大部分注释已经写在代码中，其中比较难理解的就是当 p(j)=='*'时，分两种情况，1：p(j)前一个字符重复0次，则是a[i+1][j-1] ; 2： p(j)前一个字符重复大于等于1次，设x=p(j)，则p可以变成...x*x,后一个x表示至少一次，前面的x*又可以表示重复n次(n>=0)，递归的过程。则a[i][j+1] && (s(i) == x || x == '.')。这是本题目的精妙之处。

011_Medium:Container With Most Water. 假设使得体积最大的两处分别为i和j(i<j)，那么根据反证法能够证明在i的左边的值都比height[i]小，而在j的右边的值都比height[j]小，所以可以设置两个指针，不断向中间靠拢来寻找最大值。

012_Medium:Integer to Roman. 数字装成罗马数字，依稀记得这是ebay的电面题。设置String [] a = {"I","V","X","L","C","D","M"};每次去int数字的最后一位，判断是0——9的哪一个，分别用a[i],a[i+1],a[i+2]的组合表示，然后i+=2继续处理下一位。

013_Easy:Roman to Integer. 罗马数字转数字。遇到一个字符，加上这个字符对应的数字，但是要注意有些情况是要减的，比如遇到‘I’，要判断下一位，如果是‘V’或者‘X’的话就要减，其余情况则+1。

014_Easy:Longest Common Prefix.省略

015_Medium: 3Sum.给定数组，求所有任意三个数相加等于0的组合。先排序，用O(nlogn)的时间，在固定某一位，用双指针查找另外两个数，这部分的复杂度是O(n^2)。

016_Medium:3Sum Closest. 类似上题。

017_Medium:Letter Combinations of a Phone Number. 典型dfs.

018_Easy: 4Sum. 类似015，只是每次要固定2个数，时间复杂度是O(n^3)

019_Easy: Remove Nth Node From End of List. 移除倒数第N个节点。第一个节点先走N步，然后，另一个指针指向头部，同时移动两个指针，找到倒数第N个节点的前一个节点，用pre.next = pre.next.next移除。

020_Easy: Valid Parentheses. 判断括号组合的合法性。栈的典型应用。

021_Easy: Merge Two Sorted Lists. 归并排序的基本原理。

022_Medium:Generate Parentheses. dfs+剪枝。递归生成添加左右，当l==n表示后面只能添加")"了，当l>r表示下一个可以是"("也可以是")"，l<=r表示下一个只能是"("。

023_Hard: Merge k Sorted Lists. 归并排序在链表中的应用。

024_Medium:Swap Nodes in Pairs. 链表中每两个一组交换，考察链表的操作。

025_Hard: Reverse Nodes in k-Group。每k个一组进行反转。注意边界,细节等处理就行。

026_Easy: Remove Duplicates from Sorted Array. 移除已排序数组中的重复元素。这题用双指针思想，用i遍历数组，j在0到i之间，满足[0...j-1]不重复，而[j...i]的元素是需要被移除的，由于是已排序的[0...j-1]的，所以每次遍历到i，比较nums[j-1]和nums[i]是否相等，相等表示nums[i]是重复的，不操作；不相等表示nums[i]不是重复的，进行nums[j++]=nums[i]操作，即把nums[i]放到nums[j]的位置，并j++。

027_Easy: Remove Element. 移除数组中的指定元素，和上题一样，利用双指针。

028_Easy: Implement strStr(). 1：暴力法。2：KMP算法，没有彻底研究明白，有空继续研究那个next数组的生成。[http://www.cnblogs.com/c-cloud/p/3224788.html]

029_Medium: Divide Two Integers.In this problem, we are asked to divide two integers. However, we are not allowed to use division, multiplication and mod operations. So, what else can we use? Yeah, bit manipulations.

Let's do an example and see how bit manipulations work.

Suppose we want to divide 15 by 3, so 15 is dividend and 3 is divisor. Well, division simply requires us to find how many times we can subtract the divisor from the the dividend without making the dividend negative.

Let's get started. We subtract 3 from 15 and we get 12, which is positive. Let's try to subtract more. Well, we shift 3 to the left by 1 bit and we get 6. Subtracting 6 from 15 still gives a positive result. Well, we shift again and get 12. We subtract 12 from 15 and it is still positive. We shift again, obtaining 24 and we know we can at most subtract 12. Well, since 12 is obtained by shifting 3 to left twice, we know it is 4 times of 3. How do we obtain this 4? Well, we start from 1 and shift it to left twice at the same time. We add 4 to an answer (initialized to be 0). In fact, the above process is like 15 = 3 * 4 + 3. We now get part of the quotient (4), with a remainder 3.

Then we repeat the above process again. We subtract divisor = 3 from the remaining dividend = 3 and obtain 0. We know we are done. No shift happens, so we simply add 1 << 0 to the answer.

Now we have the full algorithm to perform division.

According to the problem statement, we need to handle some exceptions, such as overflow.

Well, two cases may cause overflow:

divisor = 0;
dividend = INT_MIN and divisor = -1 (because abs(INT_MIN) = INT_MAX + 1).
Of course, we also need to take the sign into considerations, which is relatively easy.

简单来说，不断的去减去被除数，知道除数小于被除数，但是这样会超时，所以用*2的方法，每一次都把被除数*2后再用除数减，发现减不了了再从原始除数开始，知道最后的除数小于被除数。

030_Hard: Substring with Concatenation of All Words. 双指针高阶应用，注意题目要求，一开始用dfs虽然能做出来但是会超时。题目说words中每个word长度相等，因此遍历时每次跳跃word.length()步即可。两个循环：

> 外层循环：为什么外层循环只要循环单词长度就行？其实这里就是从一个元素出发，然后我们会对固定长度的单词依次扫过去，既然这样，那么只需要扫单位长度次就够了，举个例子可能比较好理解，比如abcdefghijklmn, 长度是3， 那么从a出发，我们会扫abc, def,ghi,jkl, 接下来从b出发，是bcd,efg,hij,klm,然后是从c出发，是cde, fgh, ijk, lmn. 如果接下来继续，从d出发，是def,ghi,jkl,可以发现扫a的时候已经判断过这些单词了~ 所以就不需要再跑一次了哈~

> 内层循环：固定left，依次找s.substring(left,left+len),s.substring(left+len,left+2*len)...,当发现某个子串如s.substring(left+k*len,left+(k+1)*len),不在words里时，要重置count=0;left = left+(k+1)*len);curMap.clear();这三项，表示要充头开始找；重点来了，和双指针应用一样，当发现子串s.substring(left+k*len,left+(k+1)*len)超过已找到的个数时，即当前窗口一旦出现重复某个单词的次数超出指定的个数，移动左窗口，直到该窗口中对应的字符串不在重复超过指定次数。

031_Medium:Next permutation. 找到全排列的下一个组合。网上的思路：

> Start from its last element, traverse backward to find the first one with index i that satisfy num[i-1] < num[i]. So, elements from num[i] to num[n-1] is reversely sorted.

> To find the next permutation, we have to swap some numbers at different positions, to minimize the increased amount, we have to make the highest changed position as high as possible. Notice that index larger than or equal to i is not possible as num[i,n-1] is reversely sorted. So, we want to increase the number at index i-1, clearly, swap it with the smallest number between num[i,n-1] that is larger than num[i-1]. For example, original number is 121543321, we want to swap the '1' at position 2 with '2' at position 7.

> The last step is to make the remaining higher position part as small as possible, we just have to reversely sort the num[i,n-1]

总结一下：找到下一个排序更大的组合，首先从后往前找，直到出现降序的（如果从后往前是升序，则表示是最大的，如4，3，2，1）,找到第一个降序的位置nums[i] < nums[i+1]，这里表示[i+1...n-1]是降序了，在这里我们从[i+1...n-1]中找到大于nums[i]的最小元素和nums[i]交换，然后把[i+1...n-1]反转，表示[i+1...n-1]这部分变成最小了。

032_Hard:Longest Valid Parentheses.题意是给定一个只含有(和)的字符串，找到最长的合法的长度。这题有三种方法，分别是栈，数组标记（自己起的名字）和逆向动态规划法。下面分别介绍思路：

> 1:类似递增栈那一类题，stack存储上一个没匹配括号的index，遍历每个字符，发现栈顶的元素可以匹配当前括号，即为一对，否则再把当前括号入栈，作为未匹配的上一个index，以此类推。更新的时候如果stack为空，那么从头至尾所有的括号都匹配上，否则有效长度仅限i-stack.peek()。

> 2:用一个bool数组来标记已经匹配过的字符，找到最长的连续标记的长度就是所求的结果。只要遍历两遍数组，时间复杂度为O(n)。

> 3:dp[i]: 以i开头的最长valid parentheses有多长。1) 如果(str[i] == ‘)’)，以右括号开头必定invalid，dp[i] = 0；2) (str[i] == ‘(‘)，以左括号开头,我们想看对应的有木有右括号。因为dp[i + 1]代表的sequence肯定是左括号开头右括号结尾，所以我们想catch((…))这种情况。j = i + 1 + d[i + 1]，正好就是str[i]后面越过完整sequence的下一个，若是右括号，d[i] = 2 + d[i + 1]. 除此之外，还有包起来后因为把后面的右括号用了而导致跟再往后也连起来了的情况，如((..))()()()。所以d[i]还要再加上j后面那一段的d[j + 1]
这个定义和最长公共字串那题的定义类似，都是“以某个固定位置开始/结束”。看两头的方式又像palindrome。从后往前的一维dp也不常见。挺好玩的，一下复习好多东西。

033_Hard: Search in Rotated Sorted Array.二分查找。比如一个例子，4 5 6 7 0 1 2。每次取mid=l+(r-l)/2。

> nums[l]<nums[r]，正常二分查找。

> nums[mid]<nums[r], 如数组中的nums[mid] == 1。这是判断如果nums[mid]<target<=nums[r],则l=mid+1，否则r=mid-1。

> nums[mid]>=nums[r], 如数组中的nums[mid] == 6。这时判断如果nums[l]<=target<nums[mid],则r=mid-1，否则l=mid+1。

034_Medium: Search for a Range. 给定一个已经排序的数组和一个数字，找到这个数字在数组的位置区间，要求O(logn)。两种方法:

1):用两次二分查找，分别查找左边界和右边界，巧妙运行了当target==nums[mid]时该怎么移动。当寻找左边界时，如果target<=nums[mid]时，令j=mid,确保左边界还在搜索区间内，否则i = mid+1;当寻找右边界时，要注意的是，如果while(i<j)这样的话，如果j-i==1的话，出现i==mid时会造成死循环，所以应该令mid=i+(j-i)/2+1，向右偏一个，如果target>=nums[mid]时，令i = mid，使得右边界仍然在搜索区间，否则j = mid-1;

2): 思路差不多，先用二分查找找到第一个target == nums[mid], 然后在用两个二分区搜[i,mid]的左边界和[j,mid]的右边界。

035_Medium: Search Insert Position. 找一个有序数组中找到给定数字的下表，找不到的话返回这个数字插入到该数组对应位置的下标。思路：基本的二分搜索，注意，当target>nums[length-1]是，直接返回length。

036_Easy: Valid Sudoku. 判断数独是否合法。按照数独规则判断即可。

037_Hard: Sudoku Solver. 解数独。这题是唯一没有自己写的，觉得很麻烦，方法是暴利回溯。

038_Easy: Count and Say. 从1开始，对这个字符窜计数并说。理解题目之后简单的遍历统计即可，值得一提的是，用String会超时，要用StringBuilder tmp = new StringBuilder() --> tmp.append(t) --> tmp.toString()

039_Medium: Combination Sum. 给定一个数组和一个target数字，找到数组中所有子数组可能的组合，使得子数组的和等于target，每个元素可使用无限次，结果按照升序排列。思路，回朔法。有两个版本的，第一个版本比第二个快好多。对于每个元素，选择放，放一个，放两个。。。，然后再扔给下一元素。

040_Medium: Combination Sum II. 承接上题，要求每个元素只能出现一次，且不能有重复的序列。如果只有前面一个要求，那么在上题中的dfs中

    for(int j = i;j < c.length;j++){
      tmp.add(c[j]);
      dfs(j,c,target-c[j],tmp,re);
      tmp.remove(tmp.size()-1);
    }  

把dfs中的j改成j+1，去 搜索下一个就好，但是如果原数组中有重复的数字，那么这样搜索就会有重复的，如c=[1,1],target=1,结果会有两个1. 要避免重复结果的出现，要在for循环中判断一下，假设j = i+1, 然后有c[j] == c[i]，能够到达这一步，表示在这个函数中，c[i]没有放进来，那么c[j]也不应该放进去（原因时在前前的dfs中肯定出现了10这样的情况，现在不能出现01），故应该continue掉.代码如下：

    for(int j = i;j < c.length;j++){
      if(j != i && c[j] == c[j-1]) continues;
      tmp.add(c[j]);
      dfs(j+1,c,target-c[j],tmp,re);
      tmp.remove(tmp.size()-1);
    }

补充，有效利用数组升序进行剪枝，在dfs中加入：

    if(target - c[j] < 0){
        break;
    }

这样会更快。

041_Hard: First Missing Positive.给定一个数组，找到缺失的第一个正数。要求O(n)时间复杂度和O(1)空间复杂度。思路：遍历数组，把nums[i](如果1<=nums[i]<=nums.length)放在nums[i]-1的位置，如nums[i]=4,应该把其放到i=3的位置，具体为exchange num[i] and nums[nums[i]-1],i--,为了防止重复交换，当且仅当nums[nums[i]-1]这个数不满足nums[k]-1=k 这个性质时才执行。

042_Hard: Trapping Rain Water.给定一个数组，表示柱子的高度，柱子的长度为1，整体往下灌水，问能够存储多少水。思路：判断当前位置i能存储多少水，其实就是向左上一个最大的数，再向右找一个最大的数，取两个中小的那个，用这个数减去自己的高度，小于等于0表示无法注水，否则注水量为Math.min(left[i],right[i])-height[i]，根据这个思路写出了我自己的方法。时间复杂度是O（2n）,空间复杂度为O（2n）；还可以优化，对于某个位置i，如果找左右两边的最大值当中的较小一个，可以设两个指针，向中间靠拢,另i=0，maxleft=height[0]，j=n-1,rightleft=height[n-1]，对于位置i和j，加入nums[i]<= nums[j]，由于左指针能够到达i这个位置（i能向前走说明nums[t] <= nums[k],0<t<i;n>k>j），leftmax为前i-1个的最大值，其中每一个值都能在[j,n-1]找到一个比它大的值，而rightmax是[j,n-1]中最大的，所以推出此时leftmax<=rightmax，因此已经可以判断左右两边的最大值中最小值是leftmax，因此sum += height[i]-leftmax，即可；如果nums[j]< nums[i]也是同理。

043_Medium: Multiply Strings.两个数相乘，如果按照乘法模拟运算的话比较复杂，注意技巧就是建立个n1+n2长度的数组存结果，然后倒数第i位数字乘以倒数第j位数字乘的结果是保存在数组i+j位，最后再统一进位，详见代码。

044_Hard: Wildcard Matching.两个字符串匹配，？匹配任意一个字符，*匹配0个或多个字符。两种方法：1，动态规划 ，2 贪心算法

1）动态规划，建立boolean数组isM[][],其中isM[i+1][j+1]表示[0...i]和[0...j]是否匹配，最后返回isM[n][m]。那么如何判断isM[i+1][j+1]呢？当p[j]==‘？’时，s[i]匹配p[j]成功，则isM[i+1][j+]=isM[i][j]；当p[j]=='*'时，关键来了，p[j]可以匹配任意多的字符，直观来说，要让[0...j-1]去匹配[0...0],[0...1]....[0...i-1],[0...i]这么多个一个，只要一个匹配成功即可，如果写个循环一个个找也行，会很慢。转换一下思路，isM[i+1][j]表示让p[j]匹配0个，而isM[i][j+1]表示[0...i-1]匹配[0...j+1]的结果，此时如果为true，表示已知p[j]匹配了0个或多个，在把s[i]匹配进来，就表示匹配一个以上了。因此把两种情况合在一起，就有isM[i+1][j+1]=isM[i+1][j]||isM[i][j+1]。

关于初始化，isM[0][0]=true表示空匹配空，isM[i][0]=false 0<i<=n 表示空的p不能匹配非空的s。isM[0][j]=true p[0...j-1]全为*。

2）贪心算法，解释在代码里，这种方法更快。大概就是两个指针同时找，当找到*时，记录下它胡位置，在以后胡过程中，如果遇到无法匹配的，就用这个*去匹配.当找到多个*,用最近找到胡那个。

045_Hard: Jump Game II. 一个数组，每个数字表示能够向前跳跃的最大距离。用dp能够在O(n^2)的时间复杂度解决，但是需要更快的方法。思路是一种类似bfs的思想，特殊情况处理好之后，设置两个指针last,cur，表示,一开始last=cur=nums[0]，step = 1,表示走一步的范围是0~last，然后让i从1遍历到last,1<=i<=last，这其中如果有i+nums[i]能够到达n-1的话，马上返回step+1,期间也不能更新最远的cur；当i>last时，表示i之后都无法step步走到，所以step++,并把last=cur，其中旧的last和新的last之间的位置是新的step步才能到达的，而此时的last表示step步最远能够到达的位置。说的不太清楚，附上官网最hot的分析：

I try to change this problem to a BFS problem, where nodes in level i are all the nodes that can be reached in i-1th jump. for example. 2 3 1 1 4 , is 2|| 3 1|| 1 4 ||

clearly, the minimum jump of 4 is 2 since 4 is in level 3. my ac code.

046_Medium_Permutations：生成数组全排列。递归遍历数组，每一次对于nums[i],分别于nums[i]...nums[n-1]进行交换，递归下去，出来之后记得回溯，就是递归结束后要交换回来。

047_Medium：PermutationsII：生成不重复的全排列。大体思路和上题一样，唯一不同的是，在nums[i]与它后面的元素交换时，不能重复交换，如1,3,4,4,3,2这个数组，i==1时,3之和j==1,j==2,j==5这三个交换。

048_Medium: Rotate Image. 顺时针旋转n*n的矩阵，要求in-place操作。思路：自己的方法很土，最外层转一次，然后再倒数第二外层再转....网上的思路很好，先进行转置操作(交换matrix[i][j]和matrix[j][i])，然后，如果是顺时针，则竖直对换，第一列和最后一列换，第二列和倒数第二列换...
逆时针则是水平对换。

1  2  3        1  4  7        7  4  1
4  5  6  --->  2  5  8  --->  8  5  2
7  8  9        3  6  9        9  6  3

049_Medium: Group Anagrams. 给一个数组，把具有相同字母的元素聚合成一组在一起返回，每组的元素按字典排序。思路：由于要求每组组内要有序，所以可以先将原始数组排序，在遍历，这样，逐个加入不同组后每组也就有序了。关于比较两个元素是否含有相同的字母，可以将其分别排序，如果相等，则表示它们含有相同字母。

050_Medium: Pow(x, n).求x的n次方. 用二分的思想，递归求解val = Pow(x,n/2),然后再val*val，如果n是奇数，则要再乘以x。注意，如果n是负数，应该把x变成1/x,把n变成-n。

051_Hard: N-Queens. N皇后问题，典型的回朔算法。

052_Hard: N-Queens II. 返回N皇后问题解的个数。以为会有很好的方法，但是直接用上一题的回朔，每次找到count++就行了。

053_Medium: Maximum Subarray. 求最大连续字数组和。思路：

典型动态规划，用maxSum[i]记录以i结尾的最大字数组和，显然,当sumMax[i-1]<0，那么sumMax[i]就是自己，否则，就是sumMax[i-1]+nums[i].由于sumMax[i]只与sumMax[i-1]相关，因此空间复杂度可优化为O(1).

分治法：一份为2，递归左边求一个，递归右边求一个，包含中间的求一个,三个取最大的。

054_Medium:	Spiral Matrix. 环形输出矩阵。思路，环形输出矩阵。

055_Medium:	Jump Game. 跳跃游戏。给定一个数组，每个值表示能够向前跳跃多远。思路：简单的动态规划。用max记录能够跳的最远的距离。用i遍历数组，若i < max，表示无法跳到这，返回false；否则用i+nums[i]更新一些。注意，用Math函数的话会超时，要用if判断 if(i+nums[i] > max) max = i+nums[i];

056_Hard:Merge Intervals。合并多个区间。[1,5],[2,8] => [1,8]。思路：用归并排序，关键是如何合并两个指定的区间，根据它们的start和end来判断。

057_Hard: Insert Interval. 在一个已排序的区间内插入一个区间，必要时要合并区间。先找到要插的位置，插入后再合并，注意要复制所有的。

058_Easy: Length of Last Word. 最后一个字的长度。实现题，详见代码。

059_Medium:Spiral Matrix II.从1到n^2生成环形矩阵。

060_Medium: Permutation Sequence. 1->n的全排列，是有顺序的，给定n和k，共有1->n的全排列共有n!个，返回第k个。思路：一开始看到n<9的条件，以为用暴力法，挨个找全排列可以通过，没想到超时，这里应该用更巧妙的方法。举个栗子：3的全排列：123,132,213,231,312,321.建立一个升序数组[1,2,3]若只看第1位，以1开头的有2!个数，以2和3开头的也是2!。因此，给定k，那么第1位是多少，有莫有很快的方法。给定k，令k--,第一位就是k/(n-1)!,这很容易发现；k在[1,2]之间，开头是1;k在[3,4]之间，开头是2;k在[5,6]之间，开头是3。接下来，确定了第1位后，把这个数字拿走，在剩下的数全排列，令k = k%(n-1)!, 继续下一步判断。详见代码。

061_Medium: Rotate List. 旋转链表，向右旋转k位。注意首先要把k%length.

062_Medium: Unique Paths. 给一片方格，从左上角出发，问有多少路径到右下角。两种方法，思路：1）经典dp：nums[i][j] = nums]i-1][j]+nums[i][j-1]  比较慢。 2） 公式法，一共要走m+n-2步，其中要向右走n-1步，根据高中的排列组合知识，总共的选择有C(m+n-1,n-1)种方法，等于(m+n-2)!/(m-1)!*(n-1)! = (n+m-2)*...*(n+0)/(m-1)*...*1. 可用一个O(m)的时间求出，但是注意的是要用double，最后还有使用Math.round(total)才能过。

063_Medium:Unique Paths II. 承接上题，有些格子有障碍物不能通过，在这种情况下求总共的路径数。思路：不能用公式法，只能用dp。

064_Medium:	Minimum Path Sum。承接上题，每个方格有个数字，请和最小的路径。经典dp，记得算法考试考过这题。

065_Hard: Valid Number. 判断一个字符串是否是合法的数字，其中包括符号-,+,.,e,0-9.这道题还是很烦的，要考虑各种情况。

066_Easy: Plus One. 数字以char数组的形式。思路，从后往前，找到第一个不等于9的数，把后面的数设置为0，这个数加1.

067_Easy: Add Binary. 两个二进制数相加。我的思路是，用短的加上大的，考虑进位，这题比较简单。

068_Easy: Text Justification. 这题好烦，题意说不清，把一堆字符串张开。这里注意好多细节，包括怎么分组，我这里是用到，如果sum+j-i<maxWidth,则到i到j-1为一组，因为每个元素之前至少保留一个位置。还有就是怎么处理如果多余的空格应该放在左边，通过逻辑l = empty/tmp; empty-l;tmp--;

069_Medium:	Sqrt(x).求d的平方根。思路：典型的二分查找。要注意的是求mid*mid时要用double类型的，不然会越界变成负数。

070_Easy:Climbing Stairs. 爬楼梯问题，每次只能爬一个台阶或2个台阶，问爬到n层有多少种爬法。思路：简单的动态规划。递归式：dp[i]=dp[i-1]+dp[i-2]

071_Medium: Simplify Path. 类似linux的文件路径，其中可能出现.或者..的情况。思路，首先用split("/")把path分成数组，遍历数组，遇到.跳过，遇到..删除上一个有效的目录，否则，添加一个有效的目录。

072_Hard: Edit Distance.动态规划问题，设二维数组dp[n+1][m+1]，dp[i+1][j+1]表示word1(0...i)到word2(0...j)需要的最小具体，当word1[i]==word2[j]时，dp[i+1][j+1]=dg[i][j]；否则，dp[i+1][j+1] = min(dp[i+1][j],dp[i][j+1],dp[i][j])+1. 其中，dp[i+1][j]+1表示在word1最后插入word2中最后一个字符；dp[i][j+1]+1表示在word1中删除最后一个字符；dp[i][j]+1表示将word1的最后一个字符替换成word2最后一个字符.

073_Medium:Set Matrix Zeroes. 对于一个矩阵，若matrix[i][j] == 0; 则设置第i行和第j列都为0，要求不用常数空间复杂度。思路：先用firstRow和firstCol存储第0行和第0列是否需要全部为0，然后遍历非第0行和第0列，若matrix[i][j] == 0; 则设置用第0行和第0列存储，即matrix[i][0] = 0; matrix[0][j] = 0;

074_Medium:Search a 2D Matrix. 矩阵有这样的性质，按行递增，某一行的第一个元素大于上一行的最后一个元素。思路：二分查找的拓展。

075_Medium:	Sort Colors.三种颜色用0,1,2表示，颜色一起的聚集在一起，要求one pass遍历。思路：借鉴快排的思路，遍历数组，遍历到i时，使得[0,firstWhite-1]都为0，[firstWhilte,firstBule-1]都为1，而[firstBule,i]都为2.再仔细看看代码。

076_Hard: Minimum Window Substring. 给定字符串S和T，在S中找到一个最小长度的子窜，使得这个子串包含T的所有字符。思路：这题用双指针来做，我的代码很乱，但却无缘无故的beat了86%的用户。首先用int d[300]来存储T中每个字符出现的次数，用boolean g[300]来存储对应字符是否出现。设一个指针point1在0处，用j来遍历，当g[s[j]-' ']==true 时，给d[s[j]-' ']--;当d[s[j]-' ']>=0,表示这个字符是可取的，count++；否则，该字符已经出现过多了，不能count++。之后再判断count==n? 如果达到n表示从point1到j已经包含了所有的T了，但是要求最短的，所有这个时候point1要前进，前进到什么位置呢？前进到g[s[point1]]&&d[s[point1]]==0为止，这里应该能够理解，到这里算一下最短距离；再把d[s[point1]]++,count--,point1++,从新找新的j。

077_Medium:Combinations.给定n和k，则有数组[1,2,...,n]，给出所有个数为k的子集。思路：很类似下面一题子集的问题，但是数量固定，注意剪枝会更快。

078_Medium:	Subsets. 给出一个集合，找出所有的子集。思路：eBay面试的时候问过，dfs搜索。

079_Medium:	Word Search.字符矩阵，给一个字符串，问是否在这个矩阵中出现。思路：回朔搜索。

080_Medium: Remove Duplicates from Sorted Array II.移除数组两个以上的元素。思路：用双指针，使得遍历到j时，[0,i]是可取的，[i+1,j]是不可取的，每次比较nums[j]==nums[i] && nums[j]==nums[i-1]， 如果成了，则j重复，否则交换nums[j]和nums[i+1]，并且i++。

081_Medium: Search in Rotated Sorted Array II. 已排序的数组经过旋转（这个数组存在相同元素），查找某个数是否存在。思路。承接033；对于类似033的搜索过程，当得到mid时，考虑nums[mid]和i的关系，当nums[mid]>nums[i]时，画个图很明显可以看出nums[mid]在上方，因此进一步判断若nums[i]<=target<nums[mid], 则j=mid-1; 否则i = mid+1. 当nums[mid] < nums[i]时，nums[mid]在nums[i]的下方，进一步判断,若nums[mid] < target <= nums[j] ,则i= mid+1， 否则j=mid-1. 当nums[mid] == nums[i] 时，表明有重复或者j-i=1. 有重复的话，mid可能靠近i,也有可能靠近j，这是保险走一步i++。(经过自己的测试，第三种情况再加上判断nums[i] == nums[j], 如果不相等, 令i=mid+1, 否则i++， 这样能快由2ms变成1ms)

082_Medium:Remove Duplicates from Sorted List II. 移除链表中有重复的节点，链表操作，详见代码。（主要有重复，全部移除，比如1-->2-->2-->3, 变成1-->3）

083_Easy:Remove Duplicates from Sorted List. 移除链表中重复的节点，链表操作，详见代码。

084_Hard: Largest Rectangle in Histogram

1:动态规划：使用动态规划，用left[i]表示第i个柱子可以最多向左延伸至第left[i]个柱子，形成一个矩形，right[i]则表示向右延伸。遍历两次，分别计算出这两个数组。

2：栈：这道题目有一个规则要掌握：当图形处在上升期时（height[i] < height[i + 1]），其实是不用计算面积的，因为在这种情况下再往前移动一格（i -> i + 1）所能得到的面积必然更大；当图形处在下降期时（height[i] > height[i + 1]），就要开始计算当前矩形的面积了，但是这个时候只知道右端点，如何知道左端点在哪呢？这就需要在遍历的时候，维护一个栈，这个栈里面保存的是最有可能的左端点，那么压栈呢？当每次出现比栈顶元素大的块是，就将其索引压栈，反之就是要计算机一次当前的矩形面积并和当前最大面积进行比较。

再多解释一下这个左端点栈的维护，因为这是做这一题的关键。

入栈：入栈的情形很简单，就是遇到了比当前栈顶元素还大的元素，那就把它的索引入栈，这其实是一种贪心，相当于先不计算矩阵的大小，因为如果下       一个元素还要大，那么所能得到的矩阵大小必然比现在计算要来的大。

出栈：遇到当前元素对栈顶元素要小，那就说明以栈顶元素为高度的矩阵边界到了，那么就要将栈顶元素出栈，然后计算以其为高度的矩形的大小。
那么这个栈中的元素有两个性质：
      
> 1. 栈顶元素和当前索引之间的所有元素（前闭后开的区间）都大于等于栈顶元素：因为一旦中间遇到了比栈顶元素小的元素，那么栈需要连续弹出，直至当前栈顶元素小于当前元素。
      
> 2. 栈顶元素和栈中的第二元素之间的所有元素（前开后闭的区间）都大于等于栈顶元素：因为如果这中间有一个元素既大于栈中的第二个元素又小于栈顶元素，那么它应该在这中间被入栈，继而成为栈中第二个元素。

其实这个做法就是把数组中的每个元素都作为矩形高度，计算了一遍该高度下矩形的最大面积。只是每次都贪心最大，避免了重复计算，所以效率高。

再遍历一次，即可求出所有的柱子可以形成的最大的矩形面积。为了减少边界的判断，可以使用哨兵，在两端添加两个柱子高度都为-1.

085_Hard:Maximal Rectangle. 矩阵中最大的全部包含1的矩形块。思路主要利用上题，详见代码。

086_Medium:	Partition List. 一个链表，和x，小于x在前，大于等于在后。思路：比数组这样排要简单，有个技巧就是为small和big添加一个空的头部。

087_Hard: Scramble String.题意见代码，有两种思路，一种是递归，一种是动态规划。

动态规划：//我们提出维护量res[i][j][n]，其中i是s1的起始字符，j是s2的起始字符，而n是当前的字符串长度，res[i][j][len]表示的是以i和j分别为s1和s2起点的长度为len的字符串是不是互为scramble。
有了维护量我们接下来看看递推式，也就是怎么根据历史信息来得到res[i][j][len]。判断这个是不是满足，其实我们首先是把当前s1[i...i+len-1]字符串劈一刀分成两部分，然后分两种情况：第一种是左边和s2[j...j+len-1]左边部分是不是scramble，以及右边和s2[j...j+len-1]右边部分是不是scramble；第二种情况是左边和s2[j...j+len-1]右边部分是不是scramble，以及右边和s2[j...j+len-1]左边部分是不是scramble。如果以上两种情况有一种成立，说明s1[i...i+len-1]和s2[j...j+len-1]是scramble的。而对于判断这些左右部分是不是scramble我们是有历史信息的，因为长度小于n的所有情况我们都在前面求解过了（也就是长度是最外层循环）。
上面说的是劈一刀的情况，对于s1[i...i+len-1]我们有len-1种劈法，在这些劈法中只要有一种成立，那么两个串就是scramble的。
总结起来递推式是res[i][j][len] = || (res[i][j][k]&&res[i+k][j+k][len-k] || res[i][j+len-k][k]&&res[i+k][j][len-k]) 对于所有1<=k
如此总时间复杂度因为是三维动态规划，需要三层循环，加上每一步需要线行时间求解递推式，所以是O(n^4)。虽然已经比较高了，但是至少不是指数量级的，动态规划还是相当有用的，空间复杂度是O(n^3)。代码如下：

注：事实上这里最大的难点，是你怎么安排这三个循环。仔细看一下，计算len对应的解时，要用到一堆len-1的解。所以我们应该len 从0到1地这要子计算（三维啊都没办法通过画图来推导动态规划的递增关系了！）

递归：比较直观，比动态规划要快，不知为什么

088_Easy:Merge Sorted Array. 合并两个已排序的数组，把一个合并到另一个去。思路：看到网上有比较好的解法，从后往前生成每个元素，用 nums1[k--] = nums1[i] > nums2[j] ? nums1[i--]:nums2[j--];然后再把nums2的剩余数都倒过来。

090_Medium: Subsets II. 给定一个数组，里面有重复的元素，要求找到所有的子集。思路：这题值得我好好反思，首先排好序，在dfs里的操作，要选择放入某元素或者不放，这里和无重复的不同，建立一个while循环，当前为j=i，当j<nums.length时，选择放入nums[j]这个元素，递归调用dfs(j+1),r如果选择不放，不用调用dfs,并且在循环中过滤掉和上一位相同的元素。每一次进到dfs,都要存一次tmp,这样不会重复，因为只有加入新的元素才会递归调用dfs.

091_Medium: Decode Ways. 给一个数组，包含0到9这几个数字，计算一共有多少种编码方式，1->A ...26->Z. 思路：典型的动态规划。dp[i]表示[0,i]总共可以编码总数，注意0的情况，当s(i) == 0时，如果s(i-1)==0 || s(i-1) >2, 遇到错误返回0； 否则是s(i)单独编码dp[i]+=dp[i-1]，如果s(i)能够和s(i-1)结合，再dp[i] += dp[i-2]。

092_Medium: Reverse Linked List II. 给定一个链表和m和n，反转[m,n]的部分，发现加入一个newHead真的还挺好用的。

093_Medium: Restore IP Addresses. 给定一个字符串，把他分割成有效的ip地址，找到全部的有效的ip地址。思路：典型的dfs+剪枝。还要注意特殊情况，就是当首个字母是0时，只能单独成为1段。利用剪枝函数：

    if(3*(4-index) < s.length() || 4-index > s.length()){
                return;
            }

094_Medium: Binary Tree Inorder Traversal. 二叉树的中序遍历。

095_Medium: Unique Binary Search Trees II. 给出n，生成所有[1,n]的二叉搜索树。思路：递归建树。

096_Medium: Unique Binary Search Trees, 给出n，问能够形成的多少种二查搜索树，思路：典型的卡特兰数，亦可用dp解决。

097_Medium: Interleaving String. 给定s1,s2,s3，判断s3是否是由s1和s2间隔插入而形成的。思路，这题用动态规划做，分析如下：

> s1 = a1, a2 ........a(i-1), ai

> s2 = b1, b2, .......b(j-1), bj

> s3 = c1, c3, .......c(i+j-1), c(i+j)

定义 match[i][j] 意味着，S1的(0, i)和S2的(0,j)，匹配与S3的(i+j) [0,i-1]+[0,j-1]--->[0,i+j-1]
如果 s1[i-1] == s3[i+j-1] && match[i-1][j], match[i][j] = true， 等价于如下字符串是否匹配,s1[0,i-2]+s2[0,j-1]--> s3[0,i+j-2] && s1[i-1] --> s3[i+j-1]。

同理，如果s2[j-1] = s3[i+j-1] && match[i][j-1], 那么match[i][j] true;

098_Medium:. Validate Binary Search Tree. 判断一个数是是否是二叉搜索树。思路：两种方法

> 1：递归判断，对于左右子树，要传递一个区间[min,max]，子树的node.val不能在这个区间外（包括踩在边界上），对于左子树，更新其max值，max=Math.min(max,node.val);对于右子树，更新其min值，min=Math.max(min.node.val). 初始的min设置为Long.MIN_VALUE, max=Long.MAX_VALUE.

> 2：中序遍历，判断得到的数组是否是递增的。

099_Hard: Recover Binary Search Tree. 给定一颗二叉搜索树，其中有两个元素位置交换了，请恢复它。思路：还是借助搜索树的中序遍历严格递增，设置全局指针pre表示前一个数，举个栗子，1,2,3,4,5,6 --> 1,5,3,4,2,6 其中2和5交换了位置，因此在中序遍历时，当遍历到3时发现不对，此时不对的应该是5，即pre，设置n1=pre；当遍历到2时又发现不对，此时有问题的不是pre，而是当前的node,设置n2=node,因此，总是发现两个地方有问题，并且第一次发现的时候是pre,第二次发现的时候是node。以上是交换的两个元素不相邻的时候，当如果交换的元素正好相邻，例如1,2,3,5,4,6, 4和5交换，遍历过程中只会发现一个地方有问题，那怎么办？？很简单，在第一次发现有问题的时候设置n1=per,n2=node, 如果是相邻的交换，那么后续n2的值不会改变，否则n2会被覆盖，两种情况正好都符合要求。

100_Easy: Same Tree. 判断两颗二叉树是否相等，值相等，结果相同。思路：递归判断，判断要么p,q同时为空，要么p,q同时不为空并且p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,p.right)。

101_Easy: Symmetric Tree. 判断树是不是左右对称的。思路：用递归。

102_Easy: Binary Tree Level Order Traversal. 二叉树层序遍历。 思路：借助队列。这里需要注意的是java的知识，队列用LinkedList. 需要用到的方法是add(o),在队尾添加一个元素，poll(),移除并返回队列头一个元素。用Queue queue = new LinkedList<>(), 可使用peek,poll,add,不能使用push，pop方法，因为根据多态，其父类Queue无这两个方法，实际上也不能用这两个方法，因为这是栈操作的，不能实现队列的功能。用LinkedList queue = new LinkedList<>() 可以用pop和push。

103_Medium: Binary Tree Zigzag Level Order Traversal. 二叉树层序的交叉遍历。思路：自己的思路是用两个栈，交替的放每一层，其中一个先放left，再放right，另一个先放right，再放left。感觉比较low。最hot的方法是用dfs，若是偶数层在加在末尾，若是奇数层则加在最前，感觉也比较low。

104_Easy: Maximum Depth of Binary Tree. 求二叉树的深度。递归。

105_Medium: Construct Binary Tree from Preorder and Inorder Traversal. 从中序和前序恢复二叉树。

106_Medium: Construct Binary Tree from Inorder and Postorder Traversal. 从中序和后序恢复二叉树。

107_Easy: Binary Tree Level Order Traversal II. 二叉树层序遍历，反向输出。

108_Medium: Convert Sorted Array to Binary Search Tree. 把数组转化为二叉搜索树。要求是平衡的。选取数组中间的节点作为根，递归的用改数字前面的元素构造左子树，用该数字的后面的元素构造右子树。

109_Medium: Convert Sorted List to Binary Search Tree. 把一个链表转为为二叉搜索树。思路大和上体一样，用快慢指针找到中间元素，然后递归，注意要把指向作为根的指针设置为null。

110_Easy: Balanced Binary Tree. 判断一棵树是否是平衡的。这里还是用递归的方法。但是需要注意的是要新写一个函数，当以某个节点为根的树不是平衡的，则返回-1；若是平衡的，返回其深度。

111_Easy: Minimum Depth of Binary Tree. 找到最小深度的叶子节点。思路：递归，当是叶子节点是返回1，否则返回左右子树中较小的深度+1(在左右子树不为空的情况下).

112_Easy:Path Sum. 给一棵树和一个数，判断是否存在一条路径从根到叶子节点的和等于指定的数。思路：dfs搜索。

113_Medium:	Path Sum II.给一棵树和一个数，找出所有能够路径和等于指定数。思路：dfs搜索。

114_Medium:	Flatten Binary Tree to Linked List.把一颗树变成如下的样子。

   1
   
    \
    
     2
     
      \
      
       3
       
        \
        
         4
         
          \
          
           5
           
            \
            
             6
             
基本思路还是递归嘛，对于某个节点，递归左子树把它弄成这样，递归返回的值是最后一个元素，设为left，递归右子树把它弄成这样，也是返回最后一格元素设为right。然后把他们接起来，tmp=root.right;root.right=root.left;root.left=null;left.right=tmp;return right;
注意边界情况即可。

115_Hard: Distinct Subsequences. 给两个字符串s和t,通过删除s的某些元素把它变成t有几种方法。思路：动态规划。定义dp[i][j]为字符串i变换到j的变换方法。

116_Medium: Populating Next Right Pointers in Each Node. 给一棵完全二叉树，要求使得每个节点有个指针指向它同层的右边一个节点。思路：用队列实现，层序遍历的拓展

117_Hard: Populating Next Right Pointers in Each Node II. 同上，给定一个二叉树。用上面相同的代码也能解决。

118_Easy: Pascal's Triangle. 杨辉三角实现。思路：按照杨辉三角的计算公式来生成。

119_Easy：Pascal's Triangle II. 生成杨辉三角的第n行。要求只能用O(n)的空间。而二重循环，在每层循环中，从后往前遍历，更新每一位的值，有arr[j] = arr[j]+arr[j-1]，注意，不能从前往后更新。

120_Medium:	Triangle. 给一个类似杨辉三角的三角，找一条从顶端到最低端的一条最短的路径，空间要求O(n)。思路：动态规划，设dp[n],dp[j]是表示遍历到i层后到达a[i][j]的最短路径和。

如果S[i]==T[j]，那么dp[i][j] = dp[i-1][j-1] + dp[i-1][j]。意思是：如果当前S[i]==T[j]，那么当前这个字母即可以保留也可以抛弃，所以变换方法等于保留这个字母的变换方法加上不用这个字母的变换方法。
如果S[i]!=T[i]，那么dp[i][j] = dp[i-1][j]，意思是如果当前字符不等，那么就只能抛弃当前这个字符。
递归公式中用到的dp[0][0] = 1，dp[i][0] = 0（把任意一个字符串变换为一个空串只有一个方法）

123_Medium: Best Time to Buy and Sell Stock. 给一个数组表示股票价格，只能买卖一次，求最大收益。思路：动态规划，遍历到i时表示截止i时刻最大的收益，同时维护一个之前的最低价格min,当prices[i]<min,更新Min,否则，更新最大收益

122_Medium: Best Time to Buy and Sell Stock II.承接上题，可以买卖无限次。思路：只要有收益就马上卖。求相邻元素中，只要前一个比后一个大，他们的差值就应该被记录。

123_Hard: Best Time to Buy and Sell Stock III. 承接上题，智能买卖两次。思路:动态规划，

124_Hard: Binary Tree Maximum Path Sum. 二叉树中找到一条路径和最长的路径，该路径不需要经过根节点，且该路径不能出现岔路。思路：运用递归，定义一个递归函数maMax(TreeNode node),在函数中递归得到left=myMax(node.left),right=myMax(node.right)返回的是node存在路径中最大的路径和， 所以返回的应该是Math.max(node.val,Math.max(node.val+left,node.val+right)).同时在函数里要更新全局的最大值，即localMax = node.val;if(left>0) localMax+=left; if(right> 0) localMax+=right; 更新localMax到全局max。

136_Medium: Single Number.给出一个数组，其中一个数只出现一次，其他的数出现两次，找到只出现一次的那个数。思路：考虑位运算，异或操作，两个相同的数异或等于0，0和任何数异或都等于它本身。因此，把数组所有数都异或一遍，结果就是出现一次的数。

137_Medium: Single Number II. 给出一个数组，其中一个数只出现一次，其他的数只出现3次，找出只出现一次的那个数。思路：一看和上一题很像，但是3是even，采用异或操作不等于0，所以不能用上面的思路，这题比上题更普遍，把每个数字分解为32位，把数组的所有数每一位分别相加，那么会出现什么情况？如果不加那个只出现一次的数，那么每一位上都是3的倍数，因此，只要在每一位上对3取余，就是只出现一次的那个数的二进制形式。

138_Hard: Copy List with Random Pointer。深复制特别链表。第一次遍历，对于米一个节点cur，复制出cur1插入到cur后；第二次遍历，处理每个cur1中的random的指向，用：

    cur.next.random = cur.random == null ? null : cur.random.next;
    
第三次遍历，分来两条链表。注意，不能在第二次遍历直接分开，因为前面的分开了会影响后边的random指向。

155_Easy: Min Stack. 要求栈返回一个最小元素，并且push,pop,min都必须是O(1)的。据说是谷歌的面试题。要用两个栈，一个存数据，另一个存最小当前最小的值，每次push数据时，如果当前值比minStack的peek小时才压进去；pop时，从Stackpop出来的数据如果和minStack的peek相等，则popminStack。

164_Hard: Maximum Gap。求无序数组有序顺序中，最大相邻间隔，要求O(n) time 和 O(n) space。用treeMap可以做，但是效率低。标准答案用桶排序，首先找出数组中的min和max。则有个公式：最大maxGap不会小于(max-min)/(nums.length-1)向上取整。因此，桶的长度为(max-min)/(nums.length-1)向上取整，这样，排序后在一个桶中的元素不用相互之间在比较了，因为它们的差值肯定小于桶长度，不会是我们需要求的，对于每一个桶，只需存放在桶了最大和最小的值，然后计算相邻桶中（前一个桶的max和后一个桶min）即可。

174_Hard: Dungeon Game。给一个二维数组，数组有正有负，要求找一条路径从左上走到右下，走的过程中生命值得和不能小于等于0，找出最小初始生命值。一开始觉得挺简单，简单dp：

    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + dungeon[i][j];
    
但是这样有致命的问题，像;-1,-4,3,1。这样一个二维矩阵求得最后的dp[0][3]=-1，初始生命值就是2。但如果这样在[0][1]这个位置就死了。上面的递归式显然不正确，于是我想到了另一个二维数组去存路径上历史的最小值，在max一下，再跟dp[i][j]min一下，结果证明折腾很久，过了43/44个cases，最后一个fail了。后来看了答案，递归是从后面向前的，并且dp矩阵的定义更严谨。定义矩阵dp，其中dp[i][j]表示从位置(i,j)到(m-1,n-1)最少需要多少生命值。则递推关系式是：

    dp[i][j] = Math.max(Math.min(dp[i+1][j],dp[i][j+1]) - dungeon[i][j],0)

这才是正确的递推关系，到遍历到(i,j)时，可以从(i+1,j)和(i,j+1)选择较小的一个走，那个dp[i][j]应该等于其中较小一个的最小生命值加上在(i,j)上消耗是生命值，如果dp[i][j]<0，负生命值，则置为0。

这样从后往前递归使得dp[i][j]只和dp[i+1][j]与dp[i][j+1]相关，而从前往后则不仅仅依赖相邻的值。而题目要求初始的生命值也很明显的提示了要从后往前递归最后返回dp[0][0]，可惜当时思路太固定没有想到。

214_Hard: 给一个字符串，在前面加上一个最短的字符串，使得生成的字符串是回文的。问题转化为求原字符串s.substring(0,i)是回文，i要最大。然后把s.substring(i+1,n)反转加到前面即可。注意，用传统的动态规划会出现memory limit，要用确定一个中心，然后往两边延伸，发现是回文后立即处理返回。用KMP算法会更好，但是还没有研究过。

230_Medium: 求BST中第K个元素，用dfs中序遍历，搜到之后立刻return节约时间。

233_Medium: 求1的个数？找规律，分别统计每一位上出现的个数，分为三种情况：=0；=1；>1 总结得到公式:

    (a+8)/10*m+(b+1)*(a%10==1?1:0)
    
234_Easy: 判断链表是否是回文的（要求O(n)）,找到链表中间点，把前一段链表反转，在和后一段逐个比较。

235_Easy: BST中求两个节点共同的最低的父节点。递归搜索BST，每次判断两个节点的值和根节点的值得关系，决定是向左还是向右还是返回。

236_Medium：继235中，在二叉树中求两个节点的共同的最低父节点。方法1：分别找到root到此两个节点的路径，比较路径，找到第一个不同的节点；方法2：递归，如果某个节点c是p和q的公共父节点，则p，q一定分别位于其左右子树中。

237_Easy：删除链表中某个节点，但只给访问该节点的权限。将后一个节点的值付给该节点，并把给节点的next指向原来next的next。

238_Medium：求数组除了自己所有元素的积。两次循环，第一次从左到右，re[i]储存nums[0]...nums[i]的积，第二次从右到左，re[i]*=(nums[i+1]...nums[nums.length-1])的积。

239_Hard：求移动窗口中最大的值。我的方法--用start记录当前窗口的最大值得index，每当窗口移动时，首先判断新进来的nums[i]是否比nums[start],如果大的话start=i，否则再start是否在窗口里，如果不在，重新遍历窗口找最大的值对应的index赋给start。最后返回nums[start]。标准方法，维护一个双端队列，没进来一个index，把小于该nums[index]的indexs都从队列里移除，这样该队列就是非递减的。判断队列头部（最大的元素对应的index）是否在窗口内，不是则移除。返回队列头部index对应的值。

241_Medium: 计算一个算数表达式所有的结果。运用分治法的典型列子。找到一个计算符，递归计算左边所有可能的结果，递归计算所有右边可能的结果，然后合并起来。

240_Medium: 二分查找有序矩阵的某个元素是否存在。用二分查找的分治法。每次取行和列的中间点，判断目标是是否等于它，如果不等，根据matrix[midI][midJ]的大小关系，可以舍弃左上或者右下继续搜索。注意，分成三片区域搜索才行，两片会超时，不知道，为什么。应该还有更快的算法，明天研究一下。另一种更快的方法是从右上角开始搜索，大于target向左(j--)，小于target向下(i++)，等于返回。时间复杂度O(m+n)。

257_Easy: Binary Tree Paths。求二叉树所有路径。用dfs遍历整棵数。

258_Easy: Add Digits。找规律题。列出从1到21个数时发现答案是1-9的循环。

260_Medium: Single Number III,找仅有的落单的两个数。题意为给定一个整数数组，其中有两个数只出现一次，其余数出现两次。要求线性时间、常量空间找出这两个数。我们知道，两个相等的数异或结果为0。因此，首次扫描数组，得到两个单独的数A、B的异或结果AxorB。因为A和B不相等，因此AxorB一定不为0，且二进制位为1的位A和B一定不同。任取AxorB中的一个二进制位，可以将原数组元素分成两组异或即得结果。注意n&(~(n-1))表示取的n中的最后一位二进制位。另外，&的优先级小于==的优先级。

263_Easy：Ugly Number。判断丑数，循环除2,3,5，看最后的结果是否为1，是则是丑数，不是则不是丑数。

264_Medium: Ugly Number II. 第N个丑数。丑数的递归性质：丑数*2=丑数，丑数有如下规律：

> (1) 1×2, 2×2, 3×2, 4×2, 5×2, 6×2, 8×2…

> (2) 1×3, 2×3, 3×3, 4×3, 5×3, 6×3, 8×3…

> (3) 1×5, 2×5, 3×5, 4×5, 5×5, 6×5, 8×5…

三个队列，每次取出队列顶部三个数中最小的，设为T，并把T×2，T×3，T×5，分别压入队列中即可。注意，每个队列的丑数是从小到大排列的，这很容易证明，因为对于队列2，先进来的数是n1×2,后进来的是n2×2，这里肯定有n1<n2。只需要保证每次迭代的过程中选取最小的丑数（或者说是质因数），可以理解为后面的数字是前面的数组针对2,3,5的乘积.

268_Medium:Missing Number。找到确实的数字。本题三种方法，我用的是第一种方法，通过交换把数字i交换到nums[i]的位置，再从头扫描数组，第一个不是i不等于的nums[i]就是确实的数字。第二种方法，求和法，0~n，理论和是sum=(0+n)*(n+1)/2, 对数组求和得到sum1，缺少的是sum-sum1。第三种是异或法，自己异或是0，任何数和0异或是自己，因此，把数组所有数和0~n全异或起来，得到的结果就是missing number.

274_Medium:H-Index.第一种比较笨的方法是先排序，然后再找。第二种是利用桶排序。桶的长度为len+1,题目要求最大的h，使得h个citation的值都大于等于h。虽然我没想到，但是应该很容易想到桶排序，h最大值为len,对于桶i(0<=i<len),统计citation==i 的个数，最后一个桶统计citation>=len的个数，然后从后往前遍历，total为citations的累加，当首次出现total>=i时，返回i.

275_Medium:H-Index II .当274中数组是升序时，用二分查找加速，时间复杂度为O(logn)。

278_Easy: First Bad Version. 二分查找，注意两个陷阱，1：取中值的时候要用i+(j-i)/2,如果用(i+j)/2可能会Integer溢出。2：起点，如果设置i=1的话，如果全是换版本，则会出错，可以从i=0开始，或者在循环前面判断 1 version是否bad。..

279_Medium: Perfect Squares。动态规划题。设置一位数组dp,dp[i]表示i最小能够用多少个数字表示。则dp[i]和dp[0]...dp[i-1]，存在如下关系：

    dp[i] = Math.min(dp[i-1]+1, dp[i-4]+1, ... dp[i-j*j]+1,...) j*j<=i
    
282_Hard: Expression Add Operators.
思路

因为要输出所有可能的情况，必定是用深度优先搜索。问题在于如何将问题拆分成多次搜索。加减法很好处理，每当我们截出一段数字时，将之前计算的结果加上或者减去这个数，就可以将剩余的数字字符串和新的计算结果代入下一次搜索中了，直到我们的计算结果和目标一样，就完成了一次搜索。然而，乘法如何处理呢？这里我们需要用一个变量记录乘法当前累乘的值，直到累乘完了，遇到下一个加号或减号再将其算入计算结果中。这里有两种情况:

> 乘号之前是加号或减号，例如2+3*4，我们在2那里算出来的结果，到3的时候会加上3，计算结果变为5。在到4的时候，因为4之前我们选择的是乘号，这里3就应该和4相乘，而不是和2相加，所以在计算结果时，要将5先减去刚才加的3得到2，然后再加上3乘以4，得到2+12=14，这样14就是到4为止时的计算结果。

> 另外一种情况是乘号之前也是乘号，如果2+3*4*5，这里我们到4为止计算的结果是14了，然后我们到5的时候又是乘号，这时候我们要把刚才加的3*4给去掉，然后再加上3*4*5，也就是14-3*4+3*4*5=62。这样5的计算结果就是62。

因为要解决上述几种情况，我们需要这么几个变量，一个是记录上次的计算结果currRes，一个是记录上次被加或者被减的数prevNum，一个是当前准备处理的数currNum。当下一轮搜索是加减法时，prevNum就是简单换成currNum，当下一轮搜索是乘法时，prevNum是prevNum乘以currNum。

注意：

第一次搜索不添加运算符，只添加数字，就不会出现+1+2这种表达式了。
我们截出的数字不能包含0001这种前面有0的数字，但是一个0是可以的。这里一旦截出的数字前导为0，就可以return了，因为说明前面就截的不对，从这之后都是开始为0的，后面也不可能了。

283_Easy: 把数组的0移到末尾，其他元素相对位置不变。类似快排。双指针，i从0遍历nums.length-1,当遍历到i时，使得[0...pos-1]为非0数，[pos...i]为0。当nums[i]!=0，交换nums[pos],nums[i],pos++.

284_Medium: Peeking Iterator。设置缓存和标志位。

287_Hard:Find the Duplicate Number.

1:二分法

实际上，我们可以根据抽屉原理简化刚才的暴力法。我们不一定要依次选择数，然后看是否有这个数的重复数，我们可以用二分法先选取n/2，按照抽屉原理，整个数组中如果小于等于n/2的数的数量大于n/2，说明1到n/2这个区间是肯定有重复数字的。比如6个抽屉，如果有7个袜子要放到抽屉里，那肯定有一个抽屉至少两个袜子。这里抽屉就是1到n/2的每一个数，而袜子就是整个数组中小于等于n/2的那些数。这样我们就能知道下次选择的数的范围，如果1到n/2区间内肯定有重复数字，则下次在1到n/2范围内找，否则在n/2到n范围内找。下次找的时候，还是找一半

2：映射找环法

假设数组中没有重复，那我们可以做到这么一点，就是将数组的下标和1到n每一个数一对一的映射起来。比如数组是213,则映射关系为0->2, 1->1, 2->3。假设这个一对一映射关系是一个函数f(n)，其中n是下标，f(n)是映射到的数。如果我们从下标为0出发，根据这个函数计算出一个值，以这个值为新的下标，再用这个函数计算，以此类推，直到下标超界。实际上可以产生一个类似链表一样的序列。比如在这个例子中有两个下标的序列，0->2->3。

但如果有重复的话，这中间就会产生多对一的映射，比如数组2131,则映射关系为0->2, {1，3}->1, 2->3。这样，我们推演的序列就一定会有环路了，这里下标的序列是0->2->3->1->1->1->1->...，而环的起点就是重复的数。

所以该题实际上就是找环路起点的题，和Linked List Cycle II一样。我们先用快慢两个下标都从0开始，快下标每轮映射两次，慢下标每轮映射一次，直到两个下标再次相同。这时候保持慢下标位置不变，再用一个新的下标从0开始，这两个下标都继续每轮映射一次，当这两个下标相遇时，就是环的起点，也就是重复的数。对这个找环起点算法不懂的，请参考Floyd's Algorithm。

289_Medium: Game of Life。重点就是建立4种状态，分别是：

> 0: 死--〉死

> 1: 活--〉死

> 10: 死--〉活

> 11: 活--> 活

这样表示的好处是低位表示原来的状态，高位表示下一次的状态。

290_Easy: Word Pattern. 这题要求一对一的匹配，我用了两个HashMap完成的。

292_Easy: Nim Game. 根据提示，勉强自己做出来。提示说，如果是5个石头，要怎么移？移法：先移走1个，剩下4个给对手，这样一定能给赢。由此，

    “只有留给对手4个石头，或4的倍数的石头”，就一定能赢。
    
这就是最优的策略。如果先拿的人不能在第一次拿完之后留给对手4个石头或4的倍数个石头，他就会输，因此，只有他一开始石头的数量是4的倍数时，他才会输。网上的解释如下：

> 这题往小说可以追溯到小学奥数或者脑筋急转弯的书中，往大说可以深究到博弈论。然而编程在这里并没有卵用，策略在于，因为每个人都取不到4个，假设自己后走，要保证每轮自己和对方取得数量的和是4，这样就能确保每轮完后都有4的倍数个石头被取走。这样，如果我们先走的话，先把n除4的余数个石头拿走，这样不管怎样，到最后都会留4个下来，对方取1个你就取3个，对方取2个你就取2个，就必赢了。

300_Medium: Longest Increasing Subsequence, 求最长非递减序列长度，非常典型的动态规划问题。设数组dp，dp[i]表示0到i的最长非递减序列长度，状态转移方程为：

    dp[i] = dp[j]+1 ; 0 <= j < i && nums[i] >= nums[j]
    
以上方法是O(n^2)的算法，符合题目要求，但还有更快的O(nlogn)，用的是贪心+二分查找，思路如下：
遍历nums数组，用一个数组保存当前找到的最长的非递减序列(注意是保存nums的数字而不是上面方法的个数)，当遍历到i时，如果nums[i]比该数组最后一个数大或等，将该数直接添加到数组后面，否则，由于该数组是递增的，用二分查找找到最小的大于改数的数字，用nums[i]替换它(贪心的步骤),例如：已有的非递增是1,3,4,7 当新来的一个数是2，则找到3替换变成1,2,4,7。原因是对比1,2和1,3，1,2在后续中更有潜力找到更长的非递增序列。
这种方法能够找到最长的长度，但是最终生成的序列并不是最终的答案，因此，它只适用于找长度。

301：Remove Invalid Parentheses。 题目提示可以用DFS和BFS。用DFS+剪枝。

1：DFS步骤：对于每个字符，有两种，扔掉或留下，这样一共生成2^n个子串，在这里，注意递归的技巧，由于要找到最小的移除数量，因此，在递归时，先留下该字符，去递归，再移去该字符，去递归，这样能够首先找到最长的合法的字符串，然后通过这个长度过滤掉剩下虽然合法但是短的字符串。

2：剪枝步骤：这步对算法性能有很大的提高，第一个是当right+1>left时，肯定不合法，所以只能remove掉这个);第二是当已找到的org和待搜索的now的总长度加起来比已找到最长的有效字符还短时，此时表示以此递归不可能找到合法解，因此要return.

BFS:看的标准答案。大意是，从最长的找到最短的，把原始字符串放到队列中。当每次队列不为空，取出一个，判断是否合法，合法的话添加到结果集，否则，移除该串的每一个字符，放到队列中。其实算法还能更快，如果在判断合法时再加上基于长度的剪枝。

303_Easy： Range Sum Query - Immutable.给定数组，要求查询任意两点之间和和。init复杂度O(n),用sums数组，sums[i]存储nums[0]到nums[i]的和；query复杂度O(1)，返回sums[j]-sums[i-1]。

304_Medium: Range Sum Query 2D - Immutable. 303的情况拓展到二维矩阵中，dp[i][j]存储[0][0]到[i-1][j-1]这个矩形的和。

306_Mideum_Additive Number.典型dfs应用，一开始想用动态规划，但是想不出，不知道能不能做。在主函数枚举出前2个数，就是把字符串切割成三部分，扔进dfs函数中，如果如何马上返回true，否则继续dfs，什么时候需要dfs呢？ 例如这样(1,2,358)--?(2,3,58)-->(3,5,8)-->true。

307_Medium:Range Sum Query-Mutable. 和303相似，多添加一个条件是会修改数组元素的。思路用线段树，线段树类有5个属性，分别是start,end,left,right,sum。根据数组创建线段树，更新元素，查找sum，详见代码。

还有一种方法是树状数组（binary indexes tree），用a存原始数据，用e存a中某几位的和的数据，规律如下：e[i]（从1开始），i的二进制表示为例如100,在e[i]存以a[i]开始前2^x个数的和，x是末尾0的个数。对于一个i，用公式：i&(-i)计算它的lowbit，i+lowbit表示i的父亲节点，i-lowbit表示i的前驱节点，因此，更新时（i,val）,把e[i]+=val-nums[i],然后去更新它的父亲节点i+lowbit(i);超找时，返回e[i]+e[i-lowbit(i)]+.....迭代的找下去直到i==0. 

309_Medium_Best Time to Buy and Sell Stock with Cooldown. 题意是股票买卖，要求卖之后的下一天不能买。

因为当前日期买卖股票会受到之前日期买卖股票行为的影响，首先考虑到用DP解决。

这道题比较麻烦的是有个cooldown的限制，其实本质也就是买与卖之间的限制。对于某一天，股票有三种状态: buy, sell, cooldown, sell与cooldown我们可以合并成一种状态，因为手里最终都没股票，最终需要的结果是sell，即手里股票卖了获得最大利润。所以我们可以用两个DP数组分别记录当前持股跟未持股的状态。然后根据题目中的限制条件，理清两个DP数组的表达式。

对于当天最终未持股的状态，最终最大利润有两种可能，一是今天没动作跟昨天未持股状态一样，二是昨天持股了，今天卖了。所以我们只要取这两者之间最大值即可，表达式如下：

    sellDp[i] = Math.max(sellDp[i - 1], buyDp[i - 1] + prices[i]);
    
对于当天最终持股的状态，最终最大利润有两种可能，一是今天没动作跟昨天持股状态一样，二是前天还没持股，今天买了股票，这里是因为cooldown的原因，所以今天买股要追溯到前天的状态。我们只要取这两者之间最大值即可，表达式如下：

    buyDp[i] = Math.max(buyDp[i - 1], sellDp[i - 2] - prices[i]);
    
最终我们要求的结果是

sellDp[n - 1] 表示最后一天结束时手里没股票时的累积最大利润
当然，这里空间复杂度是可以降到O(1)的。

310_Medium: Minimum Height Trees. 给定一个具有树性质的无向图，求所有的具有最小树结构的树，返回这些树的root点。一开始没看清楚题意，这个无向图是具有树结果的，因此任意两点只有一条路径，其实说明这个无向图只有n-1条边，一开始想到了是找出全源最短路径，然后对于每个点，遍历其他节点，找到最长的路径存在max[i]中，所有max[i]的最小值min就是最小高度树的高度，在遍历一次哪个节点的max[i]==min就是根了，这样在n=909就超时了，这个做法是基于有环的。结合题意和提示，其实最小高度树的根节点最多只有2个。在具有树属性的无向图中，当n> 2时，叶子节点肯定不能是root,因此每次找出叶子节点，将它和它的边删掉，就像拓扑排序一样。直到总节点<2.

312_Hard: Burst Balloons.给定一个组气球，每个气球有个值，扎破第i个气球得到nums[left]nums[i]nums[right]个奖励，求最大奖励值。这题是典型的动态规划+分治，dp[l][r]表示扎破(l, r)范围内所有气球获得的最大硬币数，不含边界(注意：dp[l][r]表示扎破[l+1...r-1]范围内的气球)；一开始我们对input的nums数组左右两边分别加上1，然后求d[0][n-1]就行.我们如何求dp[l][r]呢？这里我们用最后一个气球作为分类，在(l,r)区间burst 气球的方案可以按最后剩下的那个气球是哪个来分类，如果最后剩下的是第l<i<r个气球，那么dp[l][r]（关于i） = nums[l] * nums[i] * nums[r] + dp[l][i] + dp[i][r]。因此我们可以选取这些方案中最大的。

313_Medium: Super Ugly Number. 超级丑数，给定一个质数数组，求第n个丑数，思路：这题还没有搞懂，先把网上的思路复制一遍：首先我们考虑一系列的数字是根据什么原则产生的。很显然，除了第一个数字，其余所有数字都是之前已有数字乘以任意一个在质数数组里的质数.

所以对于每一个已有的数字，我们都可以分别乘以所有在质数数组里的质数得到一系列的数字，这些数字肯定会存在在以后的序列中。由于我们是要得到从小到大的结果，所以我们可以维护个count数组，来记录对于对应质数下一个需要被乘的已有数的index, 我们取最小的结果当做下个数，对于那个最小的结果，需要增加count数组中那个质数对应的index,表明下一次用下个已有的数来乘对应的质数。

有些tricky的地方是对于已有序列中的数，乘不同质数得到的结果会可能存在重复，比如题目中例子2, 7与7, 2就重复了，解决方法很简单，就是只要是等于最小的结果，就增加对应count数组中的元素，具体见代码。

322_Medium: Coin Change. 银币对换问题，求最小的对换。经典动态规划：dp[i][j]表示i元钱用coins[0..j]对换的最小数量，则dp[i][j] = Math.min(dp[i][j-1],dp[i-coins[j]][j]),dp[i][j-1] 表示不用coins[j]，dp[i-coins[j]][j]表示至少一个coins[j].一维dp也可以做。
