package com.geekbrains.client;

import java.io.*;

public class Logger implements Closeable {
    public Logger(String login) throws IOException {
        lock = new Object();
        String path = new File(System.getProperty("user.dir"), login+".txt").getPath();

        fw = new FileWriter(path, true);
        bw = new BufferedWriter(fw);
        writer = new PrintWriter(bw);
    }

    @Override
    public void close() {
        try {
            synchronized (lock) {
                if (writer == null)
                    return;
                writer.close();
                writer = null;
                bw.close();
                fw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void logMessage(String message) {
        writer.write(message);
    }

    private final FileWriter fw;
    private final BufferedWriter bw;
    private PrintWriter writer;
    private Object lock;
}
