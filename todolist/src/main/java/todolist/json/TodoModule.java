package todolist.json;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import todolist.core.TodoItem;


public class TodoModule extends SimpleModule {

    private static final String NAME = "TODOMODULE";

    public TodoModule() {
        super(NAME, Version.unknownVersion());
        addSerializer(TodoItem.class, new TodoItemSerializer());
    }
   
    

}