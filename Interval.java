package org.loose.vvs.test1;

public class Interval {

    //always set the instance variables if not already
    private int left;
    private int right;
    private IntervalType type;

    private Interval(int left, int right, IntervalType type) {
        // TODO: implement
        // initializing the instance variables
        this.left = left;
        this.right = right;
        this.type = type;
        //Interval constructor completed
    }

    /**
     * @param number
     * @return whether the number is contained in the interval. This depends both on the boundaries and on the type of the interval the method is called on.
     */
    public boolean contains(int number) {
        // TODO: implement
        if (type == IntervalType.OPEN) {
            return left < number && number < right;
        } else if (type == IntervalType.OPEN_LEFT) {
            return left < number && number <= right;
        } else if (type == IntervalType.OPEN_RIGHT) {
            return left <= number && number < right;
        } else {
            return left <= number && number <= right;
        }
    }

    /**
     * @param left specifies the left boundary of the interval
     * @param right specifies the right boundary of the interval
     * @param type specifies the type of the interval
     *
     * If the creation method gets invalid arguments, it should throw an InvalidIntervalException (which is a RuntimeException)
     * Otherwise, it should create a new interval with the provided parameters.
     */
    public static Interval create(int left, int right, IntervalType type) {
        // TODO: implement
        // create = factory method
        // validate the arguments
        if (type == IntervalType.OPEN) {
            //OPEN = left and right are excluded from the interval
            if (left >= right - 1) {
                throw new InvalidIntervalException(left, right, type);
            }
        } else if (type == IntervalType.OPEN_LEFT) {
            if (left >= right) {
                throw new InvalidIntervalException(left, right, type);
            }
        } else if (type == IntervalType.OPEN_RIGHT) {
            if (left >= right) {
                throw new InvalidIntervalException(left, right, type);
            }
        } else if (type == IntervalType.CLOSED) {
            if (left > right) {
                throw new InvalidIntervalException(left, right, type);
            }
        } else {
            throw new InvalidIntervalException(left, right, type);
        }
        return new Interval(left, right, type);
    }

    public static class InvalidIntervalException extends RuntimeException {
        //start with a constructor
        public InvalidIntervalException(int left, int right, IntervalType type) {
            super("left: " + left + ", right: " + right + ", type: " + type);
        }
    }

}
