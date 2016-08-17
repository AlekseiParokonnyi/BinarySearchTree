
public interface RootOfBsTree
{
	void init(int[] ini);
	void clear();
	void add(int val);
	int size();
	int leaves();
	int nodes();
	void print();
	
	String toString();
	int[] toArray();
	
	void reverse();
	int height();
	int width();
	void del(int val);	
}
