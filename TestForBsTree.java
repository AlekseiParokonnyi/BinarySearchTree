import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestForBsTree
{
	
	RootOfBsTree bst = new BsTree();
	
	@Before
	public void setUp()
	{
		bst.clear();
	}
	
	//=============================================================================
	//Initialize
	//=============================================================================
	
	@Test (expected = IllegalArgumentException.class)
	public void testInitNull()
	{
		int[] ini = null;
		bst.init(ini);
	}
	
	@Test
	public void testInit_0_Length()
	{
		int[] ini = {};
		bst.init(ini);
		int[] act = bst.toArray();
		assertEquals(ini.length, bst.size());
		int[] exp = {};
		assertArrayEquals(exp, act);	
	}
	
	@Test
	public void testInit_1_Length()
	{
		int[] ini = {50};
		bst.init(ini);
		int[] act = bst.toArray();
		assertEquals(ini.length, bst.size());
		int[] exp = {50};
		assertArrayEquals(exp, act);		
	}
	
	@Test
	public void testInit_2Length()
	{
		int[] ini = {50, 25};
		bst.init(ini);
		int[] act = bst.toArray();
		assertEquals(ini.length, bst.size());
		int[] exp = {25, 50};
		assertArrayEquals(exp, act);		
	}
	
	@Test
	public void testInitManyOdd()
	{
		int[] ini = {50, 25, 11, 34, 7};
		bst.init(ini);
		int[] act = bst.toArray();
		assertEquals(ini.length, bst.size());
		int[] exp = {7, 11, 25, 34, 50};
		assertArrayEquals(exp, act);		
	}
	
	@Test
	public void testInitManyEven()
	{
		int[] ini = {50, 25, 11, 34, 7, 20, 36, 80, 100, 40};
		bst.init(ini);
		int[] act = bst.toArray();
		assertEquals(ini.length, bst.size());
		int[] exp = {7, 11, 20, 25, 34, 36, 40, 50, 80, 100};
		assertArrayEquals(exp, act);		
	}
	
	//=============================================================================
	//Clear
	//=============================================================================
	
	@Test
	public void testClear_0_Length()
	{
		int[] ini = {};
		bst.init(ini);
		bst.clear();
		int[] act = bst.toArray();
		assertEquals(0, bst.size());
		int[] exp = {};
		assertArrayEquals(exp, act);	
	}
	
	@Test
	public void testClear_1_Length()
	{
		int[] ini = {50};
		bst.init(ini);
		bst.clear();
		int[] act = bst.toArray();
		assertEquals(0, bst.size());
		int[] exp = {};
		assertArrayEquals(exp, act);		
	}
	
	@Test
	public void testClear_2Length()
	{
		int[] ini = {50, 25};
		bst.init(ini);
		bst.clear();
		int[] act = bst.toArray();
		assertEquals(0, bst.size());
		int[] exp = {};
		assertArrayEquals(exp, act);		
	}
	
	@Test
	public void testClearManyOdd()
	{
		int[] ini = {50, 25, 11, 34, 7};
		bst.init(ini);
		bst.clear();
		int[] act = bst.toArray();
		assertEquals(0, bst.size());
		int[] exp = {};
		assertArrayEquals(exp, act);		
	}
	
	@Test
	public void testClearManyEven()
	{
		int[] ini = {50, 25, 11, 34, 7, 20, 36, 80, 100, 40};
		bst.init(ini);
		bst.clear();
		int[] act = bst.toArray();
		assertEquals(0, bst.size());
		int[] exp = {};
		assertArrayEquals(exp, act);		
	}

	//=============================================================================
	//Add
	//=============================================================================
	
	@Test
	public void testAdd_0_Length()
	{
		int[] ini = {};
		bst.init(ini);
		bst.add(60);
		int[] act = bst.toArray();
		assertEquals(ini.length + 1, bst.size());
		int[] exp = {60};
		assertArrayEquals(exp, act);	
	}
	
	@Test
	public void testAdd_1_Length()
	{
		int[] ini = {50};
		bst.init(ini);
		bst.add(60);
		int[] act = bst.toArray();
		assertEquals(ini.length + 1, bst.size());
		int[] exp = {50, 60};
		assertArrayEquals(exp, act);		
	}
	
	@Test
	public void testAdd_2Length()
	{
		int[] ini = {50, 25};
		bst.init(ini);
		bst.add(30);
		int[] act = bst.toArray();
		assertEquals(ini.length + 1, bst.size());
		int[] exp = {25, 30, 50};
		assertArrayEquals(exp, act);		
	}
	
	@Test
	public void testAddManyOdd()
	{
		int[] ini = {50, 25, 11, 34, 7};
		bst.init(ini);
		bst.add(5);
		int[] act = bst.toArray();
		assertEquals(ini.length + 1, bst.size());
		int[] exp = {5, 7, 11, 25, 34, 50};
		assertArrayEquals(exp, act);		
	}
	
	@Test
	public void testAddManyEven()
	{
		int[] ini = {50, 25, 11, 34, 7, 20, 36, 80, 100, 40};
		bst.init(ini);
		bst.add(35);
		int[] act = bst.toArray();
		assertEquals(ini.length + 1, bst.size());
		int[] exp = {7, 11, 20, 25, 34, 35, 36, 40, 50, 80, 100};
		assertArrayEquals(exp, act);		
	}

	//=============================================================================
	//Size
	//=============================================================================
	
	@Test
	public void testSize_0_Length()
	{
		int[] ini = {};
		bst.init(ini);
		assertEquals(ini.length, bst.size());
	}
	
	@Test
	public void testSize_1_Length()
	{
		int[] ini = {50};
		bst.init(ini);
		assertEquals(ini.length, bst.size());		
	}
	
	@Test
	public void testSize_2Length()
	{
		int[] ini = {50, 25};
		bst.init(ini);
		assertEquals(ini.length, bst.size());		
	}
	
	@Test
	public void testSizeManyOdd()
	{
		int[] ini = {50, 25, 11, 34, 7};
		bst.init(ini);
		assertEquals(ini.length, bst.size());		
	}
	
	@Test
	public void testSizeManyEven()
	{
		int[] ini = {50, 25, 11, 34, 7, 20, 36, 80, 100, 40};
		bst.init(ini);
		assertEquals(ini.length, bst.size());		
	}

	//=============================================================================
	//Leaves
	//=============================================================================

	@Test
	public void testLeaves_0_Length()
	{
		int[] ini = {};
		bst.init(ini);
		assertEquals( 0, bst.leaves());
	}
	
	@Test
	public void testLeaves_1_Length()
	{
		int[] ini = {50};
		bst.init(ini);
		assertEquals( 1, bst.leaves());		
	}
	
	@Test
	public void testLeaves_2Length()
	{
		int[] ini = {50, 25};
		bst.init(ini);
		assertEquals( 1, bst.leaves());		
	}
	
	@Test
	public void testLeavesManyOdd()
	{
		int[] ini = {50, 25, 11, 34, 7};
		bst.init(ini);
		assertEquals( 2, bst.leaves());		
	}
	
	@Test
	public void testLeavesManyEven()
	{
		int[] ini = {50, 25, 11, 34, 7, 20, 36, 80, 100, 40};
		bst.init(ini);
		assertEquals( 4, bst.leaves());		
	}

	//=============================================================================
	//Nodes
	//=============================================================================

	@Test
	public void testNodes_0_Length()
	{
		int[] ini = {};
		bst.init(ini);
		assertEquals( 0, bst.nodes());
	}
	
	@Test
	public void testNodes_1_Length()
	{
		int[] ini = {50};
		bst.init(ini);
		assertEquals( 0, bst.nodes());		
	}
	
	@Test
	public void testNodes_2Length()
	{
		int[] ini = {50, 25};
		bst.init(ini);
		assertEquals( 1, bst.nodes());		
	}
	
	@Test
	public void testNodesManyOdd()
	{
		int[] ini = {50, 25, 11, 34, 7};
		bst.init(ini);
		assertEquals( 3, bst.nodes());		
	}
	
	@Test
	public void testNodesManyEven()
	{
		int[] ini = {50, 25, 11, 34, 7, 20, 36, 80, 100, 40};
		bst.init(ini);
		assertEquals( 6, bst.nodes());		
	}

	//=============================================================================
	//toArray
	//=============================================================================
	
	@Test
	public void testToArray_0_Length()
	{
		int[] ini = {};
		bst.init(ini);
		assertEquals(ini.length, bst.size());
		int[] exp = {};
		assertArrayEquals(exp, bst.toArray());	
	}
	
	@Test
	public void testToArray_1_Length()
	{
		int[] ini = {50};
		bst.init(ini);
		assertEquals(ini.length, bst.size());
		int[] exp = {50};
		assertArrayEquals(exp, bst.toArray());		
	}
	
	@Test
	public void testToArray_2Length()
	{
		int[] ini = {50, 25};
		bst.init(ini);
		assertEquals(ini.length, bst.size());
		int[] exp = {25, 50};
		assertArrayEquals(exp, bst.toArray());		
	}
	
	@Test
	public void testToArrayManyOdd()
	{
		int[] ini = {50, 25, 11, 34, 7};
		bst.init(ini);
		assertEquals(ini.length, bst.size());
		int[] exp = {7, 11, 25, 34, 50};
		assertArrayEquals(exp, bst.toArray());		
	}
	
	@Test
	public void testToArrayManyEven()
	{
		int[] ini = {50, 25, 11, 34, 7, 20, 36, 80, 100, 40};
		bst.init(ini);
		assertEquals(ini.length, bst.size());
		int[] exp = {7, 11, 20, 25, 34, 36, 40, 50, 80, 100};
		assertArrayEquals(exp, bst.toArray());		
	}

	//=============================================================================
	//toString
	//=============================================================================
	
	@Test
	public void testToString_0_Length()
	{
		int[] ini = {};
		bst.init(ini);
		String exp = "";
		assertEquals(exp, bst.toString());
	}
	
	@Test
	public void testToString_1_Length()
	{
		int[] ini = {50};
		bst.init(ini);
		String exp = "50,";
		assertEquals(exp, bst.toString());		
	}
	
	@Test
	public void testToString_2Length()
	{
		int[] ini = {50, 25};
		bst.init(ini);
		String exp = "25, 50,";
		assertEquals(exp, bst.toString());		
	}
	
	@Test
	public void testToStringManyOdd()
	{
		int[] ini = {50, 25, 11, 34, 7};
		bst.init(ini);
		String exp = "7, 11, 25, 34, 50,";
		assertEquals(exp, bst.toString());		
	}
	
	@Test
	public void testToStringManyEven()
	{
		int[] ini = {50, 25, 11, 34, 7, 20, 36, 80, 100, 40};
		bst.init(ini);
		String exp = "7, 11, 20, 25, 34, 36, 40, 50, 80, 100,";
		assertEquals(exp, bst.toString());		
	}

	//=============================================================================
	//Reverse
	//=============================================================================
		
	@Test
	public void testReverse_0_Length()
	{
		int[] ini = {};
		bst.init(ini);
		bst.reverse();
		int[] act = bst.toArray();
		assertEquals(ini.length, bst.size());
		int[] exp = {};
		assertArrayEquals(exp, act);	
	}
	
	@Test
	public void testReverse_1_Length()
	{
		int[] ini = {50};
		bst.init(ini);
		bst.reverse();
		int[] act = bst.toArray();
		assertEquals(ini.length, bst.size());
		int[] exp = {50};
		assertArrayEquals(exp, act);		
	}
	
	@Test
	public void testReverse_2Length()
	{
		int[] ini = {50, 25};
		bst.init(ini);
		bst.reverse();
		int[] act = bst.toArray();
		assertEquals(ini.length, bst.size());
		int[] exp = {50, 25};
		assertArrayEquals(exp, act);		
	}
	
	@Test
	public void testReverseManyOdd()
	{
		int[] ini = {50, 25, 11, 34, 7};
		bst.init(ini);
		bst.reverse();
		int[] act = bst.toArray();
		assertEquals(ini.length, bst.size());
		int[] exp = {50, 34, 25, 11, 7};
		assertArrayEquals(exp, act);		
	}
	
	@Test
	public void testReverseManyEven()
	{
		int[] ini = {50, 25, 11, 34, 7, 20, 36, 80, 100, 40};
		bst.init(ini);
		bst.reverse();
		int[] act = bst.toArray();
		assertEquals(ini.length, bst.size());
		int[] exp = {100, 80, 50, 40, 36, 34, 25, 20, 11, 7};
		assertArrayEquals(exp, act);		
	}

	//=============================================================================
	//Height
	//=============================================================================

	@Test
	public void testHeight_0_Length()
	{
		int[] ini = {};
		bst.init(ini);
		assertEquals( 0, bst.height());
	}
	
	@Test
	public void testHeight_1_Length()
	{
		int[] ini = {50};
		bst.init(ini);
		assertEquals( 1, bst.height());		
	}
	
	@Test
	public void testHeight_2Length()
	{
		int[] ini = {50, 25};
		bst.init(ini);
		assertEquals( 2, bst.height());		
	}
	
	@Test
	public void testHeightManyOdd()
	{
		int[] ini = {50, 25, 11, 34, 7};
		bst.init(ini);
		assertEquals( 4, bst.height());		
	}
	
	@Test
	public void testHeightManyEven()
	{
		int[] ini = {50, 25, 11, 34, 7, 20, 36, 80, 100, 40};
		bst.init(ini);
		assertEquals( 5, bst.height());		
	}

	//=============================================================================
	//Width
	//=============================================================================

	@Test
	public void testWidth_0_Length()
	{
		int[] ini = {};
		bst.init(ini);
		assertEquals( 0, bst.width());
	}
	
	@Test
	public void testWidth_1_Length()
	{
		int[] ini = {50};
		bst.init(ini);
		assertEquals( 1, bst.width());		
	}
	
	@Test
	public void testWidth_2Length()
	{
		int[] ini = {50, 25};
		bst.init(ini);
		assertEquals( 1, bst.width());		
	}
	
	@Test
	public void testWidthManyOdd()
	{
		int[] ini = {50, 25, 11, 34, 7};
		bst.init(ini);
		assertEquals( 2, bst.width());		
	}
	
	@Test
	public void testWidthManyEven()
	{
		int[] ini = {50, 25, 11, 34, 7, 20, 36, 80, 100, 40};
		bst.init(ini);
		assertEquals( 3, bst.width());		
	}

	//=============================================================================
	//Remove
	//=============================================================================
	
	@Test
	public void testRemove_0_Length()
	{
		int[] ini = {};
		bst.init(ini);
		bst.del(33);
		int[] act = bst.toArray();
		assertEquals(ini.length, bst.size());
		int[] exp = {};
		assertArrayEquals(exp, act);	
	}
	
	@Test
	public void testRemove_1_Length()
	{
		int[] ini = {50};
		bst.init(ini);
		bst.del(50);
		int[] act = bst.toArray();
		assertEquals(ini.length - 1, bst.size());
		int[] exp = {};
		assertArrayEquals(exp, act);		
	}
	
	@Test
	public void testRemove_2Length()
	{
		int[] ini = {50, 25};
		bst.init(ini);
		bst.del(50);
		int[] act = bst.toArray();
		assertEquals(ini.length - 1, bst.size());
		int[] exp = {25};
		assertArrayEquals(exp, act);		
	}
	
	@Test
	public void testRemoveManyOdd()
	{
		int[] ini = {50, 25, 11, 34, 7};
		bst.init(ini);
		bst.del(11);
		int[] act = bst.toArray();
		assertEquals(ini.length - 1, bst.size());
		int[] exp = {7, 25, 34, 50};
		assertArrayEquals(exp, act);		
	}
	
	@Test
	public void testRemoveManyEven_Inside()
	{
		int[] ini = {50, 25, 11, 34, 7, 20, 36, 80, 100, 40};
		bst.init(ini);
		bst.del(34);
		int[] act = bst.toArray();
		assertEquals(ini.length - 1, bst.size());
		int[] exp = {7, 11, 20, 25, 36, 40, 50, 80, 100};
		assertArrayEquals(exp, act);		
	}
	
	@Test
	public void testRemoveManyEven_LastLeft()
	{
		int[] ini = {50, 25, 11, 34, 7, 20, 36, 80, 100, 40};
		bst.init(ini);
		bst.del(7);
		int[] act = bst.toArray();
		assertEquals(ini.length - 1, bst.size());
		int[] exp = {11, 20, 25, 34, 36, 40, 50, 80, 100};
		assertArrayEquals(exp, act);		
	}
	
	@Test
	public void testRemoveManyEven_LastRight()
	{
		int[] ini = {50, 25, 11, 34, 7, 20, 36, 80, 100, 40};
		bst.init(ini);
		bst.del(100);
		int[] act = bst.toArray();
		assertEquals(ini.length - 1, bst.size());
		int[] exp = {7, 11, 20, 25, 34, 36, 40, 50, 80};
		assertArrayEquals(exp, act);		
	}
	
	@Test
	public void testRemoveManyEven_Absent()
	{
		int[] ini = {50, 25, 11, 34, 7, 20, 36, 80, 100, 40};
		bst.init(ini);
		bst.del(35);
		int[] act = bst.toArray();
		assertEquals(ini.length, bst.size());
		int[] exp = {7, 11, 20, 25, 34, 36, 40, 50, 80, 100};
		assertArrayEquals(exp, act);		
	}
}
