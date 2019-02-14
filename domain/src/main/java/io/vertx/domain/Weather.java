package io.vertx.domain;

public class Weather {
    
    private Integer temperature;
    
    private String description;

    public Weather(Integer temperature, String description) {
        this.temperature = temperature;
        this.description = description;
    }
    
    public Weather() {
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }
    
    

}
