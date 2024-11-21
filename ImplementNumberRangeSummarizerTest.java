/*
Thabang Sambo
Impact take home test
number range summerizer
*/

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ImplementNumberRangeSummarizerTest {

   private final NumberRangeSummarizer summarizer = new ImplementNumberRangeSummarizer();


// Junit test that input is valid for the collection of input
   @Test
   void testCollectValidInput() {
      String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
      Collection<Integer> expected = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
      Collection<Integer> actual = summarizer.collect(input);
      assertEquals(expected, actual);
   }

// Junit test that input is valid for the collection of unsorted input
   @Test
   void testUnsortedInput() {
      String input = "15,1,14,3,13,12,7,6,8,31,24,23,21,22";
      Collection<Integer> expected = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
      Collection<Integer> actual = summarizer.collect(input);
      assertEquals(expected, actual);
   }
   
// Junit test that input is valid for the collection of invalid input
   @Test
   void testInvalidInput() {
      String input = "1,3,abc,7, ,12";
      Collection<Integer> expected = Arrays.asList(1, 3, 7, 12);
      Collection<Integer> actual = summarizer.collect(input);
      assertEquals(expected, actual);
   }

// Junit test that input is valid for the collection of empty input
   @Test
   void testEmptyInput() {
      String input = "";
      Collection<Integer> actual = summarizer.collect(input);
      assertTrue(actual.isEmpty());
   }

// Junit test that input is valid for the collection of valid input
   @Test
   void testValidInput() {
      Collection<Integer> input = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
      String expected = "1, 3, 6-8, 12-15, 21-24, 31";
      String actual = summarizer.summarizeCollection(input);
      assertEquals(expected, actual);
   }

// Junit test that input is valid for the collection of for single input value
   @Test
   void testSingleNumber() {
      Collection<Integer> input = Collections.singletonList(42);
      String expected = "42";
      String actual = summarizer.summarizeCollection(input);
      assertEquals(expected, actual);
   }

}
