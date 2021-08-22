class DeepestLeavesSum {
  int h=-(int)1e9;
  int sum =0;
    public int deepestLeavesSum(TreeNode root) {
        //   // Approach 1:
        // int h = height(root);
        // int sum = sumDeepestNode(root,0,h);
        // return sum;
      
      deepestNodesSum(root,0);
     return sum;
    }
  
    private void deepestNodesSum(TreeNode node, int level){
      if(node==null) return;
      
      if(level==h){
        sum+=node.val;
      }
      
      if(level>h){
        h=level;
        sum=node.val;
      }
      
      deepestNodesSum(node.left,level+1);
      deepestNodesSum(node.right,level+1);
      
    }
  
  
  
  
  private int sumDeepestNode(TreeNode node, int level,int h){
    int s = 0;
    
    if(node==null) return 0;
    
    if(node.left == null && node.right== null && level==h) return node.val;
    
    int leftSum = sumDeepestNode(node.left,level+1,h);
    int rightSum= sumDeepestNode(node.right,level+1,h);
    
    return leftSum+rightSum;
    
  }
  
  private int height(TreeNode node){
    if(node==null) return -1;
    
    return Math.max(height(node.left) , height(node.right)) +1;
    
  }
}