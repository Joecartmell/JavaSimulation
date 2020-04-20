import java.util.ArrayList;
import java.util.Random;

/* each person will have an identity from 1 to length of population, an infected value(0=not infected,
1 = infected, 2=immune) and an infection length which will increase up to 7 days (day 1 will be
infection counter 2, day 7 will be infection counter 8)
 */

class Person {
    ArrayList<Person> population = new ArrayList<Person>();
    int identity;
    int infected;
    int infectionLength;

    public Person(int myIdentity, int myInfected, int myInfectionlength) {
        this.identity = myIdentity;
        this.infected = myInfected;
        this.infectionLength = myInfectionlength;

    }

    public String toString() {
        if(infected == 0){
            return "(Person " + identity + ": Not infected)";
        }
        if(infected == 1){
            return "(Person " + identity + ": Infection day " + (infectionLength -1)+ " )";
        }

        return ("(Person " + identity + ": Immune)");

    }

    //infect this person if not infected
    public void infectMe(){
        if(this.infected == 0){
            this.infected = 1;
            this.infectionLength = 1;
        }else{
            System.out.println("Person " + this.identity + " already infected or immune");

        }
    }
// check if person infected

    public boolean isInfected(){
        if(this.infected == 0){
            return false;
        } else{
            return true;
        }
    }


    public static void main(String[] args) {
        // write your code here
        Person Joe = new Person(1, 0, 0);

      Population Manhattan = new Population(100);
      System.out.println(Manhattan);
      Manhattan.stats();
      Manhattan.multipleDays(25,3);
      System.out.println(Manhattan);
      Manhattan.stats();





    }
}

