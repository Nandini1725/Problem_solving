class Solution {
    public class tuple{
        TreeNode node;
        int v;
        int level;
        tuple(){}
        tuple(TreeNode node, int v, int level){
            this.node = node;
            this.v = v;
            this.level=level;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<tuple> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        q.add(new tuple(root,0,0));
        while(!q.isEmpty()){
            tuple t = q.remove();
            TreeNode temp = t.node;
            int v = t.v;
            int level= t.level;

            if(!map.containsKey(v))
            map.put(v, new TreeMap<>());
            if(!map.get(v).containsKey(level))
            map.get(v).put(level, new PriorityQueue<>());

            map.get(v).get(level).add(temp.val);

            if(temp.left!=null)
            q.add(new tuple(temp.left, v-1, level+1));

            if(temp.right!=null)
            q.add(new tuple(temp.right, v+1, level+1));
        }
        for(TreeMap<Integer, PriorityQueue<Integer>> entry : map.values()){
            list.add(new ArrayList<>());
            for (PriorityQueue < Integer > nodes: entry.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;

    }
}
