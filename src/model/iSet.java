package model;

public interface iSet<T extends Comparable<T>> {
	void addElement(T element);
	void addAll(Set<T>set);
	void removeElement(T element);
	void removeAll(Set<T>set);
	boolean checkRepeated(T element);
	boolean isEmpty();
	boolean searchElement(T element);
	Set<T>unionSet(Set<T>secondSet);
	Set<T>interseccionSet(Set<T>secondSet);
	Set<T>differenceSet(Set<T>secondSet);
}
