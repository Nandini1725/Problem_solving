class Solution
{
    static class pair {
        Node node;
        int hd;
 
        pair() {}
        pair(Node node, int hd)
        {
            this.node = node;
            this.hd = hd;
        }
    }
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> ans = new ArrayList<>(); 
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<pair> q = new LinkedList<pair>();
        q.add(new pair(root, 0)); 
        while(!q.isEmpty()) {
            pair it = q.remove();
            int hd = it.hd; 
            Node temp = it.node; 
            if(map.get(hd) == null) map.put(hd, temp.data); 
            if(temp.left != null) {
                
                q.add(new pair(temp.left, hd - 1)); 
            }
            if(temp.right != null) {
                
                q.add(new pair(temp.right, hd + 1)); 
            }
        }
    
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); 
        }
        return ans; 
        
    }
}
