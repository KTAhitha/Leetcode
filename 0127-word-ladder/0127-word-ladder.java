class Pair{
    String word;
    int count;
    Pair(String word, int count) {
        this.word = word;
        this.count = count;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        if(set.contains(beginWord)) set.remove(beginWord);
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int c = p.count;
            String s = p.word;
            if(s.equals(endWord)) return c;
            for(int i=0;i<s.length();i++) {
                StringBuilder w = new StringBuilder(s);
                for(char ch = 'a';ch<='z';ch++) {
                    w.setCharAt(i,ch);
                    String s1 = w.toString();
                    if(set.contains(s1)) {
                        q.add(new Pair(s1,c+1));
                        set.remove(s1);
                    }
                }
            }
        }
        return 0;
    }
}