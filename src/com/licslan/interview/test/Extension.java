package com.licslan.interview.test;

/**
 * @author WEILIN
 */
public class Extension {

  String firstName;
  String lastName;
  String ext;
  String extType;

  public Extension(String firstName, String lastName, String ext, String extType) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.ext = ext;
    this.extType = extType;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getExt() {
    return ext;
  }

  public void setExt(String ext) {
    this.ext = ext;
  }

  public String getExtType() {
    return extType;
  }

  public void setExtType(String extType) {
    this.extType = extType;
  }
}
