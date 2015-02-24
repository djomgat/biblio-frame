/*

 */
package com.sample.frame.core.utils;

/**
 *
 * @author ECHOUPE
 */
public class TemperatureUtil {

    public double convertToCelsius(double f) {
        return ((f - 32) * 5 / 9);
    }

    public double convertToFarenheit(double c) {
        return ((c * 9 / 5) + 32);
    }
}