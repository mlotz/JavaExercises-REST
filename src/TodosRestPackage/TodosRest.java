package TodosRestPackage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class TodosRest {

   // @RequestMapping(produces = MediaType.APPLICATION_JSON)
    public TodosRest (){

    }

    static public class todo{
        Integer userId;
        Integer id;
        String title;
        Boolean completed;

        public todo(Integer userId,  Integer id, String title, Boolean completed){
            this.userId = userId;
            this.id = id;
            this.title = title;
            this.completed = completed;
        }
        public todo(){

        }




       public Integer getuserId() { return this.userId; }
       public void   setuserId(Integer brand){ this.userId = brand;}
       public Integer getid() { return this.id; }
       public void   setid(Integer id){ this.id = id;}
       public String gettitle() { return this.title; }
       public void   settitle(String title){ this.title = title;}
       public Boolean getcompleted() { return this.completed; }
       public void   setcompleted(Boolean completed){ this.completed = completed;}

    }

    public static <T> T fromJSON(final TypeReference<T> type,
                                 final String jsonPacket) {
        T data = null;

        try {
            data = new ObjectMapper().readValue(jsonPacket, type);
        } catch (Exception e) {
            // Handle the problem
        }
        return data;
    }

    public static ArrayList<todo> getTodos(String URL){

        RestTemplate rt = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        String result = rt.getForObject(URL, String.class);
        //System.out.println(result);

        try {
            ArrayList<todo> todos = fromJSON(new TypeReference<ArrayList<todo>>() {}, result);
            return todos;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }


    public static void main(String[] args) {

        String siteURL = "https://jsonplaceholder.typicode.com/todos";
        FileOutputStream out = null;


        ArrayList<todo> todos = getTodos(siteURL);
        Iterator<todo> iter = todos.iterator();
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            while (iter.hasNext()) {
                writer.write(iter.next().title + " ");
                //System.out.println(iter.next().title+" ");
            }
            writer.close();
        }
        catch (Exception e){
            System.out.println(e);
        }



    }

}
