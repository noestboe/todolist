package todolist;

import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.Iterator;

import org.junit.jupiter.api.Test;

import todolist.core.TodoItem;
import todolist.core.TodoList;


public class TestTodoList {

    private TodoList items;

    public AppTest() {
        
    }

    @Test
    public void testAddItem() {
        TodoItem item1 = new TodoItem("Brød");
        TodoItem item2 = new TodoItem("Ost");
        TodoItem item3 = new TodoItem("Melk");
        items.addItem(item1);
        items.addItem(item2);
        items.addItem(item3);

        Iterator<TodoItem> it = items.iterator();
        assertEquals(1,1);


    }
}
