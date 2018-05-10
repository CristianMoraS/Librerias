package Arbol;

public class Tree {
	NodeTree root = null;
	/** -- EMPTY -- **/
	public boolean isEmpty() {
		return root == null ? true : false;
	}
	/** -- INSERT -- **/
	public void insert(int value) {
        if (isEmpty()) {
            root = new NodeTree(value);
        } else {
            NodeTree temp = root; //only to find the space for insertion
            NodeTree parent = root;
            while (temp != null) {
                parent = temp;
                if (temp.value > value) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }
            if (parent.value < value) {
                parent.right = new NodeTree(value);
            } else {
                parent.left = new NodeTree(value);
            }
        }
    }
		
//		boolean flag = true;
//		Node temp = root;
//		if(root == null) {
//			root = value;
//		}else {
//			while(flag) {
//				if(value.value < temp.value) {
//					if(temp.left == null) {
//						temp.left = value;
//						flag = false;
//					}else {
//						temp = temp.left;
//					}
//					
//				}else {
//					if(temp.right == null) {
//						temp.right = value;
//						flag = false;
//					}else {
//						temp = temp.right;
//					}
//					
//				}
//			}
//		}
//		if(isEmpty()) {
//			root = value;
//		}else {
//			Node temp = root;
//			Node parent = temp;
//			while(temp != null) {
//				
//				if(value.value < temp.value) {
//					temp = temp.left;
//				}else {
//					temp = temp.right;
//				}
//			}
//			if(parent.value > value.value) {
//				parent = parent.right;
//			}else {
//				parent = parent.left;
//			}
//		}
		
	/** -- DELETE -- **/
	public void delete(int value)
	{
		NodeTree temp = root;
		NodeTree parent = root;
		while(temp != null) {
			if(temp.value == value)
				break;
			else
			{
				parent = temp;
			if(value < temp.value)
				temp = temp.left;
			else 
				temp = temp.right;
			}
		}
		if(temp == null)
		{
			System.out.println("No existe");
		}else {
			if(isLeaf(temp))
			{
				temp = null;
				if(value < parent.value)
				
					parent.left = null;
				else 
					parent.right = null;
			}
			else{
				if(oneChild(temp))
				{
					if(temp.left != null)
					{
						if(value < parent.value)
							parent.left = temp.left;
						else
							parent.right = temp.right;
					}
					temp = null;
				}
				else {
					NodeTree temp2 = temp.right;
					if(temp2 .left == null) {
						temp2.left = temp.left;
						if(value < parent.value) {
							parent.left = temp2;
						}else {
							parent.right = temp2;
						}
					}
				}
			}
		}
	}
	/** -- LEAF -- **/
	public boolean isLeaf(NodeTree newNode) {
		return(newNode.left == null && newNode.right == null) ? true : false ;
	}
	/** -- ONECHILD -- **/
	public boolean oneChild(NodeTree newNode)
	{
		return (newNode.left != null && newNode.right != null) ? true : false;
	}
	
//	public boolean twoChild(Node newNode)
//	{
//		return();
//	}
	/** -- SEARCH -- **/
	public NodeTree search(int srh) {
		NodeTree temp = root;
		while(temp != null) {
			if(temp.value == srh)
				break;
			if(srh < temp.value)
				temp = temp.left;
			else 
				temp = temp.right;
		}
		return temp;
	}
	
	/** -- PRE-ORDEN -- **/
	public void print_Pre (NodeTree newNode) {
		if(newNode != null)
		{
			System.out.println(newNode.toString());
			print_Pre(newNode.left);
			print_Pre(newNode.right);
		}
	}
	/** -- POS-ORDEN -- **/
	public void print_Pos (NodeTree newNode) {
		if(newNode != null)
		{
			print_Pos(newNode.left);
			print_Pos(newNode.right);
			System.out.println(newNode.toString());
		}
	}
	/** -- IN-ORDEN -- **/
	public void print_In (NodeTree node) {
		if(node != null)
		{
			print_In(node.left);
			System.out.println(node.value);
			print_In(node.right);
		}
	}
	/** -- MAIN -- **/
	
	public static void main(String[] args) {
		Tree tr = new Tree ();
		tr.insert(72);
		tr.insert(20);
		tr.insert(12);
		tr.insert(22);
		tr.insert(83);
		tr.print_In(tr.root);
	}
}
