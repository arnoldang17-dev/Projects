import java.util.ArrayList;
import java.util.List;

class abc {

    int a;
    public abc(int a) {
        this.a = a;
    }
}

public class playground {
    
    public static void main(String[] args) {
        
       List<String> a = new ArrayList<>();
        
       a.add("DUCK");
        System.out.println(a.get(0).equals("DUCK"));
    }
}
