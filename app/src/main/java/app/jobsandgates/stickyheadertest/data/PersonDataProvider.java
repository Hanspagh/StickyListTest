package app.jobsandgates.stickyheadertest.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aurel on 11/10/14.
 */
public class PersonDataProvider {

    private LinkedHashMap<String, Boolean> items;
    private List<String> addedItems;

    public PersonDataProvider() {
        this.items = new LinkedHashMap<String, Boolean>();
        this.addedItems = new ArrayList<String>();

        for (int i = 0; i < persons.length; i++ ) {
            items.put(persons[i], true);
        }

        buildAddedItems();
    }


    public List<String> getItems() {
        return addedItems;
    }

    public void remove(int position) {
        items.put(addedItems.get(position), false);
        buildAddedItems();
    }

    public void move() {
        String s = addedItems.get(0);
        addedItems.add(s);
        addedItems.remove(0);
    }

    public int insertAfter(int position) {
        String addAfter = addedItems.get(position);
        Iterator<String> iterator = items.keySet().iterator();
        String next = iterator.next();

        while (iterator.hasNext() && !next.equals(addAfter)) {
            next = iterator.next();
        }

        do {
            next = iterator.next();
        }
        while (iterator.hasNext() && items.get(next));

        items.put(next, true);
        buildAddedItems();

        return addedItems.lastIndexOf(next);
    }

    private void buildAddedItems() {
        addedItems.clear();
        for (Map.Entry<String, Boolean> entry : items.entrySet()) {
            if (entry.getValue()) {
                addedItems.add(entry.getKey());
            }
        }
        //Collections.sort(addedItems);
    }

    private static String[] persons = {
            "Abram Tavernia",
            "Alexa Oquin",
            "Alvin Lainez",
            "Bob Rakestraw",
            "Cecilia Scruggs"
    };

}
