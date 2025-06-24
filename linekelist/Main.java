package Linekelist.linekelist;


public class Main {
	public static void main(String[] args) {
		Linekelist list=new Linekelist(6);
		list.addNode(7);
		list.addNode(8);	
		list.addNode(9);
		list.prependNode(3);
		list.removeLast();
		list.removeFirst();
		list.get(2);
		list.getHead();
		list.getTail();
		list.getLength();
		list.printList();

	}
}
