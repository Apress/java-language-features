// ExecutableUtil.java
package com.jdojo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class ExecutableUtil {
    public static ArrayList<String> getParameters(Executable exec) {
        Parameter[] parms = exec.getParameters();
        ArrayList<String> parmList = new ArrayList<>();
        for (int i = 0; i < parms.length; i++) {
            // Get modifiers, type, and name of the parameter
            int mod = parms[i].getModifiers() & Modifier.parameterModifiers();
            String modifiers = Modifier.toString(mod);
            String parmType = parms[i].getType().getSimpleName();
            String parmName = parms[i].getName();
            String temp = modifiers + " " + parmType + " " + parmName;

            // Trim it as it may have leading spaces when modifiers are absent
            parmList.add(temp.trim());
        }
        
        return parmList;
    }

    public static ArrayList<String> getExceptionList(Executable exec) {
        ArrayList<String> exceptionList = new ArrayList<>();
        for (Class<?> c : exec.getExceptionTypes()) {
            exceptionList.add(c.getSimpleName());
        }
        
        return exceptionList;
    }

    public static String getThrowsClause(Executable exec) {
        ArrayList<String> exceptionList = getExceptionList(exec);
        String exceptions = ExecutableUtil.arrayListToString(exceptionList, ",");
        String throwsClause = "";
        
        if (exceptionList.size() > 0) {
            throwsClause = "throws " + exceptions;
        }

        return throwsClause;
    }

    public static String getModifiers(Executable exec) {
        // Get the modifiers for the class  
        int mod = exec.getModifiers();
        
        if (exec instanceof Method) {
            mod = mod & Modifier.methodModifiers();
        } else if (exec instanceof Constructor) {
            mod = mod & Modifier.constructorModifiers();
        }
        
        return Modifier.toString(mod);
    }

    public static String arrayListToString(ArrayList<String> list, String saparator) {
        String[] tempArray = new String[list.size()];
        tempArray = list.toArray(tempArray);
        String str = String.join(saparator, tempArray);
        return str;
    }
}
