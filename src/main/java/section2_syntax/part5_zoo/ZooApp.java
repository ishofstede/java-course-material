package section2_syntax.part5_zoo;

import java.util.List;

import java.util.List;

public class ZooApp {

    public static void main(String[] args) {
        ZooApp zooApp = new ZooApp();
        zooApp.processZooData(args);
        zooApp.printZooSummary();
    }

    /**
     * Processes the command line data.
     * @param args the command line arguments containing species names
     */
    void processZooData(String[] args) {
        for (String speciesName : args) {
            // Register each species using the static method from ZooSpecies
            ZooSpecies.registerSpeciesFromString(speciesName);
        }
    }

    /**
     * Prints a summary of the zoo.
     */
    void printZooSummary() {
        final List<ZooSpecies> allSpecies = ZooSpecies.getAllSpecies(); // fetch all species
        System.out.println("The zoo has " + allSpecies.size() + " species."); // Print total species count
        System.out.println("These are the species counts:"); // Print header

        for (ZooSpecies species : allSpecies) {
            // Print each species and its individual count
            System.out.println("    " + species.getSpeciesName() + ": " + species.getIndividualCount());
        }
    }
}

