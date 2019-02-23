package io.kroki.xmind;

public class Platform {

  private static String OS = System.getProperty("os.name").toLowerCase();

  public static String getOS() {
    return OS;
  }
}
