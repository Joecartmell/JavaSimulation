import java.util.ArrayList;
import java.util.Random;


class Population {
    ArrayList<Person> myPopulation = new ArrayList<Person>();
    int size;


    // new population of length myLength

    public Population(int myLength) {
        this.size = myLength;
        for (int i = 1; i <= this.size; i++) {
            Person p = new Person(i, Person.InfectionState.UNINFECTED, 0);
            myPopulation.add(p);
        }
    }
    //print my arraylist of Persons when printing

    public String toString() {
        return ("My population is " + myPopulation);
    }

/*infect amount of people within this population if they are not infected. R0 is the amount
of people that one infected person will spread too
 */

    public void newInfection(int R0) {
        int newInfectionsSoFar = 0;
        double numberToBeInfected = amountOfPeopleInfected() * R0;
        for (int i = 0; i < myPopulation.size() && newInfectionsSoFar < numberToBeInfected; i++) {

            if (!myPopulation.get(i).isInfected()) {
                myPopulation.get(i).infectMe();
                newInfectionsSoFar++;
            }
        }
    }

//infect first person in population
   public void firstInfection() {
            myPopulation.get(0).infectMe();
        }




   // method to run one days worth of infections and tick over the infection counter (infectionLength)
    public void oneDay(int R0){
        //new infections
        newInfection(R0);

        //infection counter tickover
        for(Person person : myPopulation){
            for(int i = 1; i <= 7; i++){
                if(person.infectionLength == i){
                    Person workingPerson = new Person(person.identity, person.infected, person.infectionLength);
                    workingPerson.infectionLength = i +1;
                    myPopulation.set(myPopulation.indexOf(person), workingPerson);
                }

            }
            if(person.infectionLength == 8){
                Person workingPerson = new Person(person.identity, person.infected, person.infectionLength);
                workingPerson.infectionLength = 0;
                workingPerson.infected = Person.InfectionState.IMMUNE ;
                myPopulation.set(myPopulation.indexOf(person), workingPerson);
            }
        }
        }



    //method to run "days" amount of days worth of infections with "infectionsPerDay" amount of infections per day
     public void multipleDays(int days, int R0){
        for(int i =1; i <= days; i++){
            oneDay(R0);

        }
         System.out.println("Running " + days + " days with an R0 of " + R0);

    }

    public double amountOfPeopleInfected(){
        double peopleInfected = 0;
        for(Person person: myPopulation){
            if(person.infected == Person.InfectionState.INFECTED){
                peopleInfected++;
            }

        }
        return peopleInfected;

    }
    //percentage of people Infected
    public void percentInfected(){
        double populationLength = this.size;
        double percentInfected = (amountOfPeopleInfected() / (populationLength)* 100) ;
        System.out.printf("%.1f", percentInfected);
        System.out.println("% of people are infected");

    }
//percentage of people immune
    public void percentImmune(){
        double peopleImmune = 0;
        double populationLength = this.size;
        for(Person person:myPopulation){
            if(person.infected == Person.InfectionState.IMMUNE){
                peopleImmune++;
            }
        }
        double percentImmune = (peopleImmune / (populationLength) * 100);
        System.out.printf("%.1f", percentImmune);
        System.out.println("% of people are recovered");
    }
    //percentage of people not yet infected or recovered
    public void percentNotInfected(){
        double peopleNotInfected = 0;
        double populationLength = this.size;
        for(Person person:myPopulation){
            if(person.infected == Person.InfectionState.UNINFECTED){
                peopleNotInfected++;
            }
        }
        double percentNotInfected = (peopleNotInfected / (populationLength) * 100);
        System.out.printf("%.1f", percentNotInfected);
        System.out.println("% of people have not been infected");
    }
    //gives statistics on population
    public void stats(){
        System.out.println("In this population:");
        percentInfected();
        percentImmune();
        percentNotInfected();
    }




}