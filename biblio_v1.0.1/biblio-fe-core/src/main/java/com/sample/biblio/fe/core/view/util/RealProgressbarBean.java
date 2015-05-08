
package com.sample.biblio.fe.core.view.util;

import com.sample.frame.core.logging.BaseLogger;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author ECHOUPE
 */
@ManagedBean(name="RealProgressbarBean")
public class RealProgressbarBean implements Serializable {  

  private Integer progress;  
  
  private static final BaseLogger log = BaseLogger.getLogger(RealProgressbarBean.class) ;

  public Integer getProgress() {  
    if(progress == null)  
      progress = 0;  
    else {  
      progress = progress + (int)(Math.random() * 35);      
      if(progress > 100)  
      progress = 100;  
    }  

    return progress;  
  }  

  public void setProgress(Integer progress) {  
    this.progress = progress;  
  }  

  public void onComplete() {  
    FacesContext.getCurrentInstance().addMessage(null, 
        new FacesMessage(FacesMessage.SEVERITY_INFO, "Progress Completed", "Progress Completed"));  
  }  

  public void cancel() {  
    progress = null;  
  }  
}
