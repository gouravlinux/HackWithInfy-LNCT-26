class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // using BFS
        Set<String> visited = new HashSet<>();
        Set<String> wordSet = new HashSet<>();
        for(String string: wordList){
            wordSet.add(string);
        }
        Queue<String> que = new LinkedList<>();
        que.add(beginWord);
        visited.add(beginWord);
        int levels = 0;
        while(!que.isEmpty()){
            int n = que.size();
            while(n-->0){
                String str = que.poll();
                if(str.equals(endWord)){
                    return levels+1;
                }
                for(int i = 0;i < str.length();i++){
                    for(int j = 0;j < 26;j++){
                        char ch = (char)(j+'a');
                        String newString = str.substring(0,i)+ch+str.substring(i+1,str.length());
                        if(!visited.contains(newString) && wordSet.contains(newString)){
                            que.add(newString);
                            visited.add(newString);
                        }
                    }
                }
                
            }
            levels++;
        }
        return 0;
    }
}
