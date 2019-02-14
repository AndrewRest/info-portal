package io.vertx.domain;

public class Info {
    
    private String randomFact;
    
    private Weather weather;

    public Info(String randomFact, Weather weather) {
        this.randomFact = randomFact;
        this.weather = weather;
    }
    
    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public String getRandomFact() {
        return randomFact;
    }

    public void setRandomFact(String randomFact) {
        this.randomFact = randomFact;
    }
    
    
}
