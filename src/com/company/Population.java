import java.util.ArrayList;
import java.util.Random;


class Population {
    ArrayList<Person> myPopulation = new ArrayList<Person>();
    int length;


    // new population of length myLength

    public Population(int myLength) {
        this.length = myLength;
        for (int i = 1; i <= this.length; i++) {
            Person p = new Person(i, 0, 0);
            myPopulation.add(p);
        }
    }
    //print my arraylist of Persons when printing

    public String toString() {
        return ("My population is " + myPopulation);
    }

//infect "infections" amount of people within this population if they are not infected

    public void newInfection(int infections){
        int count = 0;
        for(int i =0; i < myPopulation.size() && count < infections ; i++){
                Person workingPerson = myPopulation.get(i);
                if(workingPerson.isInfected() == false){
                        workingPerson.infectMe();
                        myPopulation.set(myPopulation.indexOf(myPopulation.get(i)), workingPerson);
                        count++;
                }
                }

        }

   // method to run one days worth of infections and tick over the infection counter (infectionLength)
    public void oneDay(int newinfections){
        //new infections
        newInfection(newinfections);

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
                workingPerson.infected = 2;
                myPopulation.set(myPopulation.indexOf(person), workingPerson);
            }
        }
        }



    //method to run "days" amount of days worth of infections with "infectionsPerDay" amount of infections per day
     public void multipleDays(int days, int infectionsPerDay){
        for(int i =1; i <= days; i++){
            oneDay(infectionsPerDay);
        }

    }



}