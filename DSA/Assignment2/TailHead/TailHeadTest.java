import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class TailHeadTest {
	private List<Object> list1;	
	private List<Object> list2;	
	private List<Object> list3;
	private List<Object> listOfList;
	private TailHead head;
	
	/**
	 * Initailize object of TailHead class.
	 */
	@Before
	public void initialize(){
		list1=new ArrayList<Object>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list2=new ArrayList<Object>();
		list2.add(4);
		list2.add(5);
		list2.add(6);
		list3=new ArrayList<Object>();
		list3.add(7);
		list3.add(8);
		list3.add(9);
		listOfList=new ArrayList<Object>();
		listOfList.add(list1);
		listOfList.add(list2);
		listOfList.add(list3);
		
		head=new TailHead();
	}
	
	/*
	 * getElementTest - Check the functionality of TailHead Class
	 */
	@Test
	public void getElementTest() {
		assertEquals(head.getValue(listOfList, "THH"), "4");
	}
}