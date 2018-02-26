// ComputerAccessory.java
package com.jdojo.innerclasses;

public class ComputerAccessory {
    // A static member class - Monitor 
    public static class Monitor {
        private final int size;

        public Monitor(int size) {
            this.size = size;
        }

        public String toString() {
            return "Monitor - Size:" + this.size + " inch";
        }
    }

    // A static member class - Keyboard 
    public static class Keyboard {
        private final int keys;

        public Keyboard(int keys) {
            this.keys = keys;
        }

        public String toString() {
            return "Keyboard - Keys:" + this.keys;
        }
    }
}
