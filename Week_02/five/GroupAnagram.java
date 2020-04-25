package five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: algorithm
 * @description: 字母异位词组
 */
public class GroupAnagram {


    /**
     * 计算出每个数字中字母的
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String temp = strs[i];
            char[] chars = temp.toCharArray();
            Arrays.sort( chars );
            String change = String.valueOf( chars );
            if (map.containsKey( change )) {
                map.get( change ).add( strs[i] );
            } else {
                List<String> list = new ArrayList<>();
                list.add( strs[i] );
                map.put( change, list );
            }
        }
        return map.values().size()==0? null:map.values().stream().collect( Collectors.toList() );
    }
}
