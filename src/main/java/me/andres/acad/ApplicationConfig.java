package me.andres.acad;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class ApplicationConfig extends Application {
  // Needed to enable Jakarta REST and specify path.    
}
