package config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Access(
  @JsonProperty("user")
  var userName: String,
  @JsonProperty("pass")
  var password: String,
  var host: String
)
