import java.util.Comparator;
import java.util.List;

public class Solutions {
    public static void main(String[] args) {
        //1. **Filtering (Intermediate Operation):**
        //- Filter the list of persons to include only males.
        System.out.println(malesOnly(Person.persons()));
        // ontput:
        //[Ken, Jeff, Chris, Li] -> only got males.

        //3. **Sorting (Intermediate Operation):**
        //    - Sort the list of persons by their income in descending order.
        sortedByIncomeDesc().forEach(System.out::println);
        //output:
        //Person{id=3, name='Donna', gender=FEMALE, dob=1962-07-29, income=8700.0}
        //Person{id=2, name='Jeff', gender=MALE, dob=1970-07-15, income=7100.0}
        //Person{id=1, name='Ken', gender=MALE, dob=1970-05-04, income=6000.0}
        //Person{id=6, name='Li', gender=MALE, dob=2001-05-09, income=2400.0}
        //Person{id=4, name='Chris', gender=MALE, dob=1993-12-16, income=1800.0}
        //Person{id=5, name='Laynie', gender=FEMALE, dob=2012-12-13, income=0.0}
        //-> here we sorted based on ncome and by desinding (big to small).
    }
    // create method for chanllege 1
static List<String> malesOnly(List<Person> people){
        List<String> males = people.stream()
                .filter(Person::isMale)
                .map(Person::getName)
                .toList();
        return males;
    }
    //method for challenge 3
    static List<Person> sortedByIncomeDesc(){
        List<Person> sortedList = Person.persons()
                .stream()
                .sorted(Comparator.comparing(Person::getIncome).reversed())
                .toList();
        return sortedList;
    }
}
