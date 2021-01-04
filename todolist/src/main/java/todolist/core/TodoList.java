package todolist.core;

import java.util.ArrayList;
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


    public Iterator<TodoItem> iterator() {
        return items.iterator();
    }


    public List<TodoItem> getCheckedTodoItems() {
        List<TodoItem> copyItems = new ArrayList<>();
        for (TodoItem todoitem : items) {
            if (todoitem.getChecked() == true) {
                copyItems.add(todoitem);
            }
        }
        return copyItems;
    }

    public List<TodoItem> getUncheckedTodoItems() {
        List<TodoItem> copyItems = new ArrayList<>();
        for (TodoItem todoitem : items) {
            if (todoitem.getChecked() == false) {
                copyItems.add(todoitem);
            }
        }
        return copyItems;
    }



}
