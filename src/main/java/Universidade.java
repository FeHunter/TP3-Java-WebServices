import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) // Ignora propriedades desconhecidas, estava dando um erro.
public class Universidade {
    private String name;

    @JsonProperty("alpha_two_code")
    private String alphaTwoCode;

    private String country;

    @JsonProperty("state_province")
    private String stateProvince;

    @JsonProperty("web_pages")
    private List<String> webPages;

    @Override
    public String toString() {
        return "Universidade{" +
                "name='" + name + '\'' +
                ", alphaTwoCode='" + alphaTwoCode + '\'' +
                ", country='" + country + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", webPages=" + webPages +
                '}';
    }
}
