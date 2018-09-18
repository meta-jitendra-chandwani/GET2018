import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/*
 * NestedListClass - implements NestedList, and perform operation on nestedlist.
 */
public class NestedListClass implements NestedList {
    static List < List < Long >> nestedList = new ArrayList < List < Long >> ();
    String URL;

    public NestedListClass(String URL) {
        this.URL = URL;
    }

    /*
     * JsonParser -  parse the json object into the list
     * @return List of List of JSON Objects
     */
    @SuppressWarnings("rawtypes")
    List JsonParser() {
        Object object;
        JSONObject jsonObject = null;
        try {

            object = new JSONParser().parse(new FileReader(URL));
            jsonObject = (JSONObject) object;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (List) jsonObject.get("list");
    }

    /*
     * (non-Javadoc)
     * @see NestedList#sumOfList(java.util.List)
     * sumOfList - To calculate the sum of nested list
     * @param nestedList - nested List
     * @return - the sum of all integer in nested list
     */
    @SuppressWarnings({
        "unchecked",
        "rawtypes"
    })
    @Override
    public long sumOfList(List < List < Long >> nestedList) {
        long returnValue = 0;
        if (!(nestedList == null || nestedList.size() == 0)) {
            int sum = 0;
            for (Object list: nestedList) {
                if (list instanceof Long) {
                    sum += (long) list;
                } else {
                    sum += sumOfList((List) list);
                }
            }
            returnValue = sum;
        }
        return returnValue;

    }

    /*
     * (non-Javadoc)
     * @see NestedList#largestValue(java.util.List)
     * largestValue - To calculate the largest value from the nested list
     * @param nestedList - nested List
     * @return - the largest value from the nested list
     */
    @SuppressWarnings({
        "unchecked",
        "rawtypes"
    })
    @Override
    public long largestValue(List < List < Long >> nestedList) {
        long maximumValueInList = 0;
        if (!(nestedList == null || nestedList.size() == 0)) {
            for (Object list: nestedList) {
                if (list instanceof Long) {
                    if ((long) list > maximumValueInList) {
                        maximumValueInList = (long) list;
                    }
                } else {
                    maximumValueInList = largestValue((List) list);
                }
            }
        }
        return maximumValueInList;
    }

    /*
     * (non-Javadoc)
     * @see NestedList#searchElement(java.util.List, int)
     * searchElement - Search the element in the nested list
     * @param nestedList - nested list
     * @param element - the element to be search in the list
     * @return - boolean value - true if element is search else false.
     */
    @SuppressWarnings({
        "unchecked",
        "rawtypes"
    })
    @Override
    public boolean searchElement(List < List < Long >> nestedList, int element) {
        boolean returnValue = false;
        if (!(nestedList == null || nestedList.size() == 0)) {
            for (Object list: nestedList) {
                if (list instanceof Long) {
                    if ((long) list == element) {
                        returnValue = true;
                        break;
                    }
                } else {
                    if (!returnValue) {
                        returnValue = searchElement((List) list, element);
                    }
                }
            }
        }
        return returnValue;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] arg) {

        NestedListClass operation = new NestedListClass("C:\\Users\\User23\\workspace\\Area\\src\\InputFile.json");
        nestedList = operation.JsonParser();
        System.out.println("Addition of list value : " + operation.sumOfList(nestedList));
        System.out.println("Maximum of list value : " + operation.largestValue(nestedList));
        System.out.println("Search 2 from list : " + operation.searchElement(nestedList, 2));

    }

}