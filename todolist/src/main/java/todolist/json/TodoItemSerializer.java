package todolist.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import todolist.core.TodoItem;

public class TodoItemSerializer extends JsonSerializer<TodoItem> {

    @Override
    public void serialize(TodoItem todoItem, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
        
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("Item" , todoItem.getDescription());
        jsonGenerator.writeEndObject();

    }

    


}