高级动态规划
复习：
1.动态规划复习；附带递归，分治
2.多种情况的动态规划的状态转移方程串讲
3.高阶动态规划的习题
递归、分治、回溯、动态规划复习
1.1 递归 - 函数自己调用自己
递归代码模板
public void recur(int level, int param) {
    // terminator
    if (level > MAX_LEVEL) {
        // prcess result
        return;
    }
    // process current logic
    process(level, param);
    // drill down
    recur(level:level + 1, newParam);
    // restore current status
}
1.2 分治
分治代码模板
def devide_conquer(problem, param1, param2, ...):
    # recursion terminator
    if problem is None:
        print_result
        return
    # prepare data  准备数据，拆分子问题
    data = perpare_data(problem)
    subproblems = split_problem(problem, data)
    # conquer subproblems
    subresult1 = self.divede_conquer(subproblems[0], p1, ...)
    subresult2 = self.devide_conquer(subproblems[1], p1, ...)
    subresult3 = self.devide_conquer(subproblems[2], p1, ...)
    ...
    # process and generate the final result
    result = process_result(subresult1, subresult2, subresult3, ...)
    # revert the current level states

总结：
1.人肉递归低效、很累
2.找到最近最简方法，将其拆解成可重复解决的问题
3.数学归纳法思维
本质：寻找重复性 --> 计算机指令集


动态规划 Dynamic Programming
“Simplifying a complicated problem by breaking it down into simpler sub-problems”(in a recursive manner)
Divide & Conquer + Optimal substructure 分治 + 最优子结构
顺推形式: 动态递推
DP 顺推模板
function DP():
    dp = [][] # 二维情况
    for i = 0 .. M {
        for j = 0 .. N {
            dp[i][j] = _Function(dp[i][j]...)
        }
    }
    return dp[M][N];
关键点
动态规划 和 递归或者分治 没有根本上的区别(关键看有无最优的子结构) 拥有共性:找到重复子问题

差异性:最优子结构、中途可以淘汰次优解

常见的 DP 题目和状态方程
爬楼梯
不同路径
打家劫舍
最小路径和
股票买卖
高阶的 DP 问题
复杂度来源
状态拥有更多维度(二维、三维、或者更多、甚至需要压缩)
状态方程更加复杂
本质:内功、逻辑思维、数学

编辑距离
如果 word1[i] 与 word2[j] 相同，显然 dp=dp[i-1][j-1]
如果 word1[i] 与 word2[j] 不同，那么 dp[i][j] 可以通过
1 在 dp[i-1][j-1] 的基础上做 replace 操作达到目的
2 在 dp[i-1][j] 的基础上做 insert 操作达到目的
3 在 dp[i][j-1] 的基础上做 delete 操作达到目的
取三者最小情况即可
不同路径 2 

1.状态 地图上的点
2.动作 移动  只能向右以及向下
3.结果 走到该点的路径数
d[i][j] 代表 坐标 x y轴 
d[i][j] = dp[i-1][j] + dp[i][j-1](i>=1,j>=1)
d[0][0] =0 ;
很显然  边界问题
i=0 dp[i][j] = dp [i][j-1]
j=0 dp[i][j] = dp [i-1][j]




