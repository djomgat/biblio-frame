/*

 */
package com.sample.biblio.fe.core.crude.controller.courrier;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sample.frame.core.svc.generic.IGenericSvc;
import com.sample.biblio.model.courrier.TabCourrier;
import com.sample.biblio.svc.api.courrier.ICourrierSvc;
import com.sample.biblio.fe.core.crude.wrapper.courrier.CourrierWrapper;
import com.sample.biblio.fe.core.crude.viewhelper.courrier.CourrierCrudeViewhelper;
import com.sample.biblio.fe.core.utils.BiblioServiceDelegate;
import com.sample.frame.fe.controller.crude.BaseCrudeController;

/**
 *
 * @author ECHOUPE
 */
@ManagedBean
@SessionScoped
public class CourrierCrudeController extends
		BaseCrudeController<TabCourrier, CourrierWrapper> {

    ICourrierSvc svc;

    @Override
    public IGenericSvc<TabCourrier, String> getCurrentSvc() {
        try {
            System.out
                    .println("CourrierCrudeController.getCurrentSvc() - Localisation du services");
            if (svc == null) {
                    svc = BiblioServiceDelegate.getCourrierSvc();			
            }
        } catch (Exception e) {
                e.printStackTrace();
        }
        System.out
                .println("CourrierCrudeController.getCurrentSvc() - Est-ce-que mon service est localisé ? "
                                        + !(svc == null));

        return svc;
    }

    public CourrierCrudeController() {
            this.viewHelper = new CourrierCrudeViewhelper();
    }

    public String navigateToEditCourrierEntrant(){
        return "editCourrierEntrant";
    }

}