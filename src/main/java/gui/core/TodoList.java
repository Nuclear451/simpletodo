package gui.core;

import java.util.*;

public class TodoList implements Iterable<String>{

	private List<String> list = new ArrayList<>();

	public void add(String item) {
		list.add(item);
	}

	public void removeAt(int i) {
		if (i >= 0 && i < list.size()) {
			list.remove(i);
		}
	}
	
	public int size() {
		return list.size();
	}
	
	public String elementAt(int i) {
		return list.get(i);
	}
	
	@Override
	public Iterator<String> iterator() {
		return list.iterator();
	}
}
