package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			this.head.setData(element);
			this.head.setNext(new DoubleLinkedListNode<T>());
			this.last.setData(head.getData());
			this.last.setNext(new DoubleLinkedListNode<T>());
		} else {
			if(last.getPrevious().isNIL()) {
				DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<T>(element,   new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>());
				aux.setNext(this.getHead());
				
				this.head = aux;
			} else {
			DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<T>(element,   new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>());
			aux.setNext(this.getHead());
			this.head = aux;
			}
		}
	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		if(this.head.equals(this.last)) {
			this.head = new SingleLinkedListNode<T>();
			this.last = new DoubleLinkedListNode<T>();
		} else {
		this.head = this.head.getNext();
		}
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		if(this.head.equals(this.last)) {
			this.head = new SingleLinkedListNode<T>();
			this.last = new DoubleLinkedListNode<T>();
		} else {
			
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
