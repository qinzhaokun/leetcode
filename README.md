#leetcode
001_Medium: Two Sum.利用哈希表（在O(1)时间复杂度内查找某个元素）。遍历数组，查找map里是否containsKey(target-nums[i])，如果则返回，否则将nums[i]放入map中(map.put(nums[i],i)。

002_Medium: Add Two Numbers。 用链表存储的两个数相加，逐位相加，记得进位。

003_Medium: Longest Substring Without Repeating Characters. 最长无重复字串。运用滑动窗口法，也可运行HashMap. 设置数组a(长度大于ASCII个数)，ASCII第一位是' '。双指针遍历数组，移动前指针，判断a[s.charAt-' ']的值：

> true;遇到重复，移动后指针，逐位设置false,直到a[s.charAt(i)-' ']==false;

> false;设置a[s.charAt(i)-' ']=true,前指针前进。

005_Mesium:最长回文。用简单的二维DP，isPa[i][j]表示s.substring(i,j+1)是否是回文，isPa[i][i]=true,递推式如下：

    isPa[i][j] = s.charAt(i) == s.charAt(j) && (i+1 >= j-1 || isPa[i+1][j-1])
    
006_Easy:ZigZag.参考dicuss，用二维stringBuffer存储，具体见代码。

007_Easy: 反转整数，注意负号和Integer的溢出，反转公式如下：

    while(x != 0){
    re = (re*10 + x%10);
    x /= 10;
    }
    
010_Hard:Regular Expression Matching. 比较难想到的一道dp。注意的是*表示前一个字符可以重复n次(n>=0)。大部分注释已经写在代码中，其中比较难理解的就是当 p(j)=='*'时，分两种情况，1：p(j)前一个字符重复0次，则是a[i+1][j-1] ; 2： p(j)前一个字符重复大于等于1次，设x=p(j)，则p可以变成...x*x,后一个x表示至少一次，前面的x*又可以表示重复n次(n>=0)，递归的过程。则a[i][j+1] && (s(i) == x || x == '.')。这是本题目的精妙之处。

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
