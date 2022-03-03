import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Person{
    int age;
    String name;
    public Person(int a, String n){
        this.age = a;
        this.name = n;
    }
}

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Person[] person = new Person[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            person[i]=new Person(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        Arrays.sort(person, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.age, o2.age);
            }
        });
        for(int i=0; i<N; i++){
            System.out.println(person[i].age + " " + person[i].name);
        }
    }
}
