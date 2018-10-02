package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	
	public DoubleLinkedListImpl() {
		super();
		this.last = new DoubleLinkedListNode<T>();
		this.setHead(last);

	}
	
	
	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>());
		// TODO Auto-generated method stub
		if(isEmpty()) {
			this.setHead(aux);
			this.head.setNext(new DoubleLinkedListNode<T>());
			((DoubleLinkedListNode<T>) this.head).setPrevious(new DoubleLinkedListNode<T>());
			this.setLast(aux);
		} else {
			aux.setNext(this.getHead());
			((DoubleLinkedListNode<T>) this.getHead()).setPrevious(aux);
			this.setHead(aux);
			if(this.getLast().isNIL()) {
				this.last.setPrevious((DoubleLinkedListNode<T>) this.getHead());
			}
		}
	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		if(this.head.equals(this.last)) {
			this.last = new DoubleLinkedListNode<T>();
			this.setHead(last);
		} else {
			this.head = head.getNext();
			((DoubleLinkedListNode<T>) this.head).setPrevious(new DoubleLinkedListNode<T>());
		}
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		if(this.head.equals(this.last)) {
			this.last = new DoubleLinkedListNode<T>();
			this.setHead(last);
		} else {
			this.last = this.last.getPrevious();
			this.last.setNext(new DoubleLinkedListNode<T>());
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
