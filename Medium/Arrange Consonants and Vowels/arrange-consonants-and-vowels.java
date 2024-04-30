//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    Node head = null, tail = null;
		    
		    char head_c = sc.next().charAt(0);
		    head = new Node(head_c);
		    tail = head;
		    
		    while(n-- > 1){
		        tail.next = new Node(sc.next().charAt(0));
		        tail = tail.next;
		    }
		    
		    Solution obj = new Solution();
		    //show(head);
		    show(obj.arrangeCV(head));
		    
		}
	}
	
	public static void po(Object o){
	    System.out.println(o);
	}
	
	public static void show(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
    public Node arrangeCV(Node head){
        
        Node dummy = head;
        ArrayList<Character> vowels = new ArrayList<>();
        ArrayList<Character> conso = new ArrayList<>();

        while(head!=null){
            if(head.data=='a'||head.data=='e'||head.data=='i'||head.data=='o'||head.data=='u')
            vowels.add(head.data);
            else
            conso.add(head.data);
            
            head = head.next;
        }
        
        Node ans = new Node('x');
        Node p = ans;
        for(int i = 0;i<vowels.size();i++){
            ans.next = new Node(vowels.get(i));
            // if(i!=vowels.size()-1)
            ans = ans.next;
        }
        for(int i = 0;i<conso.size();i++){
            ans.next = new Node(conso.get(i));
            // if(i!=conso.size()-1)
            ans = ans.next;
        }
        return p.next;
        
    }
}