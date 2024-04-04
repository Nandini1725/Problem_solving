class Solution
{
    public List<Integer> merge(Node root1,Node root2)
    {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        
        while(root1!=null || root2!=null || !stack1.isEmpty() || !stack2.isEmpty()){
            while(root1!=null){
                stack1.push(root1);
                root1=root1.left;
            }
            while(root2!=null){
                stack2.push(root2);
                root2=root2.left;
            }
            if(stack2.isEmpty() || (!stack1.isEmpty() && (stack1.peek().data <= stack2.peek().data))){
                root1 = stack1.peek();
                stack1.pop();
                list.add(root1.data);
                root1= root1.right;
            }
            else{
                root2=stack2.peek();
                stack2.pop();
                list.add(root2.data);
                root2=root2.right;
            }
        }
        return list;
        
    }
}
