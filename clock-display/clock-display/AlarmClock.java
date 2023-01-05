
/**
 * The AlarmClock class implements an alarm clock. 
 * 
 * This alarm clocks works by tracking the current time and the alarm time. If they match, and if the alarm is on,
 * then it will ring. 
 *
 * @author Riya Arora (101190033)
 * @version 2022.05.29
 */
public class AlarmClock
{
    private ClockDisplay12 currentTime;
    private Alarm alarm;

    /**
     * Constructor for objects of class AlarmClock
     */
    public AlarmClock()
    {
        currentTime = new ClockDisplay12();
        alarm = new Alarm();
    }
    
    /**
     * Constructor for AlarmClock with parameters to set the current time and the time for the alarm and whether the alarm is on
     * 
     * @param currHr    sets the hour of the clock
     * @param alarmHr   sets the hour of the alarm
     * @param currMin   sets the minutes of the clock
     * @param alarmMin  sets the minutes of the alarm
     * @param currAmPm  sets whether the clock time it set in the morning or night
     * @param alarmAmPm sets whether the alarm it set in the morning or night
     * @param isOn      sets the alarm to on or off
     */
    public AlarmClock(int currHr, int currMin, String currAmPm, int alarmHr, int alarmMin, String alarmAmPm, boolean isOn)
    {
        currentTime = new ClockDisplay12(currHr, currMin, currAmPm);
        alarm = new Alarm(alarmHr, alarmMin, alarmAmPm, isOn);
    }

    /**
     * This method sets the time on the clock
     * 
     * @param hours     sets the hour of the clock
     * @param minutes   sets the minutes of the clock
     * @param amPm      sets whether the current time is before or after noon
     */
    public void setTime(int hours, int minutes, String amPm)
    {
        currentTime.setTime(hours, minutes, amPm);
    }
    
    /**
     * This method sets the time of the alarm
     * 
     * @param hours     sets the hour of the alarm
     * @param minutes   sets the minutes of the alarm
     * @param amPm      sets whether the alarm it set in the morning or night
     */
    public void setAlarmTime(int hours, int minutes, String amPm)
    {
        alarm.setTime(hours, minutes, amPm);
    }
    
    /**
     * This method makes the clock tick. If the current time matches the alarm time, the alarm will ring, and then turn off. 
     */
    public void clockTick()
    {
        currentTime.timeTick();
        if ((getTime().equals(getAlarmTime())) && (alarm.isSet())){
            System.out.println("RING RING RING");
            unsetAlarm();
        }
    }
    
    /**
     * This method turns on the alarm
     */
    public void setAlarm() 
    {
        alarm.turnOn();
    }
    
    /**
     * This method turns off the alarm
     */
    public void unsetAlarm()
    {
        alarm.turnOff();
    }
    
    /**
     * Rhis method returns a string representation of the current clock time
     */
    public String getTime()
    {
        return currentTime.getTime();
    }
    
    /**
     * This method returns a string representation of the alarm time
     */
    public String getAlarmTime()
    {
        return alarm.getTime();
    }
    
    /**
     * A method that returns if the alarm is set or not
     */
    public boolean isAlarmSet()
    {
        return alarm.isSet();
    }
}
