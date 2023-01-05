
/**
 * The Alarm class implements an alarm using the ClockDisplay12 class.
 * 
 * The alarm can be turned on and off as nescessary (through the turnOn() and turnOff() methods, respectively). 
 * 
 *
 * @author Riya Arora (101190033)
 * @version 2022.05.29
 */
public class Alarm
{
    private ClockDisplay12 alarmTime;
    private boolean isSet;

    /**
     * Constructor for objects of class Alarm
     */
    public Alarm()
    {
        alarmTime = new ClockDisplay12();
        isSet = false;
    }
    
    /**
     * Constructor for Alarm Objects. This constructor creates a new Alarm at the time specified by the parameters. 
     * 
     * @param hours     sets the hour of the alarm
     * @param minutes   sets the minute of the alarm
     * @param amPm      sets whether the alarm it set in the morning or night
     * @param set       sets the alarm to on or off
     */
    public Alarm(int hours, int minute, String amPm, boolean set) {
        alarmTime = new ClockDisplay12(hours, minute, amPm);
        isSet = set;
    }

    /**
     * This method is used to set the time of the alarm
     *
     * @param hours     sets the hour of the alarm
     * @param minutes   sets the minute of the alarm
     * @param amPm      sets whether the alarm it set in the morning or night
     */
    public void setTime(int hours, int minutes, String amPM)
    {
         alarmTime.setTime(hours, minutes, amPM);   
    }
    
    /**
     * This method turns on the alarm
     */
    public void turnOn() {
        isSet = true;
    }
    
    /**
     * This method turns off the alarm
     */
    public void turnOff() {
        isSet = false;
    }
    
    /**
     * This method returns the current time of the alarm set
     * @return      A String representation of the time of the alarm 
     */
    public String getTime() {
        return alarmTime.getTime();
    }
    
    /**
     * This method returns whether an alarm is set or not
     * @return      Whether an alarm is set or not
     */
    public boolean isSet() {
        return isSet;
    }
}
