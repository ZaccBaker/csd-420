import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JacksonTreeExample {
    public static void main(String[] args) throws Exception {
        String json = "{ \"name\": \"Zac\", \"role\": \"Developer\" }";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(json);

        System.out.println("Name: " + rootNode.get("name").asText());

        ((ObjectNode) rootNode).put("experience", "Entry-Level");

        String updatedJson = mapper.writerWithDefaultPrettyPrinter()
                                   .writeValueAsString(rootNode);

        System.out.println(updatedJson);
    }
}
