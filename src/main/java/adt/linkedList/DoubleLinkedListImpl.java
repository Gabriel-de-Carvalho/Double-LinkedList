package adt.linkedList;

import java.util.Queue;

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
		if (size() == 1) {
			this.last = new DoubleLinkedListNode<T>();
			this.setHead(last);
		} else {
			head.data = null;
			this.head = head.getNext();
		}
	}

	@Override
	public void removeLast() {
		int tam = size();
		if (tam > 0) {
			if (tam == 1) {
				head = last = newNIL();
			} else {
				last = last.getPrevious();
				last.setNext(newNIL());
			}
		}
	}
	
	@Override
	public void insert(T element) {
		if (isEmpty()) {
			head = last = new DoubleLinkedListNode<T> (
					element,
					new DoubleLinkedListNode<T>(),
					new DoubleLinkedListNode<T>()
			);
		} else {
			last.next = newNIL();
			next(last).previous = last;
			last = next(last);
			last.data = element;
			last.next = newNIL();
		}
	}
	
	private DoubleLinkedListNode<T> newNIL() {
		return new DoubleLinkedListNode<T>();
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}
	
	private DoubleLinkedListNode<T> next(DoubleLinkedListNode<T> node) {
		return (DoubleLinkedListNode<T>) node.next;
	}

}
