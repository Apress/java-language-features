// Watcher.java
package com.jdojo.nio2;

import java.nio.file.WatchEvent.Kind;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

public class Watcher {
    public static void main(String[] args) {
        try (WatchService ws = FileSystems.getDefault().newWatchService()) {
            // Get a Path object for C:\kishori directory to watch  
            Path dirToWatch = Paths.get("C:\\kishori");

            // Register the path with the watch service for create, 
            // modify and delete events
            dirToWatch.register(ws, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);

            System.out.println("Watching " + dirToWatch + " for events.");

            // Keep watching for events on the dirToWatch  
            while (true) {
                // Retrieve and remove the next available WatchKey  
                WatchKey key = ws.take();

                for (WatchEvent<?> event : key.pollEvents()) {
                    Kind<?> eventKind = event.kind();
                    if (eventKind == OVERFLOW) {
                        System.out.println("Event overflow occurred");
                        continue;
                    }

                    // Get the context of the event, which is the directory 
                    // entry on which the event occurred.  
                    @SuppressWarnings("unchecked")
                    WatchEvent<Path> currEvent = (WatchEvent<Path>) event;
                    Path dirEntry = currEvent.context();

                    // Print the event details  
                    System.out.println(eventKind + " occurred on " + dirEntry);
                }

                // Reset the key  
                boolean isKeyValid = key.reset();

                if (!isKeyValid) {
                    System.out.println("No longer watching " + dirToWatch);
                    break;
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
