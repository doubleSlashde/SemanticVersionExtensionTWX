package de.ds.twx.server.extension;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Just some smoke tests currently
 */
class SemVerComparisonThingTest {

   private final SemVerComparisonThing semVerComparisonThing = new SemVerComparisonThing();

   @Test
   void isGreaterThan() {
      boolean isGreater = semVerComparisonThing.IsGreaterThan("1.0.0-alpha.1", "1.0.0-alpha");
      assertTrue(isGreater);
   }

   @Test
   void isGreaterThanOrEqualTo() {
      boolean isGreaterThanOrEqualTo = semVerComparisonThing.IsGreaterThanOrEqualTo("1.0.0-alpha.1", "1.0.0-alpha");
      assertTrue(isGreaterThanOrEqualTo);

      boolean isGreaterThanOrEqualTo2 = semVerComparisonThing.IsGreaterThanOrEqualTo("1.0.0", "1.0.0");
      assertTrue(isGreaterThanOrEqualTo2);
   }

   @Test
   void isLowerThan() {
      boolean isLowerThan = semVerComparisonThing.IsLowerThan("1.0.0-alpha", "1.0.0-alpha.1");
      assertTrue(isLowerThan);
   }

   @Test
   void IsLowerThanOrEqualTo() {
      boolean isLowerThanOrEqualTo = semVerComparisonThing.IsLowerThanOrEqualTo("1.0.0-alpha", "1.0.0-alpha.1");
      assertTrue(isLowerThanOrEqualTo);

      boolean isLowerThanOrEqualTo2 = semVerComparisonThing.IsLowerThanOrEqualTo("1.0.0", "1.0.0");
      assertTrue(isLowerThanOrEqualTo2);
   }

   @Test
   void isEqualTo() {
      boolean isEqualTo = semVerComparisonThing.IsEqualTo("1.0.0", "1.0.0");
      assertTrue(isEqualTo);
   }

   @Test
   void coerce() {
      String coercedVersion = semVerComparisonThing.Coerce("1");
      assertEquals("1.0.0", coercedVersion);
   }

   @Test
   void isValid() {
      boolean isValid = semVerComparisonThing.IsValid("1.0.0");
      assertTrue(isValid);
   }

   @Test
   void isStable() {
      boolean isStable = semVerComparisonThing.IsStable("1.0.0");
      assertTrue(isStable);
   }

   @Test
   void shouldThrowIllegalArgumentWhenParameterIsNull() {
      assertThrows(IllegalArgumentException.class, () -> semVerComparisonThing.IsGreaterThan(null, null),
            "Expected specific exception when parameter was null");

      assertThrows(IllegalArgumentException.class, () -> semVerComparisonThing.Coerce(null),
            "Expected specific exception when parameter was null");
   }
}