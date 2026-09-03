class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int lon=0;
        for(int s:set){
            if(!set.contains(s-1)){
                int ans=1;
                int cur=s;
                while(set.contains(cur+1)){
                    cur++;
                    ans++;
                }
                lon=Math.max(lon,ans);
            }
        }
        return lon;
    }
}