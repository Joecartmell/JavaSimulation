import java.util.ArrayList;
import java.util.Random;

/* each person will have an identity from 1 to length of population, an infected value(0=not infected,
1 = infected, 2=immune) and an infection length which will increase up to 7 days.
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
        return ("My values are " + "( " + identity + " , " + infected + " , " + infectionLength + " )");
    }

    //infect this person if not infected
    public void infectMe(){
        if(this.infected == 0){
            this.infected = 1;
            this.infectionLength = 1;
            System.out.println("Person " + this.identity + " infected");

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

      Population Manhattan = new Population(10);
      System.out.println(Manhattan);
      Manhattan.newInfection(2);
      System.out.println(Manhattan);
      Manhattan.oneDay(0);
      System.out.println(Manhattan);
      Manhattan.multipleDays(3,1);
      System.out.println(Manhattan);





    }
}

