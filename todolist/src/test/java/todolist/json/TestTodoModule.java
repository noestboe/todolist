package todolist.json;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Iterator;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import todolist.core.TodoItem;
import todolist.core.TodoList;

public class TestTodoModule {

    private static ObjectMapper mapper;

    private final static String todoItemString = "{\"description\":\"Brød\",\"checked\":\"false\"}";
    private final static String todoListString = "{\"items\":[{\"description\":\"Brød\",\"checked\":\"false\"},{\"description\":\"Melk\",\"checked\":\"false\"},{\"description\":\"Ost\",\"checked\":\"false\"}]}";
    //"{\"items\":[{\"description\":\"Brød\",\"checked\":\"false\"},{\"description\":\"Ost\",\"checked\":\"true\"}]}";

    @BeforeAll
    public static void setUp() {
        mapper = new ObjectMapper();
        mapper.registerModule(new TodoModule());
    }

    @Test
    public void testDeserializer_forTodoList() {
        /* TodoList expectedTodolist = new TodoList();
        TodoItem item1 = new TodoItem("Brød");
        TodoItem item2 = new TodoItem("Ost");
        item2.setChecked(true);
        expectedTodolist.addItem(item1);
        expectedTodolist.addItem(item2); */
        try {
            TodoList acutalTodoList = mapper.readValue(TestTodoModule.todoListString, TodoList.class);
            Iterator<TodoItem> it = acutalTodoList.iterator();
            System.out.println(it.next().getDescription());
            /* assertTrue(it.hasNext());
            checkTodoItem(it.next(), "Brød", false);
            assertTrue(it.hasNext());
            checkTodoItem(it.next(), "Ost", true);
            assertFalse(it.hasNext()); */
        } catch(JsonProcessingException e) {
            fail();
        }
    }

    private void checkTodoItem(TodoItem item, String description, boolean checked) {
        assertEquals(item.getDescription(), description);
        assertEquals(item.getChecked(), checked);

    }

    @Test
    public void testDeserializer() throws JsonMappingException, JsonProcessingException {
        TodoItem expectedItem = new TodoItem();
        expectedItem.setChecked(false);
        expectedItem.setDescription("Brød");
        TodoItem actualItem = mapper.readValue(TestTodoModule.todoItemString, TodoItem.class);
        assertEquals(expectedItem.getChecked(), actualItem.getChecked());
        assertEquals(expectedItem.getDescription(), actualItem.getDescription());
    }

    @Test
    public void testSerializer() {
        TodoList todoList = new TodoList();
        TodoItem todoItem1 = new TodoItem("Brød");
        TodoItem todoItem2 = new TodoItem("Melk");
        TodoItem todoItem3 = new TodoItem("Ost");
        todoList.addItem(todoItem1);
        todoList.addItem(todoItem2);
        todoList.addItem(todoItem3);
        
        try {
            //assertEquals(todoItemString, mapper.writeValueAsString(todoItem1));
            for (TodoItem item : todoList) {
                //System.out.println(mapper.writeValueAsString(item));

            }
            System.out.println(mapper.writeValueAsString(todoList));
        } catch (JsonProcessingException e){
            fail();
        }
        
    }



}