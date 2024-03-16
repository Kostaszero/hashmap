class HashMap {
    
    public Node insert(Node root,int key,int value){
        if(root==null) return new Node(key,value);
        else{
            if(key<root.key) root.left=insert(root.left,key,value);
            else if(key>root.key) root.right=insert(root.right,key,value);
            else{
                root.val=value;
            }
        }
        return root;
    }
    
    public int search(Node root,int ele){
        if(root==null) return -1;
        if(root.key==ele) return root.val;
        else if(ele<root.key) return search(root.left,ele);
        return search(root.right,ele);
        
    }
    
    public Node delete(Node root,int ele){
        if(root==null) return root;
        if(ele<root.key){
            root.left=delete(root.left,ele);
            return root;
        }
        else if(ele>root.key){
            root.right=delete(root.right,ele);
            return root;
        }
        if(root.left==null) return root.right;
        else if(root.right==null) return root.left;
        int in[]=getmax(root.left);
        root.key=in[0];
        root.val=in[1];
        root.left=delete(root.left,root.key);
        return root;
    }
    
    public int[] getmax(Node root){
        if(root.right==null) return new int[]{root.key,root.val};
        return getmax(root.right);
    }
    
    
    
    public Node root[];
    public MyHashMap() {
        this.root=new Node[10];
    }
    
    public void put(int key, int value) {
        int k=hash(key);
        root[k]=insert(root[k],key,value);
    }
    
    public int hash(int key){
        return key%10;
    }
    
    public int get(int key) {
        int k=hash(key);
        return search(root[k],key);
    }
    
    public void remove(int key) {
        int k=hash(key);
        root[k]=delete(root[k],key);
    }
}
class Node{
    int key;
    int val;
    Node left;
    Node right;
    Node(int key,int val){
        this.val=val;
        this.key=key;
        this.left=this.right=null;
    }
}
