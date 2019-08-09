package android.example.gcuweatherapp.RSSFeed;

public class Weather {
    public String MINIMUM_TEMPERATURE;
    public String MAXIMUM_TEMPERATURE;
    public String WIND_DIRECTION;
    public String WIND_SPEED;
    public String VISIBILITY;
    public String PRESSURE ;
    public String HUMIDITY;
    public String UV_RISK;
    public String POLLUTION;
    public String SUNSET;
    public String SUNRISE;
    public String DATE;
    public String DAY;
    public String TONIGHT;
    public String RAIN;
    public String WEATHER_DESCRIPTOR;

    public void splitValues(String title, String description){
        String COMMA_DELIMITER = ",";
        String COLON_DELIMITER = ":";

        String splitTitle [] = title.split(COMMA_DELIMITER);
        String day = splitTitle[0].split(COLON_DELIMITER)[0];
        WEATHER_DESCRIPTOR = splitTitle[0].split(COLON_DELIMITER)[1];

        String splitDescription [] = description.split(COMMA_DELIMITER);
            if(splitDescription.length == 11){
                MAXIMUM_TEMPERATURE = splitDescription[0].split(COLON_DELIMITER)[1].
                        substring(1,5);
                MINIMUM_TEMPERATURE = splitDescription[1].split(COLON_DELIMITER)[1].
                        substring(1,5);
                WIND_DIRECTION = splitDescription[2].split(COLON_DELIMITER)[1];
                WIND_SPEED = splitDescription[3].split(COLON_DELIMITER)[1];
                VISIBILITY = splitDescription[4].split(COLON_DELIMITER)[1];
                PRESSURE = splitDescription[5].split(COLON_DELIMITER)[1];
                HUMIDITY = splitDescription[6].split(COLON_DELIMITER)[1];
                UV_RISK = splitDescription[7].split(COLON_DELIMITER)[1];
                POLLUTION = splitDescription[8].split(COLON_DELIMITER)[1];
                SUNRISE = splitDescription[9].split(COLON_DELIMITER)[1];
                SUNSET = splitDescription[10].split(COLON_DELIMITER)[1];
            }
            else if(splitDescription.length == 9){
                MINIMUM_TEMPERATURE = splitDescription[0].split(COLON_DELIMITER)[1].
                        substring(1,5);
                WIND_DIRECTION = splitDescription[1].split(COLON_DELIMITER)[1];
                WIND_SPEED = splitDescription[2].split(COLON_DELIMITER)[1];
                VISIBILITY = splitDescription[3].split(COLON_DELIMITER)[1];
                PRESSURE = splitDescription[4].split(COLON_DELIMITER)[1];
                HUMIDITY = splitDescription[5].split(COLON_DELIMITER)[1];
                UV_RISK = splitDescription[6].split(COLON_DELIMITER)[1];
                POLLUTION = splitDescription[7].split(COLON_DELIMITER)[1];
                SUNSET = splitDescription[8].split(COLON_DELIMITER)[1];
        }

    }
    public String getMINIMUM_TEMPERATURE() {
        return MINIMUM_TEMPERATURE;
    }

    public void setMINIMUM_TEMPERATURE(String MINIMUM_TEMPERATURE) {
        this.MINIMUM_TEMPERATURE = MINIMUM_TEMPERATURE;
    }

    public String getMAXIMUM_TEMPERATURE() {
        return MAXIMUM_TEMPERATURE;
    }

    public void setMAXIMUM_TEMPERATURE(String MAXIMUM_TEMPERATURE) {
        this.MAXIMUM_TEMPERATURE = MAXIMUM_TEMPERATURE;
    }

    public String getWIND_DIRECTION() {
        return WIND_DIRECTION;
    }

    public void setWIND_DIRECTION(String WIND_DIRECTION) {
        this.WIND_DIRECTION = WIND_DIRECTION;
    }

    public String getWIND_SPEED() {
        return WIND_SPEED;
    }

    public void setWIND_SPEED(String WIND_SPEED) {
        this.WIND_SPEED = WIND_SPEED;
    }

    public String getVISIBILITY() {
        return VISIBILITY;
    }

    public void setVISIBILITY(String VISIBILITY) {
        this.VISIBILITY = VISIBILITY;
    }

    public String getPRESSURE() {
        return PRESSURE;
    }

    public void setPRESSURE(String PRESSURE) {
        this.PRESSURE = PRESSURE;
    }

    public String getHUMIDITY() {
        return HUMIDITY;
    }

    public void setHUMIDITY(String HUMIDITY) {
        this.HUMIDITY = HUMIDITY;
    }

    public String getUV_RISK() {
        return UV_RISK;
    }

    public void setUV_RISK(String UV_RISK) {
        this.UV_RISK = UV_RISK;
    }

    public String getPOLLUTION() {
        return POLLUTION;
    }

    public void setPOLLUTION(String POLLUTION) {
        this.POLLUTION = POLLUTION;
    }

    public String getSUNSET() {
        return SUNSET;
    }

    public void setSUNSET(String SUNSET) {
        this.SUNSET = SUNSET;
    }

    public String getSUNRISE() {
        return SUNRISE;
    }

    public void setSUNRISE(String SUNRISE) {
        this.SUNRISE = SUNRISE;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public String getDAY() {
        return DAY;
    }

    public void setDAY(String DAY) {
        this.DAY = DAY;
    }

    public String getTONIGHT() {
        return TONIGHT;
    }

    public void setTONIGHT(String TONIGHT) {
        this.TONIGHT = TONIGHT;
    }

    public String getRAIN() {
        return RAIN;
    }

    public void setRAIN(String RAIN) {
        this.RAIN = RAIN;
    }

    public String getWEATHER_DESCRIPTOR(){
        return WEATHER_DESCRIPTOR;
    }

    public void setWEATHER_DESCRIPTOR(String WEATHER_DESCRIPTOR){
        this.WEATHER_DESCRIPTOR = WEATHER_DESCRIPTOR;
    }
}
