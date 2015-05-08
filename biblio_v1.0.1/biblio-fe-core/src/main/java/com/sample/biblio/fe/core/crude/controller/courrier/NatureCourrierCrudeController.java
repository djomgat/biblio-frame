package com.sample.biblio.fe.core.crude.controller.courrier;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sample.biblio.fe.core.utils.BiblioServiceDelegate;
import com.sample.biblio.model.courrier.TabNatureCourrier;
import com.sample.frame.core.svc.generic.IGenericSvc;
import com.sample.biblio.fe.core.crude.viewhelper.courrier.NatureCourrierCrudeViewhelper;
import com.sample.biblio.fe.core.crude.wrapper.courrier.NatureCourrierWrapper;
import com.sample.biblio.svc.api.courrier.INatureCourrierSvc;
import com.sample.frame.fe.controller.crude.BaseCrudeController;

@ManagedBean
@SessionScoped
public class NatureCourrierCrudeController extends
		BaseCrudeController<TabNatureCourrier, NatureCourrierWrapper> {

    INatureCourrierSvc svc;

    @Override
    public IGenericSvc<TabNatureCourrier, String> getCurrentSvc() {
        try {
            System.out
                .println("NatureCourrierCrudeController.getCurrentSvc() - Localisation du services");
            if (svc == null) {
                svc = BiblioServiceDelegate.getNatureCourrierSvc();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out
            .println("NatureCourrierCrudeController.getCurrentSvc() - Est-ce-que mon service est localisé ? "
                                        + !(svc == null));
        return svc;
    }

    public NatureCourrierCrudeController() {
        this.viewHelper = new NatureCourrierCrudeViewhelper();
    }

}