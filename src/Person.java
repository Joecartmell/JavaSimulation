import java.util.ArrayList;
import java.util.Random;

/* each person will have an identity from 1 to length of population, an infected value(0=not infected,
1 = infected, 2=immune) and an infection length which will increase up to 7 days (day 1 will be
infection counter 2, day 7 will be infection counter 8)
 */

class Person {
    ArrayList<Person> population = new ArrayList<Person>();
    int identity;
    InfectionState infected;
    int dayInfected;

    public Person(int myIdentity, InfectionState myInfected, int myDayInfected) {
        this.identity = myIdentity;
        this.infected = myInfected;
        this.dayInfected = myDayInfected;

    }

    public static enum InfectionState{
        UNINFECTED,
        INFECTED,
        IMMUNE
    }

    public String toString() {

        if(infected == InfectionState.UNINFECTED){
            return "(Person " + identity + ": Not infected)";
        }
        if(infected == InfectionState.INFECTED){
            return "(Person " + identity + ": Infected on day" + this.dayInfected + ")" ;
        }

        return ("(Person " + identity + ": Immune)");

    }

    //infect this person if not infected
    public void infectMe(){
        if(this.infected == InfectionState.UNINFECTED){
            this.infected = InfectionState.INFECTED;
            this.dayInfected = Simulator.dayOfSimulation;
        }else{
            System.out.println("Person " + this.identity + " already infected or immune");

        }
    }
// check if person infected

    public boolean isInfected(){
        if(this.infected == InfectionState.UNINFECTED){
            return false;
        } else{
            return true;
        }
    }


}

