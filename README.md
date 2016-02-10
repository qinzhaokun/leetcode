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

043_Medium: Multiply Strings.两个数相乘，如果按照乘法模拟运算的话比较复杂，注意技巧就是建立个n1+n2长度的数组存结果，然后倒数第i位数字乘以倒数第j位数字乘的结果是保存在数组i+j位，最后再统一进位，详见代码。

138_Hard: Copy List with Random Pointer。深复制特别链表。第一次遍历，对于米一个节点cur，复制出cur1插入到cur后；第二次遍历，处理每个cur1中的random的指向，用：

    cur.next.random = cur.random == null ? null : cur.random.next;
    
第三次遍历，分来两条链表。注意，不能在第二次遍历直接分开，因为前面的分开了会影响后边的random指向。

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

注意

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
