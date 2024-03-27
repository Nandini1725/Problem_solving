class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public class pair{
        Node node;
        int line;
        pair(){}
        pair(Node node, int line){
            this.node=node;
            this.line = line;
        }
    }
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<pair> q = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        if(root==null) return ans;
        
        q.add(new pair(root,0));
        while(!q.isEmpty()){
            pair p = q.remove();
            Node temp = p.node;
            int line = p.line;
            
            map.put(line,temp.data);
            if(temp.left!=null)
            q.add(new pair(temp.left,line-1));
            
            if(temp.right!=null)
            q.add(new pair(temp.right,line+1));
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
