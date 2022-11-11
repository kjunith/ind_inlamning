package util.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("Unchecked")
public abstract class JsonDataHandler<T> {
    private final String FILE_PATH;

    /**
     * Constructor wita path to file location
     *
     * @param filePath file location
     */
    protected JsonDataHandler(String filePath) {
        FILE_PATH = filePath;
    }

    /**
     * Generic method takes json object and returns
     * generic object T.
     *
     * @param data json object
     * @return object T
     */
    public abstract T objectFromData(JSONObject data);

    /**
     * Generic method takes generic data object T
     * and returns a json object.
     *
     * @param t generic data
     * @return json object
     */
    public abstract JSONObject dataFromObject(T t);

    /**
     * Generic method used to fetch data from file
     * and returns a list of generic object T.
     *
     * @return list off object T
     */
    public ArrayList<T> getAllData() {
        ArrayList<T> list = new ArrayList<>();
        JSONArray dataArray = getDataArray();
        dataArray.forEach(data -> {
            JSONObject postData = (JSONObject) data;
            list.add(objectFromData(postData));
        });
        return list;
    }

    /**
     * Generic method takes generic object T and
     * coverts to json object and saves to file.
     *
     * @param t generic object T
     */
    public void saveData(T t) {
        JSONObject data = dataFromObject(t);
        JSONArray dataArray = getDataArray();
        dataArray.add(data);

        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(dataArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            new File(FILE_PATH);
        }
    }

    /**
     * Generic method reads data from file and
     * returns an json array object
     *
     * @return json array object
     */
    private JSONArray getDataArray() {
        JSONParser parser = new JSONParser();
        JSONArray dataArray = new JSONArray();

        try (FileReader file = new FileReader(FILE_PATH)) {
            dataArray = (JSONArray) parser.parse(file);
        } catch (IOException | ParseException e) {
            new File(FILE_PATH);
        }

        return dataArray;
    }
}
