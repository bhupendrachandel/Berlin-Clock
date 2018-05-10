package com.ubs.opsit.interviews;


public class TimeConverterImpl implements TimeConverter {

    private static final String ALL_HOURS_O="OOOO";
    private static final String RED="R";
    private static final String ALL_MINUTES_O="OOOOOOOOOOO";
    private static final String YELLOW="Y";
    private static final String NEWLINE="\n";
    private static final String COLON=":";
    private static final String O="O";


    public String convertTime(String aTime) {

        String timeArray[] = aTime.split(COLON);


        String hr = getHours(Integer.parseInt(timeArray[0]));
        String mn = getMinutes(Integer.parseInt(timeArray[1]));
        String sec = getSeconds(Integer.parseInt(timeArray[2]));

        return sec + NEWLINE + hr + mn;
    }

    // Get hours method will take an argument as hrs and return the equvivalent Berlin clock hours on top two rows
    protected String getHours(int p_hours){

        StringBuffer hours;
        hours = new StringBuffer(ALL_HOURS_O);

        int topHour = p_hours / 5;

        for (int i =0;i< topHour;i++){

            hours.replace(i,i+1,RED);

        }
        hours.append(NEWLINE);

        int secondRowHour = p_hours % 5;

        StringBuilder lowerHrs;
        lowerHrs = new StringBuilder(ALL_HOURS_O);

        for (int i =0;i< secondRowHour;i++){

            lowerHrs.replace(i,i+1,RED);

        }
        hours.append(lowerHrs);
        hours.append(NEWLINE);
        return hours.toString();

    }

    // Get Minutes method will take an argument as minutes and return the equvivalent Berlin clock minutes on the minutes  rows

    protected String getMinutes(int p_minutes){

        StringBuilder minutes;
        minutes = new StringBuilder(ALL_MINUTES_O);

        int topMin = p_minutes / 5;

        for (int i =0;i< topMin;i++){

            if(0==(i+1 )% 3 ){
                minutes.replace(i,i+1,RED);

        }else {
                minutes.replace(i,i+1,YELLOW);
            }
        }
        minutes.append(NEWLINE);

        int secondMinRow = p_minutes % 5;

        StringBuilder lowerMin= new StringBuilder(ALL_HOURS_O);
        for (int i =0;i< secondMinRow;i++){

            lowerMin.replace(i,i+1,YELLOW);

        }
        minutes.append(lowerMin);

        return minutes.toString();
    }

    protected String getSeconds(int seconds){
        if(0==seconds % 2 ){
            return YELLOW;
        }
        return O;
    }


}
