package config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown=true)
data class Access(
  @JsonProperty("user_god")
  var user: String,
  var pass: String,
  var host: String)

