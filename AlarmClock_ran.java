/**
 * The AlarmClock class implements an alarm to a 12 hour display clock. When the current time 
 * reaches the alarm clock time, it displays the string, "RING! RING! RING!", from the clockTick 
 * method. This is done by comparing getTime and getAlarmTime to see if they are the same, and 
 * if they are, boolean's 'true' appears and triggers the alarm string statement.
 *
 * @author Riya Arora 101190033
 * @version 2022.01.26
 */
public class AlarmClock
{
    
    private ClockDisplay12 newTime; 
    private Alarm newAlarm;
    private static final String AM = "a.m.";
    private static final String PM = "p.m.";

    /**
     * Default no paramter constructor that sets the clock and alarm to 12:00 (midnight). 
     * It also turns the alarm off.
     */
    public AlarmClock()
    {
        newTime = new ClockDisplay12(0, 0, AM);
        newAlarm = new Alarm(0, 0, AM, false);
    }
    /**
     * Constructor sets the time, alarm time and indicates whether the alarm is set using 7 paramters
     * @param hrs The hour portion of the clock time (1-12)
     * @param mins The minutes portion of the clock time (0-59)
     * @param AMPm1 Whether the clock is set at "a.m." or "p.m."
     * @param hrs1 The hour portion of the alarm time (1-12)
     * @param mins2 The minutes portion of the alarm time (0-59)
     * @param AMPM2 Whether the alarm is set at "a.m." or "p.m."
     * @param On_Off Whether the alarm is set or not using boolean
     * 
     */
    public AlarmClock(int hrs, int mins, String AMPm1,int hrs1, int
    mins1, String AMPM2, boolean On_Off)
    {
        newTime = new ClockDisplay12(hrs, mins, AMPm1);
        newAlarm = new Alarm(hrs1, mins1, AMPM2, On_Off);
    }
    /**
     * Method sets the time using 3 paramters:
     * @param hours The hour portion of the clock time (1-12)
     * @param mins The minutes portion of the clock time (0-59)
     * @param AMPM1 Whether the clock is set at "a.m." or "p.m."
     */
    public void setTime(int hours, int mins, String AMPM1){
        newTime.setTime(hours, mins, AMPM1);
    }
    /**
     * Method sets the alarm time using 3 paramters:
     * @param hours1 The hour portion of the alarm time (1-12)
     * @param mins1 The minutes portion of the alarm time (0-59)
     * @param AMPM2 Whether the alarm is set at "a.m." or "p.m."
     * 
     */
    public void setAlarmTime(int hours1, int mins1, String AMPM2){
        newAlarm.setTime(hours1, mins1, AMPM2);
    }
    /**
     * Method that ticks the clock minute by minute. It also rings the alarm when getTime is equal to
     * getAlarmTime, and turns it off afterwards.
     */
    public void clockTick(){
        newTime.timeTick();
        if (newTime.getTime().equals(newAlarm.getTime()) && newAlarm.isSet() == true){
            System.out.println("RING! RING! RING!");
            newAlarm.turnOff();
        }
    }
    /**
     * Method turns alarm on.
     */
    public void setAlarm(){
        newAlarm.turnOn();
    }
    /**
     * Method turns alarm off.
     */
    public void unSetAlarm(){
        newAlarm.turnOff();
    }
    /**
     * Method returns String rep. of new time.
     */
    public String getTime(){
        return newTime.getTime();
    }
    /**
     * Method returns String rep. of new alarm time.
     */
    public String getAlarmTime(){
        return newAlarm.getTime();
    }
    /**
     * Boolean method using isSet indicates alarm status by displaying true if alarm is set
     * and false otherwise.
     */
    public boolean isAlarmSet(){
        return newAlarm.isSet();
    }
}
