package todolist.core;

import java.util.Iterator;
import java.util.List;

public class TodoList implements Iterable<TodoItem> {
    
    List<TodoItem> items = new ArrayList<TodoItem>();

    

    public void addItem(TodoItem todoItem) {
        items.add(todoItem);
    }

    public void removeItem(TodoItem todoItem) {
        items.remove(todoItem);
    }

    public boolean isInItems(TodoItem todoItem) {
        items.contains(todoItem);
    }

    public Iterator<TodoItem> iterator() {
        return items.iterator();
    }

}
