package com.api.restfull;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.restfull.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

  @GetMapping(path = "/sum/{n1}/{n2}")
  public Double sum(
      @PathVariable(value = "n1") String n1,
      @PathVariable(value = "n2") String n2) throws Exception {
    if (!isNUmeric(n1) || !isNUmeric(n2)) {
      throw new UnsupportedMathOperationException("Please set a numeric value.");
    }
    return convertToDouble(n1) + convertToDouble(n2);
  }

  private Double convertToDouble(String numberString) {
    if (numberString == null)
      return 0D;

    String number = numberString.replaceAll(",", ".");

    if (!isNUmeric(number))
      return 0D;

    if (!isNUmeric(numberString))
      return 0D;

    return Double.parseDouble(number);
  }

  private boolean isNUmeric(String numberString) {
    if (numberString == null)
      return false;
    String number = numberString.replaceAll(",", ".");
    return number.matches("[-+]?[0-9]*\\.?[0-9]+");
  }

}
