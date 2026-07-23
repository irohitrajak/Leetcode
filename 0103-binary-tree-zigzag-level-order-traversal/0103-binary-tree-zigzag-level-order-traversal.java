class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        boolean leftToRight=true;

        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> temp=new ArrayList<>();

            while(n-->0){
                TreeNode node=q.poll();
                if(leftToRight){
                    temp.add(node.val);
                }
                else{
                    temp.add(0,node.val);
                }
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            ans.add(temp);
            leftToRight=!leftToRight;
        }
        return ans;
    }
}