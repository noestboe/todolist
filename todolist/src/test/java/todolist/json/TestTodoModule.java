package todolist.json;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import todolist.core.TodoItem;
import todolist.core.TodoList;

public class TestTodoModule {

    private static ObjectMapper mapper;

    private final static String todoItemString = "{\"Item\":\"Brød\"}";

    @BeforeAll
    public static void setUp() {
        mapper = new ObjectMapper();
        mapper.registerModule(new TodoModule());
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
                System.out.println(mapper.writeValueAsString(item));
            }
            System.out.println(mapper.writeValueAsString(todoList));
        } catch (JsonProcessingException e){
            fail();
        }
        
    }



}