package com.sample.biblio.fe.core.crude.controller.courrier;

import com.sample.biblio.fe.core.crude.viewhelper.courrier.PersonneCrudeViewhelper;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sample.biblio.fe.core.utils.BiblioServiceDelegate;
import com.sample.frame.core.svc.generic.IGenericSvc;
import com.sample.biblio.fe.core.crude.wrapper.courrier.PersonneWrapper;
import com.sample.biblio.model.courrier.TabPersonne;
import com.sample.biblio.svc.api.courrier.IPersonneSvc;
import com.sample.frame.fe.controller.crude.BaseCrudeController;

@ManagedBean
@SessionScoped
public class PersonneCrudeController extends
		BaseCrudeController<TabPersonne, PersonneWrapper> {

    IPersonneSvc svc;

    @Override
    public IGenericSvc<TabPersonne, String> getCurrentSvc() {
        try {
            System.out
                .println("PersonneCrudeController.getCurrentSvc() - Localisation du services");
            if (svc == null) {
                svc = BiblioServiceDelegate.getPersonneSvc();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("PersonneCrudeController.getCurrentSvc() - Est-ce-que mon service est localisé ? "
                                        + !(svc == null));
        return svc;
    }

    public PersonneCrudeController() {
        this.viewHelper = new PersonneCrudeViewhelper();
    }

}