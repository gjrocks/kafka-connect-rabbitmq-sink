package com.gj.rabbitmq.connectors.sink;


import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "city",
        "city_ascii",
        "state_id",
        "state_name",
        "county_fips",
        "county_name",
        "lat",
        "lng",
        "population",
        "density",
        "source",
        "military",
        "incorporated",
        "timezone",
        "ranking",
        "zips",
        "id",
        "temp",
        "duplicate"
})
@Generated("jsonschema2pojo")
public class City implements Serializable {

    @JsonProperty("city")
    private String city;
    @JsonProperty("city_ascii")
    private String cityAscii;
    @JsonProperty("state_id")
    private String stateId;
    @JsonProperty("state_name")
    private String stateName;
    @JsonProperty("county_fips")
    private Integer countyFips;
    @JsonProperty("county_name")
    private String countyName;
    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("lng")
    private Double lng;
    @JsonProperty("population")
    private Integer population;
    @JsonProperty("density")
    private Integer density;
    @JsonProperty("source")
    private String source;
    @JsonProperty("military")
    private String military;
    @JsonProperty("incorporated")
    private String incorporated;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("ranking")
    private Integer ranking;
    @JsonProperty("zips")
    private String zips;
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("temp")
    private Integer temp;

    @JsonProperty("duplicate")
    private Integer duplicate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("city_ascii")
    public String getCityAscii() {
        return cityAscii;
    }

    @JsonProperty("city_ascii")
    public void setCityAscii(String cityAscii) {
        this.cityAscii = cityAscii;
    }

    @JsonProperty("state_id")
    public String getStateId() {
        return stateId;
    }

    @JsonProperty("state_id")
    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    @JsonProperty("state_name")
    public String getStateName() {
        return stateName;
    }

    @JsonProperty("state_name")
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @JsonProperty("county_fips")
    public Integer getCountyFips() {
        return countyFips;
    }

    @JsonProperty("county_fips")
    public void setCountyFips(Integer countyFips) {
        this.countyFips = countyFips;
    }

    @JsonProperty("county_name")
    public String getCountyName() {
        return countyName;
    }

    @JsonProperty("county_name")
    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    @JsonProperty("lat")
    public Double getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(Double lat) {
        this.lat = lat;
    }

    @JsonProperty("lng")
    public Double getLng() {
        return lng;
    }

    @JsonProperty("lng")
    public void setLng(Double lng) {
        this.lng = lng;
    }

    @JsonProperty("population")
    public Integer getPopulation() {
        return population;
    }

    @JsonProperty("population")
    public void setPopulation(Integer population) {
        this.population = population;
    }

    @JsonProperty("density")
    public Integer getDensity() {
        return density;
    }

    @JsonProperty("density")
    public void setDensity(Integer density) {
        this.density = density;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("military")
    public String getMilitary() {
        return military;
    }

    @JsonProperty("military")
    public void setMilitary(String military) {
        this.military = military;
    }

    @JsonProperty("incorporated")
    public String getIncorporated() {
        return incorporated;
    }

    @JsonProperty("incorporated")
    public void setIncorporated(String incorporated) {
        this.incorporated = incorporated;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("ranking")
    public Integer getRanking() {
        return ranking;
    }

    @JsonProperty("ranking")
    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    @JsonProperty("zips")
    public String getZips() {
        return zips;
    }

    @JsonProperty("zips")
    public void setZips(String zips) {
        this.zips = zips;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("temp")
    public Integer getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Integer temp) {
        this.temp = temp;
    }


    @JsonProperty("duplicate")
    public Integer getDuplicate() {
        return duplicate;
    }

    @JsonProperty("duplicate")
    public void setDuplicate(Integer duplicate) {
        this.duplicate = duplicate;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "City{" +
                "city='" + city + '\'' +
                ", cityAscii='" + cityAscii + '\'' +
                ", stateId='" + stateId + '\'' +
                ", stateName='" + stateName + '\'' +
                ", countyFips=" + countyFips +
                ", countyName='" + countyName + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", population=" + population +
                ", density=" + density +
                ", source='" + source + '\'' +
                ", military='" + military + '\'' +
                ", incorporated='" + incorporated + '\'' +
                ", timezone='" + timezone + '\'' +
                ", ranking=" + ranking +
                ", zips='" + zips + '\'' +
                ", id=" + id +
                ", temp=" + temp +
                ", duplicate=" + duplicate +//
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    public String getKey(){
      return  this.getStateId()+"|"+this.getCity()+"|"+this.getId();
    }
}
