package src;

import java.util.ArrayList;
import java.util.List;

public class leetcode46 {
    public static void main(String[] args) {
        
    }

    public static List<List<Integer>> permute(int[] nums) {
        // 找到所有可能的顺序
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> allOrder = findAllOrder(visited);
        // 根据order产生ans
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        for(List<Integer> order: allOrder){
            ArrayList<Integer> anslist = new ArrayList<Integer>();
            for (int i = 0; i < order.size(); i++) {
                anslist.add(nums[order.get(i)]);
            }
            ans.add(anslist);
        }
        return ans;
    }

    // 递归方法：
    public static List<List<Integer>> findAllOrder(boolean[] visited){
        // 整合到order数组中
        List<List<Integer>> order = new ArrayList<>();
        // 还有多少个没有被排序
        for (int i = 0; i < visited.length; i++) {
            // 如果没有访问过
            if(!visited[i]){
                // 先递归
                visited[i] = true;
                List<List<Integer>> subOrder = findAllOrder(visited);
                // 再将该位置元素加到list,将一维list添加到二维order
                if(subOrder.size() == 0){
                    // 特殊情况：若visited全部为true,findAllOrder返回的为一个空的二维list
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    order.add(list);
                }else{
                    for(List<Integer> list: subOrder){
                        list.add(i);
                        order.add(list);
                    }
                }
                visited[i] = false;

            }
        }
        return order;
    }
}
