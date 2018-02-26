// ModulesByClassLoader.java
package com.jdojo.reflection;

public class ModulesByClassLoader {
    public static void main(String[] args) {
        // Get the boot layer
        ModuleLayer layer = ModuleLayer.boot();

        // Print all module's names and their class loader names in the boot layer
        for (Module m : layer.modules()) {
            ClassLoader loader = m.getClassLoader();            
            String moduleName = m.getName();
            String loaderName = loader == null ? "bootstrap" : loader.getName();
            System.out.printf("%s: %s%n", loaderName, moduleName);
        }        
    }
}
