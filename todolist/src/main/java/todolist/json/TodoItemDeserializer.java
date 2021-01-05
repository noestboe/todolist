package todolist.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

import todolist.core.TodoItem;

public class TodoItemDeserializer extends JsonDeserializer<TodoItem> {

    @Override
    public TodoItem deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        TreeNode treenode = p.getCodec().readTree(p);
        return deserialize((JsonNode) treenode);
    }


    public TodoItem deserialize(JsonNode jsonNode) {
        if (jsonNode instanceof ObjectNode) {
            ObjectNode objectNode = (ObjectNode) jsonNode;
            TodoItem item = new TodoItem();
            JsonNode textNode = objectNode.get("description");
            if (textNode instanceof TextNode) {
                item.setDescription(((TextNode) textNode).asText());
            }
            JsonNode checkedNode = objectNode.get("checked");
            if (checkedNode instanceof BooleanNode) {
                item.setChecked(((BooleanNode) checkedNode).asBoolean());
            }
            return item;
        }
        return null;
    }

}