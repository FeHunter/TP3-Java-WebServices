import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
class Localizacao {
    @JsonProperty("post code")
    private String postCode;

    @JsonProperty("country")
    private String country;

    @JsonProperty("country abbreviation")
    private String countryAbbreviation;

    @JsonProperty("places")
    private List<Lugar> places;
}