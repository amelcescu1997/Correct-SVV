package org.loose.vvs.test1;

import org.junit.jupiter.api.Test;

//* allows the programmer to use all the asserts in the Assertions without importing all

import static org.junit.jupiter.api.Assertions.*;

public class IntervalTest {
    /*@Test
    void testCreate1() {
        Interval i = Interval.create(0, 5, IntervalType.OPEN);
        //no exception
        (true, true)
        assertSame(1, 1);
    }*/


    /* @Test
    void testIfTheNumbersAreTheSame() {
        Interval i = Interval.create(0, 5, IntervalType.OPEN);
        assertSame(1,1);
    }

    @Test
    void testIfTheNumbersAreDifferent() {
        Interval i = Interval.create(0, 6, IntervalType.OPEN);
        assertDifferent();
    }*/

    @Test
    void testIfOpenIsSuccessful() {
        Interval i = Interval.create(0, 5, IntervalType.OPEN);
        //no exception
        assertSame(1, 1);
    }

    @Test
    void testIfClosedIsSuccessful() {
        Interval i = Interval.create(0, 5, IntervalType.CLOSED);
        //no exception
        assertSame(1, 1);
    }

    @Test
    void testIfOpenLeftIsSuccessful() {
        Interval i = Interval.create(0, 5, IntervalType.OPEN_LEFT);
        //no exception
        assertSame(1, 1);
    }
    @Test
    void testIfOpenRightIsSuccessful() {
        Interval i = Interval.create(0, 5, IntervalType.OPEN_RIGHT);
        //no exception
        assertSame(1, 1);
    }

    @Test
    void testIfOpenHasAFailureOrException() {
        Interval.InvalidIntervalException thrown = assertThrows(
                Interval.InvalidIntervalException.class,
                () -> Interval.create(5, 0, IntervalType.OPEN)
        );

        assertTrue(true);
    }

    @Test
    void testIfClosedHasAFailureOrException() {
        Interval.InvalidIntervalException thrown = assertThrows(
                Interval.InvalidIntervalException.class,
                () -> Interval.create(5, 0, IntervalType.CLOSED)
        );

        assertTrue(true);
    }

    @Test
    void testIfOpenLeftHasAFailureOrException() {
        Interval.InvalidIntervalException thrown = assertThrows(
                Interval.InvalidIntervalException.class,
                () -> Interval.create(5, 0, IntervalType.OPEN_LEFT)
        );

        assertTrue(true);
    }

    @Test
    void testIfOpenRightHasAFailureOrException() {
        Interval.InvalidIntervalException thrown = assertThrows(
                Interval.InvalidIntervalException.class,
                () -> Interval.create(5, 0, IntervalType.OPEN_RIGHT)
        );

        assertTrue(true);
    }

    @Test
    void testIfOpenHasSameEndpointsWithException() {
        Interval.InvalidIntervalException thrown = assertThrows(
                Interval.InvalidIntervalException.class,
                () -> Interval.create(0, 0, IntervalType.OPEN)
        );

        assertTrue(true);
    }

    /*Closed should be successful*/
    /*Closed does not return an exception bc it's ok to have an interval with a single point*/
    @Test
    void testIfClosedHasSameEndpoints() {
        Interval i = Interval.create(0, 0, IntervalType.CLOSED);

        assertTrue(true);
    }

    @Test
    void testIfOpenLeftHasSameEndpointsWithException() {
        Interval.InvalidIntervalException thrown = assertThrows(
                Interval.InvalidIntervalException.class,
                () -> Interval.create(0, 0, IntervalType.OPEN_LEFT)
        );

        assertTrue(true);
    }

    @Test
    void testIfOpenRightHasSameEndpointsWithException() {
        Interval.InvalidIntervalException thrown = assertThrows(
                Interval.InvalidIntervalException.class,
                () -> Interval.create(0, 0, IntervalType.OPEN_RIGHT)
        );

        assertTrue(true);
    }

    @Test
    void testIfOpenHasConsecutiveEndpointsWithException() {
        Interval.InvalidIntervalException thrown = assertThrows(
                Interval.InvalidIntervalException.class,
                () -> Interval.create(0, 1, IntervalType.OPEN)
        );

        assertTrue(true);
    }

    /*Open Left is ok for above*/

    @Test
    void testIfOpenWithASingleElementIsSuccessful() {
        Interval i = Interval.create(0, 2, IntervalType.OPEN);
        //no exception
        assertTrue(i.contains(1));//the number in the middle
    }

    @Test
    void testIfOpenDoesNotContainLeftEndpoint() {
        Interval i = Interval.create(0, 2, IntervalType.OPEN);
        //no exception
        assertFalse(i.contains(0));
    }

    @Test
    void testIfOpenDoesNotContainRightEndpoint() {
        Interval i = Interval.create(0, 2, IntervalType.OPEN);
        //no exception
        assertFalse(i.contains(2));
    }

    @Test
    void testIfClosedDoesContainLeftEndpoint() {
        Interval i = Interval.create(0, 2, IntervalType.CLOSED);
        //no exception
        assertTrue(i.contains(0));
    }

    @Test
    void testIfClosedDoesContainRightEndpoint() {
        Interval i = Interval.create(0, 2, IntervalType.CLOSED);
        //no exception
        assertTrue(i.contains(2));
    }

    @Test
    void testIfOpenLeftDoesNotContainLeftEndpoint() {
        Interval i = Interval.create(0, 2, IntervalType.OPEN_LEFT);
        //no exception
        assertFalse(i.contains(0));
    }

    @Test
    void testIfOpenLeftDoesContainRightEndpoint() {
        Interval i = Interval.create(0, 2, IntervalType.OPEN_LEFT);
        //no exception
        assertTrue(i.contains(2));
    }

    @Test
    void testIfOpenRightDoesNotContainRightEndpoint() {
        Interval i = Interval.create(0, 2, IntervalType.OPEN_RIGHT);
        //no exception
        assertFalse(i.contains(2));
    }

    @Test
    void testIfOpenRightDoesContainLeftEndpoint() {
        Interval i = Interval.create(0, 2, IntervalType.OPEN_RIGHT);
        //no exception
        assertTrue(i.contains(0));
    }

    @Test
    void testIfOpenDoesNotContainNumberThatIsSmallerThanTheInterval() {
        Interval i = Interval.create(0, 2, IntervalType.OPEN);
        assertFalse(i.contains(-1));
    }

    @Test
    void testIfOpenDoesNotContainNumberThatIsGreaterThanTheInterval() {
        Interval i = Interval.create(0, 2, IntervalType.OPEN);
        assertFalse(i.contains(3));
    }
    //add 20 more tests: bad value left = 5, right = 0, interval type = open
    //12-15 for create (open, open right, open left, close) as above
    //(0, -1, open) --> bad interval should expect throw failure
    //(0, 0, open) --> exception ==> tested
    //(0, 1, open) --> exception
    //(0, 2, open) --> should work contains 1
    //test contains
    //(0, 2, open) assertTrue(Interval.contains(1));
    //(0, 2, open) assertFalse(Interval.contains(0));
    //(0, 2, open) assertFalse(Interval.contains(2));
    //(0, 2, OPEN_LEFT) assert closed on the right(it can contain 2) cannot contain 0 : (0, 2]

}
