package com.kodilla.stream.person;

import java.util.ArrayList;
import java.util.List;

public final class People {
    public static List<String> getList() {
        final List<String> theList = new ArrayList<>();
        theList.add("Major Marquis Warren");
        theList.add("John Ruth");
        theList.add("Daisy Domergue");
        theList.add("Chris Mannix");
        theList.add("Marco the Mexican");
        theList.add("English Pete Hicox");
        theList.add("Grouch Douglass");
        theList.add("General Sanford Smithers");
        theList.add("O.B.");
        theList.add("Jody Domergue");
        return new ArrayList<>(theList);
    }

}
