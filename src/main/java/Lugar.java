import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
class Lugar {
    @JsonProperty("place name")
    private String placeName;

    @JsonProperty("longitude")
    private String longitude;

    @JsonProperty("state")
    private String state;

    @JsonProperty("state abbreviation")
    private String stateAbbreviation;

    @JsonProperty("latitude")
    private String latitude;
}