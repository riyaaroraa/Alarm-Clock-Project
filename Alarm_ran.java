/**
 * The Alarm class implements a boolean alarm to a 12-hour clock.
 * The alarm shows hours and minutes, and the range of the display is
 * 12:00 to 11:59.
 * 
 * The alarm reads the current clock display with the getTime method. 
 * It then assigns a boolean value of either true or false to the time depending
 * on whether it matches witht the set alarm time or not. True signifies the alarm is on,
 * false signifies the alarm is off.
 * 
 * @author Riya Arora 101190033
 * @version 2022.01.26
 */
public class Alarm
{
    private ClockDisplay12 alarm;
    private boolean On_Off;
    private static final String AM = "p.m.";
    private static final String PM = "a.m.";

    /**
     * Default no paramater constructor. Sets clock to midnight and 
     * turns alarm off. 
     */
    public Alarm()
    {
        alarm = new ClockDisplay12(0, 0, AM);
        On_Off = false;
    }
    /**
     * Constructor sets the alarm time and indicates whether the alarm is set using 4 paramters:
     * @param hours The hour portion of the alarm time (1-12)
     * @param minutes The minutes portion of the alarm time (0-59)
     * @param AMPM Whether the alarm is set at "a.m." or "p.m."
     * @param On_Off Whether the alarm is set or not using boolean
     * 
     */
    public Alarm(int hours, int minutes, String AMPM, boolean On_Off)
    {
        alarm = new ClockDisplay12(hours, minutes, AMPM);
        this.On_Off = On_Off;
    }
    /**
     * Method sets the time using 3 paramters:
     * @param hours The hour portion of the clock time (1-12)
     * @param mins The minutes portion of the clock time (0-59)
     * @param AMPM Whether the clock is set at "a.m." or "p.m."
     */
    public void setTime (int hours, int minutes, String AMPM){
        alarm.setTime(hours, minutes, AMPM);
    }
    /**
     * Method turns alarm on.
     */
    public void turnOn(){
        On_Off = true;
    }
    /**
     * Method turns alarm off.
     */
    public void turnOff(){
        On_Off = false;
    }
    /**
     * Method returns String rep. of current alarm time.
     */
    public String getTime(){
        return alarm.getTime();
    }
    /**
     * Boolean method indicates alarm status by displaying true if alarm is set
     * and false otherwise.
     */
    public boolean isSet(){
        return On_Off;
    }
}