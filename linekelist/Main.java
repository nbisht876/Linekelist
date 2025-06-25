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
		list.set(1, 10);
		list.insert(2,2);
		list.insert(3,5);
		list.delete(1);
		list.getHead();
		list.getTail();
		list.getLength();
		list.printList();

	}
}
