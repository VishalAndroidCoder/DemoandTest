package appsoft.com.demoandtest1;

import java.util.ArrayList;
import java.util.List;

public class ListArrayText {
    private static List<String> list = new ArrayList<>();
    public static List<String> getList(){
        list.add("OkHttp App");
        list.add("Second App");
        list.add("Assignment Demo of ISYNC");
        return list;
    };
}
