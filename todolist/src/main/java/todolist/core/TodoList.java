package todolist.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TodoList implements Iterable<TodoItem> {

    private String test = "Bare test";
    private String test2 = "Test2";

    public String getTest() {
        return test;
    }
    
    public String getTest2(){
        return test2;
    }
    List<TodoItem> items = new ArrayList<TodoItem>();

    public void addItem(TodoItem todoItem) {
        items.add(todoItem);
    }

    public void removeItem(TodoItem todoItem) {
        items.remove(todoItem);
    }

    public boolean isInList(TodoItem todoItem) {
        return items.contains(todoItem);
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
