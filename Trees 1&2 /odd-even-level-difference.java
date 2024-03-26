
class Solution
{
	int getLevelDiff(Node root)
	{
	    //code here
	    int odd = 0;
	    int even =0;
	    int ans=0;
	    
	    int level=0;
	    int nodes = 0;
	    Queue<Node> q = new LinkedList<>();
	    
	    if(root==null){
	        return 0;
	    }
	    
	    else{
	        q.add(root);
	        level++;
	        while(q.size()!=0){
	            nodes = q.size();
	            while(nodes>0){
	            Node current = q.remove();
	            
	            if(level%2==0)
	            even+=current.data;
	            else
	            odd+=current.data;
	            
	            if(current.left!=null)
	            q.add(current.left);
	            
	            if(current.right!=null)
	            q.add(current.right);
	            
	            nodes--;
	        }
	        level++;
	        }
	        ans = odd-even;
	    }
	    return ans;
	}
}
