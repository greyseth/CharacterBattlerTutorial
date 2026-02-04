package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Character;
import model.CharacterManager;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SaveManager {
    public static void saveData() {
        String savePath = System.getProperty("user.home")+"\\Documents";

        try (Writer writer = new FileWriter(savePath+"\\characterbattlersave.json")) {
            new GsonBuilder().create().toJson(CharacterManager.characters, writer);
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("NOTICE: Failed to save character data");
        }
    }

    public static void loadData() {
        Gson gson = new Gson();
        String savePath = System.getProperty("user.home")+"\\Documents";

        try {
            File saveDataCheck = new File(savePath+"\\characterbattlersave.json");
            if (!saveDataCheck.exists() || saveDataCheck.isDirectory()) return;

            BufferedReader bufferedReader = new BufferedReader(new FileReader(savePath+"\\characterbattlersave.json"));
            CharacterManager.characters = new ArrayList<>(gson.fromJson(bufferedReader, new TypeToken<List<Character>>(){}.getType()));
        }catch(Exception e) {
            System.out.println("NOTICE: Failed to load character data");
            e.printStackTrace();
        }
    }
}
