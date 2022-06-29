package com.framework.test.config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class CRMUsers(
  @JsonProperty("ADMINISTRATOR")
  var administrator: Administrator
)
