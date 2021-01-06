package todolist.json;

import java.io.IOException;
import java.lang.reflect.Array;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import todolist.core.TodoItem;
import todolist.core.TodoList;

public class TodoListDeserializer extends JsonDeserializer<TodoList> {

    private TodoItemDeserializer todoItemDeserializer = new TodoItemDeserializer();

    @Override
    public TodoList deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        TreeNode treeNode = p.getCodec().readTree(p);
        if (treeNode instanceof ObjectNode) {
            ObjectNode objectNode = (ObjectNode) treeNode;
            TodoList todoList = new TodoList();
            JsonNode itemNode = objectNode.get("items");
            if (itemNode instanceof ArrayNode) {
                for (JsonNode elementNode : (ArrayNode) itemNode) {
                    TodoItem item = todoItemDeserializer.deserialize(elementNode);
                    if (item != null) {
                        todoList.addItem(item);
                    }
                }
            }
            return todoList;
        }
        return null;
    }
    
}