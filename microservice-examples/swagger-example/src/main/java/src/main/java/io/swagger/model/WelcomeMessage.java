package io.swagger.model;


import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class WelcomeMessage  {
  
  private String mesage = null;

  
  /**
   * The welcome message
   **/
  @ApiModelProperty(value = "The welcome message")
  @JsonProperty("mesage")
  public String getMesage() {
    return mesage;
  }
  public void setMesage(String mesage) {
    this.mesage = mesage;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class WelcomeMessage {\n");
    
    sb.append("  mesage: ").append(mesage).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
