package util.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("Unchecked")
public abstract class JsonDataHandler<T> {
    private final String FILE_PATH;

    protected JsonDataHandler(String filePath) {
        FILE_PATH = filePath;
    }

    public abstract T objectFromData(JSONObject data);

    public abstract JSONObject dataFromObject(T t);

    public ArrayList<T> getAllData() {
        ArrayList<T> list = new ArrayList<>();
        JSONArray dataArray = getDataArray();
        dataArray.forEach(data -> {
            JSONObject postData = (JSONObject) data;
            list.add(objectFromData(postData));
        });
        return list;
    }

    public void saveData(T t) {
        JSONObject data = dataFromObject(t);
        JSONArray dataArray = getDataArray();
        dataArray.add(data);

        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(dataArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JSONArray getDataArray() {
        JSONParser parser = new JSONParser();
        JSONArray dataArray = new JSONArray();

        try (FileReader file = new FileReader(FILE_PATH)) {
            dataArray = (JSONArray) parser.parse(file);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return dataArray;
    }
}
