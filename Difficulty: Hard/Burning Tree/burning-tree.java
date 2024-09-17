//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    private static void markPresent(Node root,HashMap<Node,Node> parentM){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.left!=null){
                parentM.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                parentM.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
    }
    public static Node findNode(Node root,int target){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.data==target){
                return curr;
            }
            if(curr.left!=null){
                q.offer(curr.left);
            }
            if(curr.right!=null){
                q.offer(curr.right);
            }
        }
        
        return null;
    }
    public static int minTime(Node root, int target) 
    {
        HashMap<Node,Node> parentM = new HashMap<>();
        markPresent(root,parentM);
        HashMap<Node,Boolean> vis = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        // Node tar = new Node(0);
        Node tar = findNode(root,target);
        q.offer(tar);
        vis.put(tar,true);
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            count++;
            for(int i = 0;i<size;i++){
                Node curr = q.poll();
                
                if(curr.left!=null && vis.get(curr.left)==null){
                    q.offer(curr.left);
                    vis.put(curr.left,true);
                }
                if(curr.right!=null && vis.get(curr.right)==null){
                    q.offer(curr.right);
                    vis.put(curr.right,true);
                }
                if(parentM.get(curr)!=null && vis.get(parentM.get(curr))==null){
                    q.offer(parentM.get(curr));
                    vis.put(parentM.get(curr),true);
                }
            }
            
        }
        return count-1;
    }
}