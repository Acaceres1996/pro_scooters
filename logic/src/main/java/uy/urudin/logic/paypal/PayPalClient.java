package uy.urudin.logic.paypal;


import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;

import java.util.Iterator;

public class PayPalClient {
  private PayPalEnvironment environment = new PayPalEnvironment.Sandbox(
    "YOUR APPLICATION CLIENT ID",
    "YOUR APPLICATION CLIENT SECRET");

  PayPalHttpClient client = new PayPalHttpClient(environment);

  public PayPalHttpClient client() {
    return this.client;
  }
}