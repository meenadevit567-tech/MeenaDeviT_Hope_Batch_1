package model;

import java.util.*;

public class Row {
    Map<String, String> data;

    public Row(Map<String, String> data) {
        this.data = data;
    }

    public String get(String key) {
        return data.get(key);
    }
}