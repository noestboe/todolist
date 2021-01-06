package todolist.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestTodoList {

    private TodoList items;

    @BeforeEach
    public void setup() {
        items = new TodoList();
    }
    

    public TestTodoList() {
        
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
        assertTrue(it.hasNext());
        assertEquals(it.next().getDescription(), "Brød");
        assertTrue(it.hasNext());
        assertEquals(it.next().getDescription(), "Ost");
        assertTrue(it.hasNext());
        assertEquals(it.next().getDescription(), "Melk");
        assertFalse(it.hasNext());
    }
}
