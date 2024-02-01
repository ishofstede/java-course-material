# Lambdas and Streams exercise

1. Within class `LambdasStreamExercise`, implement method `dnaToAbbreviatedNames`. 
   Create a stream of the given DNA sequence and convert it into a String representation that 
   is a sequence of the first three letters of the name of each nucleotide, separated by dots.
   For example, the sequence "ACG" should return "Ade.Cyt.Gua". 
   You may assume regular DNA is passed as argument (e.g. DNA_ONE or DNA_TWO). Implement these 
   individual steps in your stream:  
   
   - Start with `DNA.chars()` to initiate a Stream. This will be one of integers.
   - Convert the integers into Nucleotide objects (use casting and `mapToObj()`)
   - Convert Nucleotide instances in String objects
   - Concatenate the strings to a single one
   
2. Within class `LambdasStreamExercise`, implement method `dnaToWeight` in order to determine 
   the molecular weight of a DNA sequence string from its nucleotides. Implement these 
   individual steps in your stream:  
     
   - Start with `DNA.chars()` to initiate a Stream. This will be one of integers.
   - Filter out those that do not represent regular DNA (Challenge: and count them)
   - Convert to a stream of Character objects from the given DNA sequence
   - Convert the Characters into Nucleotide objects
   - Convert the Nucleotide objects to their weights
   - Sum the weights and return the result (And report the number of rejected nucleotides)

3. Within class `LambdasStreamExercise`, implement method `countNucleotide` to count the occurrence
   of a given nucleotide in a DNA sequence. Implement these individual steps in your stream:  
   
   - Start with `DNA.chars()` to initiate a Stream. This will be one of integers.
   - Convert the integers into Nucleotide objects (use casting and `mapToObj()`)
   - Filter those of the correct type
   - Count them
     

You can run the tests in class `LambdasStreamExerciseTest` to verify the correctness of your solution. 

