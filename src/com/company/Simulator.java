


public class Simulator {

    static int dayOfSimulation = 0;

    public static void main(String[] args) {
        // write your code here
        Person Joe = new Person(1, Person.InfectionState.UNINFECTED, 0);

        Population Manhattan = new Population(100);
        System.out.println(Manhattan);
        Manhattan.stats();
        Manhattan.firstInfection();
        System.out.println(Manhattan);
        Manhattan.simulateMultipleDays(10, 1);
        System.out.println(Manhattan);
        Manhattan.stats();
        Graph graph = new Graph();
		 Manhattan.createCoordinates();
        graph.CreateGraph();
       





    }

}