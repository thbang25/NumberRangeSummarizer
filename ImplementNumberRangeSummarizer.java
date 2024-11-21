/*
Thabang Sambo
Impact take home test
number range summerizer
*/

import java.util.*;

public class ImplementNumberRangeSummarizer implements NumberRangeSummarizer {

   @Override
   public Collection<Integer> collect(String input) {
      // Split the input string by commas and convert to integers
      String[] parts = input.split(",");
      List<Integer> numbers = new ArrayList<>();
      for (String part : parts) {
         try {
            numbers.add(Integer.parseInt(part.trim()));
         } catch (NumberFormatException e) {
            // Handle invalid input gracefully
            System.err.println("Invalid number format: " + part);
         }
      }
      // Sort the numbers for proper range grouping
      Collections.sort(numbers);
      return numbers;
   }
   
   @Override
   public String summarizeCollection(Collection<Integer> input) {
      if (input == null || input.isEmpty()) {
         return "";
      }
      
      
      List<Integer> sortValues = new ArrayList<>(input);
      StringBuilder buildStringValue = new StringBuilder();
      int startPoint = sortValues.get(0);
      
      //Get the previous and start point
      int subsequentValue = startPoint;
     
     //Go through the list
      for (int i = 1; i < sortValues.size(); i++) {
         int current = sortValues.get(i);
         if (current != subsequentValue + 1) {
            // Add the range to the buildStringValue
            combineStrings(buildStringValue, startPoint, subsequentValue);
            startPoint = current;
         }
         subsequentValue = current;
      }
      // Append the final range
      combineStrings(buildStringValue, startPoint, subsequentValue);
      //return built value
      return buildStringValue.toString();
   }
   
   //Put together the strings
   private void combineStrings(StringBuilder result, int start, int end) {
      if (result.length() > 0) {
         result.append(", ");
      }
      if (start == end) {
         result.append(start);
      } else {
         result.append(start).append("-").append(end);
      }
   }

   // Main method for testing
   public static void main(String[] args) {
      NumberRangeSummarizer rangeSummary = new ImplementNumberRangeSummarizer();
      String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
      Collection<Integer> collected = rangeSummary.collect(input);
      String summarized = rangeSummary.summarizeCollection(collected);
      System.out.println("Input: " + input);
      System.out.println("Summarized: " + summarized);
   }
}