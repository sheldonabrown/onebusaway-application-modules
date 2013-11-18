package org.onebusaway.api.actions;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.web.context.ServletContextAware;

public class ContextOverrideSupport implements ServletContextAware {

  private static final String SERVICE_KEY = "serviceUrl";
  
  @Autowired
  private HessianProxyFactoryBean hessianProxyFactory;
  
  private static Logger _log = LoggerFactory.getLogger(ContextOverrideSupport.class);
  
  @Override
  public void setServletContext(ServletContext sc) {
    if (sc != null) {
      if (sc.getInitParameter(SERVICE_KEY) != null) {
        hessianProxyFactory.setServiceUrl(sc.getInitParameter(SERVICE_KEY));
        hessianProxyFactory.prepare();
        _log.info("overriding serviceURL=" + hessianProxyFactory.getServiceUrl());
      }
    }
  }

}
