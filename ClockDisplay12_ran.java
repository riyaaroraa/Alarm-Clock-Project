/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * @author Riya Arora 101190033
 * @version 2022.01.26
 */
public class ClockDisplay12
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;  // simulates the actual display
    private String AMPM;
    private static final String AM = "a.m.";
    private static final String PM = "p.m.";
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay12()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }
    /**
     * Constructor for ClockDisplay sets the time using 3 paramters:
     * @param hour The hour portion of the clock time (1-12)
     * @param minute The minutes portion of the clock time (0-59)
     * @param time Whether the clock is set at "a.m." or "p.m."
     */
    public ClockDisplay12(int hour, int minute, String time)
    {
        if (time.equals(AM) || time.equals(PM)){
            minutes = new NumberDisplay(60);
            hours = new NumberDisplay(12);
            setTime(hour, minute, time);
        }
        else{
            minutes = new NumberDisplay(60);
            hours = new NumberDisplay (12);
            AMPM = AM;
            setTime(hour, minute, AMPM);
        }
       
    }
    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {   // it just rolled over!
            hours.increment();
                if (hours.getValue() == 0)
                     if (AMPM.equals(AM)){
                         AMPM = PM;
                        }
                    else if (AMPM.equals(PM)){
                        AMPM = AM;
                    }
        }
        updateDisplay();
    }
    /**
     * Method sets the time using 3 paramters:
     * @param hour The hour portion of the clock time (1-12)
     * @param minute The minutes portion of the clock time (0-59)
     * @param time Whether the clock is set at "a.m." or "p.m."
     */
    public void setTime(int hour, int minute, String time)
    {
        if (hour == 12){
            hours.setValue(0);
        }
        hours.setValue(hour);
        minutes.setValue(minute);
        if(time.equals(PM) || time.equals(AM))
        {
            AMPM = time;
        }
        else{
            AMPM = AM;
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
        if (hours.getValue() == 0){
            displayString = "12" + ":" + minutes.getDisplayValue() + AMPM;
        }
        else{
            displayString = hours.getValue() + ":" + minutes.getDisplayValue()
            + AMPM;
        }
    }
}