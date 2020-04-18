import java.util.ArrayList;
import java.util.Random;

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

    public void newInfections() {

        for (int i = 0; i < 3; i++) {
            Person workingPerson = population.get(i);
            System.out.println(workingPerson);
            workingPerson.infected = workingPerson.infected + 1;
            System.out.println(workingPerson);
            population.set(population.indexOf(population.get(i)), workingPerson);
        }
    }


    public static void main(String[] args) {
        // write your code here
        Person Joe = new Person(1, 0, 0);
        int populationSize = 10;
        ArrayList<Person> population = new ArrayList<Person>();
        for (int i = 1; i <= populationSize; i++) {
            Person p = new Person(i, 0, 0);
            population.add(p);

        }
        int count = 0;
      while (count < 3) {
          Person workingPerson = population.get(count);
          if (workingPerson.infected == 0) {
              workingPerson.infected = workingPerson.infected + 1;
              System.out.println(workingPerson);
              population.set(population.indexOf(population.get(count)), workingPerson);
              count++;
          }
          }
         System.out.println(population);
      int newCount = 0;
      int numPeople = 3;
      while (newCount < numPeople) {
          Person workingPerson = population.get(newCount);
          if (workingPerson.infected == 0) {
              workingPerson.infected = workingPerson.infected + 1;
              System.out.println(workingPerson);
              newCount++;
          }else{
              newCount++;
              numPeople++; }
          population.set(population.indexOf(population.get(newCount)), workingPerson);
        }

        System.out.println(population);




    }
}

