
/**
 * The ClockDisplay12 class implements a digital clock display for a
 * European-style 12 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 12:00 (midnight) to 11:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @author Riya Arora (101190033)
 * @version 2022.05.29
 */
public class ClockDisplay12
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String amPm;
    private static final String AM = "a.m.";
    private static final String PM = "p.m.";
    private String displayString; // simulates the actual display
    
    /**
     * Constructor for ClockDisplay12 objects. This constructor creates a new clock set at 12:00.
     */
    public ClockDisplay12()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        amPm = AM;
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay12 objects. This constructor creates a new clock set at the time specified by the parameters.
     * @param hour      Sets the hour of the current clock time
     * @param minutes   Sets the minute of the current clock time
     * @param amPm      Sets whether the time displayed is before or after noon
     */
    public ClockDisplay12(int hour, int minute, String amOrPm)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        if ((amOrPm.equals(AM)) || (amOrPm.equals(PM))) {
            amPm = amOrPm;
        } else {
            amPm = AM;
        }
        setTime(hour, minute, amPm);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
            if(hours.getValue() == 0) {
                if (amPm.equals(AM)){
                    amPm = PM;
                } else {
                    amPm = AM;
                }
            }   
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, String amOrPm)
    {
        if (hour == 12) {
            hours.setValue(0);
        }
        hours.setValue(hour);
        minutes.setValue(minute);
        if ((amOrPm.equals(AM)) || (amOrPm.equals(PM))) {
            amPm = amOrPm;
        } else {
            amPm = AM;
        }
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        int hour = hours.getValue();
        if (hours.getValue() == 0) {
            hour = 12;
        }
        displayString = hour + ":" + 
                        minutes.getDisplayValue() + 
                        amPm;
    }
}
