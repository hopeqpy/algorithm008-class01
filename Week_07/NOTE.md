字典树和并查集
字典树 Trie
基本结构：
字典树是一种树形结构。
应用场景：用于统计和排序大量的字符串(但不仅限于字符串)，所以经常被搜索引擎系统用于文本词频统计。
它的优点是：最大限度的减少无谓的字符串比较，查询效率比哈希表高。
基本性质：
结点本身不存完整单词；
从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串；
每个结点的所有子结点路径代表的字符都不相同。
核心思想
Trie 树的核心思想是空间换时间。
利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。

并查集 Disjoint Set
适用场景
朋友圈，配对问题等
一般包含该的操作方法：
makeSet(n):建立一个新的并查集，其中包含n个单元素集合。
unionSet(x, y):把元素x和元素 y 所在的集合合并，合并不相交，相交不合并。
find(x):找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合
，只要将它们各自的代表比较一下就可以了，在此可以进行路径压缩。

第14课-高级搜索
剪枝：将不必要的减去
通常在回溯法运用剪枝
回溯法采用试错的思想，它尝试分步的去解决一个问题，并在解决问题的过程中，当发现当前步骤不能得到正确的答案，将上一步甚至几步的计算进行剪枝
，然后尝试通过其他分步在此选择问题的答案；
双向 BFS
启发式搜索(A*)
基于BFS代码，通过是估价函数*，有点类似于Mysql查询的估价查询
估价函数
启发式函数: h(n)，它用来评价哪些结点最有希望的是一个我们要找的结点，h(n) 会返回一个非负实数,也可以认为是从结点n的目标结点路径的估计成本。
启发式函数是一种告知搜索方向的方法。它提供了一种明智的方法来猜测哪个邻居结点会导向一个目标。
第15课-AVL树和红黑树
出现的背景：二叉树可能退化为链表
平衡树有很多种，总结只包含了两种：
AVL数
每个节点保存平衡因子，通过4中旋转来保持左右子树的树高，因为二叉搜索树查询只与高度有关，与节点的个数没有关系； 
因为AVL数在插入以及删除等查找，涉及了大量的旋转操作，以及每个节点需要记录平衡因子，以及上下节点的关系，后来产生了红黑树
Red-black Tree
红黑树是一种近似平衡的二叉搜索树(Binary Search Tree)
，它能够确保任何一个结点的左右子树的高度差小于两倍。
具体来说，红黑树是满足如下条件的二叉搜索树：
每个结点要么是红色，要么是黑色。
根节点是黑色。
每个叶节点(NIL节点，空节点)是黑色的。
不能有相邻接的两个红色节点。
从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。
关键性质：
从根到叶子的最长的可能路径不多于最短的可能路径的两倍长。

红黑树和AVL树对比
AVL trees provide faster lookups than Red Black Trees because they are more strictly balanced.
Red Black Trees provide faster insertion and removal operations than AVL trees as fewer rotations are done due to relatively relaxed balancing.
AVL trees store balance factors or heights with each node, thus requires storage for an integer per node whereas Red Black Tree requires only 1 bit of information per node.
Red Black Trees are used in most of the language libraries like map, multimap, multiset in C++ whereas AVL trees are used in databases where faster retrievals are required.