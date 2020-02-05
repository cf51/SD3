public class BinarySearchTree {
	
	private class BSTNode { // private class to hold a tree node

		private int value;
		private BSTNode leftChild; // left subtree
		private BSTNode rightChild; // right subtree

		public BSTNode(int v) {
			value = v;
			leftChild = null;
			rightChild = null;
		}

		public BSTNode getLeftChild() {
			return leftChild;
		}

		public BSTNode getRightChild() {
			return rightChild;
		}

		public void setLeftChild(BSTNode n) {
			leftChild = n;
		}

		public void setRightChild(BSTNode n) {
			rightChild = n;
		}

		public int getValue() {
			return value;
		}

		// inserting nodes
		public void insert(BSTNode n) {
			// insert somewhere into the left subtree
			if (n.value < this.value) {
				if (this.getLeftChild() == null) {
					// add node n as left child
					this.setLeftChild(n);
				} else {
					// otherwise recurse down the left subtree
					this.getLeftChild().insert(n);
				}
			}

			// insert somewhere into the right subtree
			else if (n.value > this.value) {
				if (this.getRightChild() == null) {
					// add node n as right child
					this.setRightChild(n);
				} else {
					// otherwise recurse down the right subtree
					this.getRightChild().insert(n);
				}
			}

			// a duplicate which we don't allow (could also raise exception)
			else {
				return;
			}
		}

		// lookup a node
		public boolean search(int v) {
			// lookup somewhere into the left subtree
			if (v < this.value) {
				if (this.getLeftChild() == null) {
					// value v cannot be in the tree 
					return false;
				} else {
					// otherwise recurse down the left subtree
					return this.getLeftChild().search(v);
				}
			} else if (v > this.value) {
				if (this.getRightChild() == null) {
					// value v cannot be in the tree 
					return false;
				} else {
					// otherwise recurse down the right subtree
					return this.getRightChild().search(v);
				}
			}

			// otherwise this.value == v
			return true;
		}

		// useful for the delete method
		public BSTNode getLargestValueNode() {
			// decend down the right subtree until we get the largest value.
			// i.e. until we cannot continue to go down the right subtree
			if (this.getRightChild() == null) {
				return this;
			} else {
				return this.getRightChild().getLargestValueNode();
			}
		}

		// deleting a node with the given value
		public BSTNode delete(int v) {
			// this is not the node we want to remove
			if (v != this.value) {
				// go right?
				if (v > this.value && this.getRightChild() != null) {
					// we're going to update our right child reference
					this.rightChild = this.getRightChild().delete(v);
					return this;
				}
				
				// go left?
				else if (v < this.value && this.getLeftChild() != null) {
					// we're going to update our left child reference
					this.leftChild = this.getLeftChild().delete(v);
					return this;
				}
				
				// we are trying to delete a non-existent value
				else {
					return this;
				}
			}
			
			// this is the node we want to remove
			else {
				// difficult case: does it have two children?
				if (this.getLeftChild() != null && this.getRightChild() != null) {
					
					// step 1: find the largest value in the left subtree
					BSTNode largestLeft = this.getLeftChild().getLargestValueNode();
					
					// step 2: set this node's value to the value of the largest left node value
					this.value = largestLeft.getValue();
					
					// step 3: delete the largest node on left then set Node returned as left child.
					this.leftChild = this.getLeftChild().delete(largestLeft.getValue());
					
					return this;
				}
				
				// the easy cases
				
				// has only left subtree
				else if (this.getLeftChild() != null) {
					// return to the parent node what this node's left child is
					return this.getLeftChild();
				}
				
				// has only right subtree
				else if (this.getRightChild() != null) {
					// return to the parent node what this node's right child is
					return this.getRightChild();
				}
				
				// has no subtrees (is a leaf node)
				else {
					System.out.println("Deleting Node with value " + this.value);
					return null;
				}
			}
		}

		public int numberOfNodes() {
			int valueToReturn = 1; // this is 1 to count this node
			if (leftChild != null)
				valueToReturn += leftChild.numberOfNodes(); // add the nodes in the left subtree
			if (rightChild != null)
				valueToReturn += rightChild.numberOfNodes(); // add the nodes in the right subtree
			return valueToReturn; // return the number of nodes
		}
		
		// Part 1: complete	
		public void inOrderTraversal(){
			
			if(this.leftChild != null)  //orders the children to the left hand side, if it is not empty 
				leftChild.inOrderTraversal(); //recursivly calls itself to order the left hand side 
			
			
			System.out.println(this.value); //prints out the value to console

			if(this.rightChild != null)  //orders the children to the right hand side, if it is not empty 
				rightChild.inOrderTraversal(); //recursivly calls itself to order the right hand side 
		
			

	}	
		
		public void inOrderTraversal(DLinkedList dLL) {
			
			if(this.leftChild != null)  //orders the children to the left hand side, if it is not empty 
				this.leftChild.inOrderTraversal(dLL); //recursivly calls itself to order the left hand side
			
			
			dLL.addAtTail(this.value); //moves it to the start of the list (order, move, order) 
			
			if(this.rightChild != null)  //orders the children to the right hand side, if it is not empty 
				this.rightChild.inOrderTraversal(dLL); //recursivly calls itself to order the right hand side
		
	}
}

	private BSTNode rootNode = null;

	public void insert(int v){ 
		if (rootNode == null){
			rootNode = new BSTNode(v);
		}else{
			rootNode.insert(new BSTNode(v));
		}
	}

	public void delete(int v){
		if (rootNode != null){
			rootNode = rootNode.delete(v);
		}
	}

	public boolean search(int v){
		if (rootNode != null){
			return rootNode.search(v);
		}else{
			return false;
		}
	}

	public boolean isEmpty() {
		return (rootNode == null);
	}

	public int size() {
		if (rootNode == null) {
			return 0;
		} else {
			return rootNode.numberOfNodes();
		}
	}
	
	// Part 1
	public void inOrderTraversal(){
		
		if(rootNode != null) {
			rootNode.inOrderTraversal(); 
	}
}

	// Part 2: complete
	public DLinkedList returnInOrderTraversal(){
		
		DLinkedList dLL = new DLinkedList(); //creates new linked list 
		
		if (rootNode != null) //if the rootnode isnt empty 
			rootNode.inOrderTraversal(dLL); //orders the linked list using recursion 
		
		
		return dLL; //returns dLL
	}

	public static void main(String[] args){

		System.out.println("******* Tree 1 : 3 nodes ***********");
		BinarySearchTree bst1 = new BinarySearchTree();
		bst1.insert(1);
		bst1.insert(4);
		bst1.insert(3);
		bst1.insert(2);
		bst1.inOrderTraversal();

		System.out.println("******* Tree 2 : 1 node ***********");		
		BinarySearchTree bst2 = new BinarySearchTree();
		bst2.insert(1);
		bst2.inOrderTraversal();

		System.out.println("******* Tree 3 : empty ***********");		
		BinarySearchTree bst3 = new BinarySearchTree();
		bst3.inOrderTraversal();

	}
}
