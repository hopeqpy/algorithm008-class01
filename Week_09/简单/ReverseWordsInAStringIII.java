package 简单;

/**
 * @program: algorithm
 * @description: 反转字符串
 * @author: qpy
 */
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder result=new StringBuilder();
        for (String word: words)
            result.append(new StringBuffer(word).reverse().toString() + " ");
        return result.toString().trim();
    }

}
