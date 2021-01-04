package todolist.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import todolist.core.TodoItem;
import todolist.core.TodoList;

public class TodoListSerializer extends JsonSerializer<TodoList> {

    @Override
    public void serialize(TodoList todolist, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeArrayFieldStart("items");
        for (TodoItem item : todolist) {
            jsonGenerator.writeObject(item);
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
    

    

}