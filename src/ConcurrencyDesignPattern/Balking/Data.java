package ConcurrencyDesignPattern.Balking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author ankh
 * @created at 2022-09-13 14:21
 */
public class Data {
    private final String filename;
    private String content;
    private boolean changed;

    public Data(String filename, String content, boolean changed) {
        this.filename = filename;
        this.content = content;
        this.changed = changed;
    }

    public synchronized void change(String newContent) {
        content = newContent;
        changed = true;
    }

    public synchronized void save() throws IOException {
        if (!changed) {
            return;
        }
        doSave();
        changed = false;
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}
