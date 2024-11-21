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
   
  //A summary of the collections
  
   @Override
   public String CollectionImplementation(Collection<Integer> input) {
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
            appendRange(buildStringValue, startPoint, subsequentValue);
            startPoint = current;
         }
         subsequentValue = current;
      }
      // Append the final range
      appendRange(buildStringValue, startPoint, subsequentValue);
      //return built value
      return buildStringValue.toString();
   }
   
}

