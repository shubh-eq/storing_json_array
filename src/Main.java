import jsonio.JsonIO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        JSONArray persons = JsonIO.readJSON("src/sample.json");

        //Storing in PersonList
        ArrayList<Person> personList = new ArrayList<>();

        for (int i=0;i<persons.length();i++) {
            JSONObject personObj = persons.getJSONObject(i);
            JSONObject addressObj = personObj.getJSONObject("address");

            Address address = new Address((String) addressObj.get("state"), (String) addressObj.get("pinCode"));
            Person person = new Person((String) personObj.get("name"), (String) personObj.get("place"), (String) personObj.get("email"),address);

            personList.add(person);
        }

        //Printing PersonList
        for (Person person :personList) {
            System.out.println("Details of "+person.name);
            System.out.println("Email: "+person.email);
            System.out.println("Place: "+person.place);
            System.out.println("State: "+person.address.state);
            System.out.println("Pin: "+person.address.pinCode+'\n');
        }
    }
}