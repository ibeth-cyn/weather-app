package android.example.gcuweatherapp.RSSFeed;

public class Weather {

    private String title;
    private String description;
    private String publicationDate;

    private String minimumTemperature;
    private String maximumTemperature;
    private String windDirection;
    private String windSpeed;
    private String visibility;
    private String pressure ;
    private String humidity;
    private String uvRisk;
    private String pollution;
    private String sunset;
    private String sunrise;
    private String date;
    private String day;
    private String tonight;
    private String rain;
    private String weatherDescription;

    public Weather(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Weather() {
    }

    //public void splitValues(String title, String description){
    public void splitValues(String title, String description){

        this.title = title;
        this.description = description;

        final String COMMA_DELIMITER = ",";
        final String COLON_DELIMITER = ":";

        String splitTitle [] = title.split(COMMA_DELIMITER);
        String day = splitTitle[0].split(COLON_DELIMITER)[0];
        weatherDescription = splitTitle[0].split(COLON_DELIMITER)[1];

        String splitDescription [] = description.split(COMMA_DELIMITER);
            if(splitDescription.length == 11){
                maximumTemperature = splitDescription[0].split(COLON_DELIMITER)[1].
                        substring(1,5);
                minimumTemperature = splitDescription[1].split(COLON_DELIMITER)[1].
                        substring(1,5);
                windDirection = splitDescription[2].split(COLON_DELIMITER)[1];
                windSpeed = splitDescription[3].split(COLON_DELIMITER)[1];
                visibility = splitDescription[4].split(COLON_DELIMITER)[1];
                pressure = splitDescription[5].split(COLON_DELIMITER)[1];
                humidity = splitDescription[6].split(COLON_DELIMITER)[1];
                uvRisk = splitDescription[7].split(COLON_DELIMITER)[1];
                pollution = splitDescription[8].split(COLON_DELIMITER)[1];
                sunrise = splitDescription[9].split(COLON_DELIMITER)[1];
                sunset = splitDescription[10].split(COLON_DELIMITER)[1];
            }
            else if(splitDescription.length == 9){
                maximumTemperature = splitDescription[0].split(COLON_DELIMITER)[1].
                        substring(1,5);
                windDirection = splitDescription[1].split(COLON_DELIMITER)[1];
                windSpeed = splitDescription[2].split(COLON_DELIMITER)[1];
                visibility = splitDescription[3].split(COLON_DELIMITER)[1];
                pressure = splitDescription[4].split(COLON_DELIMITER)[1];
                humidity = splitDescription[5].split(COLON_DELIMITER)[1];
                uvRisk = splitDescription[6].split(COLON_DELIMITER)[1];
                pollution = splitDescription[7].split(COLON_DELIMITER)[1];
                sunset = splitDescription[8].split(COLON_DELIMITER)[1];
        }

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(String minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

    public String getMaximumTemperature() {
        return maximumTemperature;
    }

    public void setMaximumTemperature(String maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getUvRisk() {
        return uvRisk;
    }

    public void setUvRisk(String uvRisk) {
        this.uvRisk = uvRisk;
    }

    public String getPollution() {
        return pollution;
    }

    public void setPollution(String pollution) {
        this.pollution = pollution;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTonight() {
        return tonight;
    }

    public void setTonight(String tonight) {
        this.tonight = tonight;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getWeatherDescription(){

        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription){
        this.weatherDescription = weatherDescription;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "publicationDate='" + publicationDate + '\'' +
                ", minimumTemperature='" + minimumTemperature + '\'' +
                ", maximumTemperature='" + maximumTemperature + '\'' +
                ", windDirection='" + windDirection + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", visibility='" + visibility + '\'' +
                ", pressure='" + pressure + '\'' +
                ", humidity='" + humidity + '\'' +
                ", uvRisk='" + uvRisk + '\'' +
                ", pollution='" + pollution + '\'' +
                ", sunset='" + sunset + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", date='" + date + '\'' +
                ", day='" + day + '\'' +
                ", tonight='" + tonight + '\'' +
                ", rain='" + rain + '\'' +
                ", weatherDescription='" + weatherDescription + '\'' +
                '}';
    }
}
