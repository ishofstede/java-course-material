package section2_syntax.part1_datatypes;

/**
 * Creation date: May 28, 2018
 *
 * @author Michiel Noback (&copy; 2018)
 * @version 0.01
 */
public class Datatypes {
    /*
    * For the following couple of methods, simply return the name of the datatype that best supports
    * the given usage.
    * Choose from
    *   - boolean
    *   - char
    *   - byte
    *   - short
    *   - int
    *   - long
    *   - double
    *   - float
    *   - String
    *
    * The first one has already been implemented as example.
    */

    String correctDataType0() {
        //USAGE: the number of days within a year
        return "short";
    }

    String correctDataType1() {
        //USAGE: the age of the universe in whole years. Change the return value -null- to a correct value
        //- the name of the data type that is correct here
        return "long";
    }

    String correctDataType2() {
        //USAGE: the turnover of ATP in a cell, in Molar per minute
        return "float";
    }

    String correctDataType3() {
        //USAßGE: the molecular weight of a protein, in Daltons
        return "float";
    }

    String correctDataType4() {
        //USAGE: the alive/death status of a test animal
        return "boolean";
    }

    String correctDataType5() {
        //USAGE: the name of an app user
        return "String";
    }

    String correctDataType6() {
        //USAGE: encoding of human gender (Male, Female, Undefined)
        return "char";
    }

    /* NEW SECTION OF ASSIGNMENTS */

    /**
     * The method below is supposed to calculate the G+C fraction of a DNA sequence.
     * It should do so case insensitive - have a look at the methods in class `String`.
     * Start by uncommenting the method body (select the block and press "Ctrl + /").
     * Identify and solve the three problems and one error in this method.
     * Only then the test with the same name will pass (in class DatatypesTest)
     */
    double determineGCfraction(String theDNA) {
        int gcCount = 0;  // Initialize gcCount to 0
        theDNA = theDNA.toUpperCase();  // Convert theDNA to uppercase for case-insensitive comparison

        for (int i = 0; i < theDNA.length(); i++) {
            char nucleotide = theDNA.charAt(i);
            if (nucleotide == 'C' || nucleotide == 'G') {
                gcCount++;  // Increment gcCount if nucleotide is C or G
            }
        }

        // Convert gcCount or length to double for floating-point division
        double fraction = (double) gcCount / theDNA.length();
        return fraction;  // Return the calculated GC fraction
    }


    /**
     * The method below creates a string and calls another method -replaceWord()- to change it.
     * Something goes wrong - it should return "where can I find the sodamachine in this building?"
     *
     * Can you fix it?
     */
    String modifyString() {
        String input = "where can I find the coffeemachine in this building?";
        input = replaceWord(input, "coffee", "soda"); // Capture the modified string
        return input;
    }


    /**
     * This method is linked to the method above as a single assignment.
     */
    String replaceWord(String input, String replace, String replaceWith) {
        return input.replace(replace, replaceWith);
    }

    /**
     * This method should return a String array of length 2 with the first and last element
     * of the input array in it, converted to their String representations.
     * For any Java object you can use object.toString() to get this string representation
     */
    String[] getFirstAndLastAsStringRepresentation(Object[] input) {
        // Create a new String array with length 2
        String[] result = new String[2];

        // Assign the string representation of the first element to the first slot
        result[0] = input[0].toString();

        // Assign the string representation of the last element to the second slot
        result[1] = input[input.length - 1].toString();

        return result;
    }


    /**
     * This method should return a new int array where all integers from the input have been cubed (power of 3).
     * For convenience, the skeleton of a for loop is already provided.
     * @param input
     * @return cubedInput
     */
    int[] cubeAll(int[] input) {
        // Get the correct array length from the input array
        int arrayLength = input.length;

        // Create a new array to store the cubed values
        int[] cubedInput = new int[arrayLength];

        // Iterate through each element of the input array
        for(int i = 0; i < arrayLength; i++) {
            // Cube the value and store it in the cubedInput array
            cubedInput[i] = input[i] * input[i] * input[i];
        }

        // Return the cubed array
        return cubedInput;
    }


    /**
     * This method should return the cumulative product of all numbers in the input array.
     * @param input the input number array
     * @return the cumulative product
     */
    int cumulativeProduct(int[] input) {
        // Start the cumulative product with 1 (neutral element for multiplication)
        int product = 1;

        // Loop through the input array
        for (int i = 0; i < input.length; i++) {
            product *= input[i]; // Multiply each element with the product
        }

        // Return the final cumulative product
        return product;
    }

}
//
//    Floating point division: In Java, dividing integers results in integer division (truncates the decimal). To get accurate floating-point results, cast one or both operands to double.
//
//        String immutability: Strings in Java are immutable, meaning methods like replace() do not modify the original string but return a new string. You must assign the result to a variable to capture the change.
//
//        Floating-point division example: Ensure at least one operand is a double for correct decimal division. For example, double fraction = (double) gcCount / theDNA.length().
//
//        Modifying a string with replace: When using replaceWord(input, "coffee", "soda"), reassign the result of replaceWord to modify the original string: input = replaceWord(input, "coffee", "soda");.
//
//        Extract first and last element as string representation: Convert array elements to strings using object.toString(), and return a new string array with the first and last elements.
//
//        Cube all elements in an array: Use a for-loop to iterate over an array, cube each element (input[i] = input[i] * input[i] * input[i]), and store the result in a new array.
//
//        Cumulative product of an array: Initialize a variable to 1, loop through the array multiplying each element by the cumulative product, and return the final product.