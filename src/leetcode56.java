package src;
import java.util.*;
public class leetcode56 {
    public static void main(String[] args) {

    }

    public static int[][] merge(int[][] intervals) {

        // merged存储最终的答案，但是一会还得转化为int[][]
        ArrayList<int[]> merged = new ArrayList<>();

        // 给intervals排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 将排序号的intervals中的int[2]通过对比放入merged
        merged.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            // 取出tmp与merged中最新的元素
            int[] tmp = intervals[i];
            int[] lastMerge = merged.get(merged.size() - 1);
            // 判断与更新的逻辑
            if(tmp[0] <= lastMerge[1]){
                lastMerge[1] = Math.max(lastMerge[1], tmp[1]);
                merged.set(merged.size() - 1, lastMerge);
            }else{
                merged.add(tmp);
            }
        }

        // 将merged转化为int[][]
        int[][] ans = new int[merged.size()][2];
        for(int i = 0; i < ans.length; i++){
            ans[i] = merged.get(i);
        }

        return ans;
    }
}
