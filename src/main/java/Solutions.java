import java.util.Comparator;
import java.util.List;
import java.util.Optional;

// examples with Stream-. using intermediate operations.
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

        //4. **Distinct (Intermediate Operation):**
        //    - Find the distinct genders in the list of persons.
        System.out.println("Distinct genders are: " +distinctGendrs());
        //output:
        //Distinct genders are: [MALE, FEMALE]



        //5. **Limit (Intermediate Operation):**
        //    - Limit the list of persons to the first 3.
        System.out.println(" First three people on the top of the list are: ");
        firstThreePeople().forEach(System.out::println);
        //output:
        //First three people on the top of the list are:
        //Person{id=1, name='Ken', gender=MALE, dob=1970-05-04, income=6000.0}
        //Person{id=2, name='Jeff', gender=MALE, dob=1970-07-15, income=7100.0}
        //Person{id=3, name='Donna', gender=FEMALE, dob=1962-07-29, income=8700.0}


        //6. **Skip (Intermediate Operation):**
        //    - Skip the first 2 persons in the list.
        System.out.println("Skipped first twopeople in the list: ");
        skippedPeople().forEach(System.out::println);
        //output:
        //Skipped first twopeople in the list:
        //Person{id=3, name='Donna', gender=FEMALE, dob=1962-07-29, income=8700.0}
        //Person{id=4, name='Chris', gender=MALE, dob=1993-12-16, income=1800.0}
        //Person{id=5, name='Laynie', gender=FEMALE, dob=2012-12-13, income=0.0}
        //Person{id=6, name='Li', gender=MALE, dob=2001-05-09, income=2400.0}
        //-> it skiped two first people (ken and Jef)


        //7. **Peek (Intermediate Operation):**
        //    - Use peek to print the names of all persons in the list.


        //10. **AnyMatch (Terminal Operation):**
        //- Check if any person's income is greater than 8000.0.
        System.out.println("Is there any person who ahs more than 900000 income? "+anyPersonWithHighIncome());
        //output:
        //Is there any person who ahs more than 900000 income? false
        // since no person in our list of collections are with salary of more than 900000, then it turns false.

        //11. **AllMatch (Terminal Operation):**
        //- Check if all persons are male.



        //12. **NoneMatch (Terminal Operation):**
        //- Check if none of the persons have zero income.


        //13. **Count (Terminal Operation):**
        //- Count the number of persons who are female.


        //16 **Max (Terminal Operation):**
        //- Find the person with the highest income.
        System.out.println("Person with highest income is: " +personWithHighestIncome());
        //output: Person with the highest income is: Optional[Person{id=3, name='Donna', gender=FEMALE, dob=1962-07-29, income=8700.0}]

        if(personWithHighestIncome().isPresent()){
            Person p = personWithHighestIncome().get();
            System.out.println(" Person with high income is(2nd way):   " +p);
            //  Person with high income is(2nd way):   Person{id=3, name='Donna', gender=FEMALE, dob=1962-07-29, income=8700.0}
            // this outcome is dif than previous cuz->
        }


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
                .sorted(Comparator.comparing(Person::getIncome).reversed())//here
                //we use comparator with sort cuz it is custom object of Person.
                .toList();
        return sortedList;
    }
    // #4 challenge method
    static List<Person.Gender> distinctGendrs(){
        List<Person.Gender> genders = Person.persons()
                .stream()
                .map(Person::getGender)
                .distinct()// use this method cuz we dont want list of all males and females
                // we only want to know we have how many gender (male and female)
                .toList();
        return genders;
    }
    // method for challenge 5
    static  List<Person> firstThreePeople(){
        List<Person> top3 = Person.persons()
                .stream()
                .limit(3)// cuz we only want to see top 3 peopke
                .toList();
        return top3;
    }
    // challenge#6
    static  List<Person> skippedPeople(){
        List<Person> skipped2 = Person.persons()
                .stream()
                .skip(2)// use skip methos to skip elements.
                .toList();
        return skipped2;
    }
    // challenge#7 method
    static void displayNames(){
        Person.persons()
                .stream()
                // using peek method in intermediate operations.
                .peek(person -> System.out.println("Person name is: " + person.getName()))
                .forEach(System.out::println);
    }
    // cha;lenge 10 method
    static boolean anyPersonWithHighIncome(){
        boolean pc = Person.persons()
                .stream()
                .anyMatch(p->p.getIncome()>9000000);
        return pc;
    }
    //challenge 11 method
    static boolean areAllPeopleAreMale(){
        return  Person.persons()// we use return directly( no need to make object for it)
                .stream()
                .allMatch(Person::isMale);//isMale methos is already in our Person calss.
    }

    //challenge#12 Method
    //static boolean




    //challenge 13 method
    static long countFemale(){
        return Person.persons()
                .stream()
                .filter(Person::isFemale)
                .count();
    }

    // challenge 16 method: find person with highest income
    // we use optinal cuz it will give us

    static Optional<Person> personWithHighestIncome(){
        return Person.persons()
                .stream()
                // max is terminal operator that u give it comparator and it gives u the max->
                // we use it when we are asked to find max.
                .max(Comparator.comparingDouble(Person::getIncome));

    }




}
