package model;

//TODO LIST: TAD.
//an >= 0 /\ a1!=a2  invariante

public class Set<T extends Comparable<T>> implements iSet<T> {
	private Node<T> first;
	private int size;
	
	public Set() {
		first=null;
		size=0;
	}
	
	public void addElement(T element) {
		if(!checkRepeated(element)) {
			Node<T> aux=new Node<>(element);
			aux.setNext(first);
			first=aux;
			size++;
		}
	}
	
	public void addAll(Set<T>set) {
		Node<T> current=set.first;
		while(current!=null) {
			addElement(current.getElement());
			current=current.getNext();
		}
	}
	
	public void removeElement(T element) {
		if(first==null) {
			throw new IllegalStateException("El conjunto está vacío. No se puede remover ningún elemento.");
		}
		
		if(first.getElement().compareTo(element)==0) {
			first=first.getNext();
			size--;
		}
		
		Node<T>current=first;
		while(current.getNext()!=null) {
			if(current.getNext().getElement().compareTo(element)==0) {
				current.setNext(current.getNext().getNext());
				size--;
				break;
			}
			current=current.getNext();
		}
	}
	
	public void removeAll(Set<T> set) {
		Node<T> current=set.first;
		while(current!=null) {
			removeElement(current.getElement());
			current=current.getNext();
		}
	}
	
	public boolean searchElement(T element) {
		Node<T>current=first;
		while(current!=null) {
			if(current.getElement().compareTo(element)==0) {
				return true;
			}
			current=current.getNext();
		}
		return false;
	}
	
	public Set<T> unionSet(Set<T> secondSet){
		Set<T> unionSet=new Set<>();
		Node<T> current=first;
		while(current!=null) {
			unionSet.addElement(current.getElement());
			current.getNext();
		}
		
		current=secondSet.first;
		while(current!=null) {
			unionSet.addElement(current.getElement());
			current=current.getNext();
		}
		
		return unionSet;
	}
	
	public Set<T> interseccionSet(Set<T> secondSet){
		Set<T>interseccionSet=new Set<>();
		
		Node<T> current=first;
		while(current!=null) {
			if(secondSet.checkRepeated(current.getElement())) {
				interseccionSet.addElement(current.getElement());
			}
			current=current.getNext();
		}
		return interseccionSet;
	}
	
	public Set<T> differenceSet(Set<T> secondSet){
		Set<T>differenceSet=new Set<>();
		Node<T>current=first;
		while(current!=null) {
			if(!secondSet.checkRepeated(current.getElement())) {
				differenceSet.addElement(current.getElement());
			}
		}
		return differenceSet;
	}
	
	public boolean checkRepeated(T element) {
		Node<T> aux=first;
		while(aux!=null) {
			if(aux.getElement().compareTo(element)==0) {
				return true;
			}
			aux=aux.getNext();
		}
		return false;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
}
