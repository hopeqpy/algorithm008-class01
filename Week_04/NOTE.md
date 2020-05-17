深度优先搜索 DFS
可以使用递归实现，
也可以通过自行维护栈来实现
代码模板 
visited = set()
def dfs(node, visited):
    visited.add(node)
    #process current node here.
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited)
            
广度优先搜索 BFS
可以借助队列来实现
代码模板
def BFS(graph, start, end):
    queue = []
    queue.append([start])
    visited.add(start)
    while queue:
        node = queue.pop()
        visited.add(node)
        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)  
    # other processing work
    ...
    
贪心算法
概念：
贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。

与动态规划的区别：
贪心算法对每个字问题的解决方案都做出选择，不能回退。
动态规划则保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

贪心发可以解决一些最优化问题，如：求图中的最小生成树，求哈夫曼编码等。
对于工程和生活中的问题，贪心法一般不能得到我们所要求的答案。
一旦一个问题可以通过贪心法来解决，那么贪心法一般是解决这个问题的最好办法。
由于贪心法的高效性以及其所求得的答案比较接近最优结果，贪心法也可以用作辅助算法或者直接解决一些要求结果不特别精确的问题。
适用场景：简单地说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。

二分查找
条件：
目标函数单调性（单调递增或者递减）
存在上下界（bounded）
能够通过索引访问（index accessible）
代码模板
left, right = 0, len(array) - 1
while left <= right:
    mid = (left + right) / 2
    if array[mid] == target:
        # find the target!!
        break or return result
    elif array[mid] < target:
        left = mid + 1
    else:
        right = mid - 1
注意事项
原理较简单，需要多练习，形成肌肉记忆；
边界处理需注意，在计算中值时，也需要关注对应编程语言除2后的取值情况。