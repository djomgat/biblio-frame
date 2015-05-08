package com.sample.biblio.fe.core.crude.controller.courrier;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sample.biblio.fe.core.utils.BiblioServiceDelegate;
import com.sample.biblio.model.courrier.TabNatureCourrier;
import com.sample.frame.core.svc.generic.IGenericSvc;
import com.sample.biblio.fe.core.crude.viewhelper.courrier.ServiceCrudeViewhelper;
import com.sample.biblio.fe.core.crude.wrapper.courrier.ServiceWrapper;
import com.sample.biblio.model.courrier.TabService;
import com.sample.biblio.svc.api.courrier.IServiceSvc;
import com.sample.frame.fe.controller.crude.BaseCrudeController;

@ManagedBean
@SessionScoped
public class ServiceCrudeController extends
		BaseCrudeController<TabService, ServiceWrapper> {

    IServiceSvc svc;

    @Override
    public IGenericSvc<TabService, String> getCurrentSvc() {
        try {
            System.out
                .println("ServiceCrudeController.getCurrentSvc() - Localisation du services");
            if (svc == null) {
                svc = BiblioServiceDelegate.getServiceSvc();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ServiceCrudeController.getCurrentSvc() - Est-ce-que mon service est localisé ? "
                                        + !(svc == null));
        return svc;
    }

    public ServiceCrudeController() {
        this.viewHelper = new ServiceCrudeViewhelper();
    }

}