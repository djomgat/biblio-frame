/*

 */
package com.sample.frame.core.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Miscellaneous utility methods for number conversion and parsing.
 * Mainly for internal use within the framework; consider Jakarta's
 * Commons Lang for a more comprehensive suite of string utilities.
 *
 * @author Juergen Hoeller
 * @author Rob Harrop
 * @since 1.1.2
 */
public abstract class NumberUtils {

    /**
     * Convert the given number into an instance of the given target class.
     * @param number the number to convert
     * @param targetClass the target class to convert to
     * @return the converted number
     * @throws IllegalArgumentException if the target class is not supported
     * (i.e. not a standard Number subclass as included in the JDK)
     * @see java.lang.Byte
     * @see java.lang.Short
     * @see java.lang.Integer
     * @see java.lang.Long
     * @see java.math.BigInteger
     * @see java.lang.Float
     * @see java.lang.Double
     * @see java.math.BigDecimal
     */
    public static Number convertNumberToTargetClass(Number number, Class targetClass)
                    throws IllegalArgumentException {

        if (targetClass.isInstance(number)) {
                return number;
        }
        else if(targetClass.equals(Byte.class)) {
                return new Byte(number.byteValue());
        }
        else if (targetClass.equals(Short.class)) {
                return new Short(number.shortValue());
        }
        else if (targetClass.equals(Integer.class)) {
                return new Integer(number.intValue());
        }
        else if (targetClass.equals(Long.class)) {
                return new Long(number.longValue());
        }
        else if (targetClass.equals(Float.class)) {
                return new Float(number.floatValue());
        }
        else if (targetClass.equals(Double.class)) {
                return new Double(number.doubleValue());
        }
        else if (targetClass.equals(BigInteger.class)) {
                return BigInteger.valueOf(number.longValue());
        }
        else if (targetClass.equals(BigDecimal.class)) {
            // using BigDecimal(String) here, to avoid unpredictability of BigDecimal(double)
            // (see BigDecimal javadoc for details)
            return new BigDecimal(number.toString());
        }
        else {
            throw new IllegalArgumentException("Couldn't convert number [" + number +
                            "] to target class [" + targetClass.getName() + "]");
        }
    }

    /**
     * Parse the given text into a number instance of the given target class,
     * using the corresponding default <code>valueOf</code> methods. Trims the
     * input <code>String</code> before attempting to parse the number.
     * @param text the text to convert
     * @param targetClass the target class to parse into
     * @return the parsed number
     * @throws IllegalArgumentException if the target class is not supported
     * (i.e. not a standard Number subclass as included in the JDK)
     * @see java.lang.Byte#valueOf
     * @see java.lang.Short#valueOf
     * @see java.lang.Integer#valueOf
     * @see java.lang.Long#valueOf
     * @see java.math.BigInteger#BigInteger(String)
     * @see java.lang.Float#valueOf
     * @see java.lang.Double#valueOf
     * @see java.math.BigDecimal#BigDecimal(String)
     */
    public static Number parseNumber(String text, Class targetClass) {
        String trimmed = text.trim();

        if(targetClass.equals(Byte.class)) {
                return Byte.valueOf(trimmed);
        }
        else if (targetClass.equals(Short.class)) {
                return Short.valueOf(trimmed);
        }
        else if (targetClass.equals(Integer.class)) {
                return Integer.valueOf(trimmed);
        }
        else if (targetClass.equals(Long.class)) {
                return Long.valueOf(trimmed);
        }
        else if (targetClass.equals(BigInteger.class)) {
                return new BigInteger(trimmed);
        }
        else if (targetClass.equals(Float.class)) {
                return Float.valueOf(trimmed);
        }
        else if (targetClass.equals(Double.class)) {
                return Double.valueOf(trimmed);
        }
        else if (targetClass.equals(BigDecimal.class)) {
                return new BigDecimal(trimmed);
        }
        else {
                throw new IllegalArgumentException(
                                "Cannot convert [" + trimmed + "] to target class [" + targetClass.getName() + "]");
        }
    }

    /**
     * Parse the given text into a number instance of the given target class,
     * using the given NumberFormat. Trims the input <code>String</code>
     * before attempting to parse the number.
     * @param text the text to convert
     * @param targetClass the target class to parse into
     * @param numberFormat the NumberFormat to use for parsing
     * @return the parsed number
     * @throws IllegalArgumentException if the target class is not supported
     * (i.e. not a standard Number subclass as included in the JDK)
     * @see java.text.NumberFormat#parse
     * @see #convertNumberToTargetClass
     */
    public static Number parseNumber(String text, Class targetClass, NumberFormat numberFormat) {
        try {
            Number number = numberFormat.parse(text.trim());
            return convertNumberToTargetClass(number, targetClass);
        }
        catch (ParseException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

}

