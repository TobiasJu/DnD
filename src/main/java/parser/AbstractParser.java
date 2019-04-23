package parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by marius on 27.06.16.
 * @version 1.0rc
 */
public abstract class AbstractParser {
    public void parse(String file) {
        ClassLoader loader = getClass().getClassLoader();
        String loc = loader.getResource(file).getPath().toString();
        try {
            FileReader reader = new FileReader(loc);
            BufferedReader br = new BufferedReader(reader);
            String line = "-1";
            while(line != null) {
                line = br.readLine();
                if(line != null) {
                    this.handleLine(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleLine(String line) {

    }
}
