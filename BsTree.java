
public class BsTree implements RootOfBsTree
{
	class Node
	{
		int val;
		Node left  = null;
		Node right = null;
		
		public Node(int val)
		{
			this.val = val;
		}		
	}
	
	Node root = null;
	
	@Override
	public void init(int[] ini)
	{
		if(ini == null)
			throw new IllegalArgumentException();
			
		for(int val : ini)
		{
			add(val);
		}
	}
	
	@Override
	public void clear()
	{
		root = null;
	}
	
	@Override
	public void add(int val)
	{
		if( root == null)
		{
			
			root = new Node(val);
			return;
		}
		addNode( root, val);
	}
	
	private void addNode( Node p, int val )
	{
		if(val < p.val)
		{
			if(p.left == null)
				p.left = new Node(val);
			else
				addNode(p.left, val);
		}
		else
		{
			if(p.right == null)
				p.right = new Node(val);
			else
				addNode(p.right, val);
		}
	}
	
	@Override
	public void print()
	{
		printNode( root );
	}
	
	private void printNode( Node p )
	{
		if( p == null)
			return;
		
		printNode(p.left);      			//L
		System.out.print( p.val + "," );	//V
		printNode(p.right);					//R
	}
	
	@Override
	public int size()
	{
		return sizeNode(root);
	}
	
	private int sizeNode( Node p )
	{
		if(p == null)
			return 0;
		
		int ret = 0;
		
		ret += sizeNode(p.left);
		ret++;
		ret += sizeNode(p.right);
			
		return ret;
	}
	
	@Override
	public int leaves()
	{
		return countLeaves(root);		
	}
	
	private int countLeaves( Node p )
	{
		if(p == null)
			return 0;
		
		int ret = 0;
		
		ret += countLeaves(p.left);
		
		if( p.left == null && p.right == null)
		{
			ret++;
		}
		
		ret += countLeaves(p.right);
		
		return ret;	
	}
	
	@Override
	public int nodes()
	{
		return countNodes( root );
	}
	
	private int countNodes( Node p )
	{
		if(p == null)
			return 0;		
		
		int ret = 0;
		
		ret += countNodes(p.left);
		
		if( p.left != null || p.right != null)
		{
			ret++;
		}
		
		ret += countNodes(p.right);
		
		return ret;
	}
	
	class Counter
	{
		int i = 0;
	}
	@Override
	public int[] toArray()
	{
		int[] ret = new int[size()];
		
		toArray(root, ret, new Counter());
		
		return ret;
	}
	
	private void toArray(Node p, int[] ret, Counter ii)
	{		
		if(p == null)
			return;
		
		toArray(p.left, ret, ii);
		ret[ii.i++] = p.val;
		toArray(p.right, ret, ii);	
	}	
	
	@Override
	public String toString()
	{
		return toString( root ).trim();
	}
	
	private String toString( Node p )
	{
		if( p == null)
			return "";
		
		return toString(p.left) + p.val + ", " + toString(p.right);
	}

	@Override
	public void reverse()
	{
		reverseNodes( root );		
	}
	
	private void reverseNodes( Node p )
	{
		if(p == null)
			return;
		
		Node tmp = p.right;
		p.right = p.left;
		p.left = tmp;
		
		reverseNodes( p.left );
		
		reverseNodes( p.right );		
	}

	@Override
	public int height()
	{
		return heightOfTree( root );
	}
	
	private int heightOfTree( Node p )
	{
		if(p == null)
			return 0;
		
		return 1 + Math.max(heightOfTree(p.left), heightOfTree(p.right));
	}

	@Override
	public int width()
	{
		int[] ar = new int[height() + 1];
		nodeWidth(root, ar, 0);		
		return max(ar);
	}
	
	private void nodeWidth( Node p, int[] ar, int i )
	{
		if(p == null)
			return;
		
		nodeWidth(p.left, ar, i + 1);
		ar[i]++;
		nodeWidth(p.right, ar, i + 1);
	}
	
	private int max( int[] ar )
	{
		int ret = ar[0];
		
		for (int i = 1; i < ar.length; i++) 
		{
			if(ar[i] > ret)
			{
				ret = ar[i];
			}
		}
		return ret; 
	}

	@Override
	public void del(int val)
	{
		Node p = findNode(root, val);
		if(p.left == null && p.right == null)
		{
			if(p == root)
				root = null;
			else
			{
				Node owner = findOwner(root, val);
			}
		}
		delNode(p);
	}

	private void delNode(Node p) 
	{
		delNodeLeft(p);
		delNodeRight(p);
	}

	private void delNodeLeft(Node p) 
	{
		Node tmp = p.left;
		
		if(tmp.left == null)
		{
			p.val = tmp.val;
			p.left = tmp.left;
			return;
		}
		
		while(tmp.right.right != null)
		{
			tmp = tmp.right;
		}
		p.val = tmp.right.val;
		tmp.right = tmp.right.left;
	}
	
	private void delNodeRight(Node p) 
	{
		Node tmp = p.right;

		if(tmp.left == null)
		{
			p.val = tmp.val;
			p.right = tmp.right;
			return;
		}

		while(tmp.left.left != null)
		{
			tmp = tmp.left;
		}
		p.val = tmp.left.val;
		tmp.left = tmp.left.right;
	}

	private Node findNode(Node p, int val)
	{
		Node ret = null;

		if(p.val == val)
			ret = p;
		else if(val < p.val)
			ret = findNode(p.left, val);
		else 
			ret = findNode(p.right, val);
		return ret;
	}
	
	private Node findOwner(Node p, int val)
	{
		Node ret = null;
		
		if(p.left.val == val || p.right.val == val)
			ret = p;
		else if(val < p.val)
			ret = findNode(p.left, val);
		else
			ret = findNode(p.right, val);
		return ret;
	}
}
