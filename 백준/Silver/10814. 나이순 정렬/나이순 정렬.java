import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] st = br.readLine().split(" ");

            int age = Integer.parseInt(st[0]);
            String name = st[1];
            list.add(new Person(age, name));
        }

        list.sort((o1, o2) -> o1.age - o2.age);

        for (Person person : list) {
            System.out.println(person);
        }
    }
}

class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }
}
