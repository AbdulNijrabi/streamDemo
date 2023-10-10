import java.util.List;

public class Solutions {
    public static void main(String[] args) {
        //1. **Filtering (Intermediate Operation):**
        //- Filter the list of persons to include only males.
        System.out.println(malesOnly(Person.persons()));
        // ontput:
        //[Ken, Jeff, Chris, Li] -> only got males.
    }
    // create method for chanllege 1
static List<String> malesOnly(List<Person> people){
        List<String> males = people.stream()
                .filter(Person::isMale)
                .map(Person::getName)
                .toList();
        return males;
    }
}
