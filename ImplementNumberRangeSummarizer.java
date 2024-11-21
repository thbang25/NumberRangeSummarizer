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
    
}

   