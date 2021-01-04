package todolist.json;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import todolist.core.TodoItem;

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
        TodoItem todoItem = new TodoItem("Brød");
        try {
            //System.out.println(mapper.writeValueAsString(todoItem));
            assertEquals(todoItemString, mapper.writeValueAsString(todoItem));
        } catch (JsonProcessingException e){
            fail();
        }
        
    }



}