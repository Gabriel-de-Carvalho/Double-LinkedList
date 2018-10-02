package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(head.isNIL()) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		int sum = 0;
		SingleLinkedListNode<T> aux = head;
		while(!(aux.isNIL())) {
			sum++;
			aux = aux.getNext();
		}
		return sum;
		
	}

	@Override
	public T search(T element) {
		// TODO Auto-generated method stub
		SingleLinkedListNode<T> aux2 = head;
		
		while(!(aux2.isNIL()) && !(aux2.getData().equals(element))) {
			aux2 = aux2.getNext();
		}
		return aux2.getData();
	}

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			this.head.setData(element);
			this.head.setNext(new SingleLinkedListNode<T>());
		} else {
			SingleLinkedListNode<T> aux3 = head;
			
			while(!(aux3.getNext().isNIL())) {
				aux3 = aux3.getNext();
			}
			aux3.setNext(new SingleLinkedListNode<T>(element,new SingleLinkedListNode<T>()));
		}
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		SingleLinkedListNode<T> aux4 = head;
		
		while(!(aux4.getNext().getNext().isNIL())) {
			aux4 = aux4.getNext();
		}
		aux4.setNext(new SingleLinkedListNode<T>());
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		Object[] array = (T[]) new Object[size()];
		SingleLinkedListNode<T> aux5 = head;
		for(int  i = 0; i < array.length; i++) {
			array[i] = aux5.getData();
			aux5 = aux5.getNext();
		}
		
		return (T[]) array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
