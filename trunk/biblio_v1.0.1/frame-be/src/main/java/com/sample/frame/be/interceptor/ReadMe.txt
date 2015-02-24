L'intercepteur permet d'intercepter l'invocation de méthodes EJB pour exécuter des traitements.
Ils sont définis grâce à des annotations dédiées notamment @Interceptors et @AroundInvoke 
ou dans le descripteur de déploiement.
Leur utilisation peut être variée : traces, logs, gestion des transactions, gestion de la sécurité, ...


Les intercepteurs sont utilisés dans la couche service principalement.
Utilisation de l'intercepteur de gestion des transaction

 public class PlayerServiceBean {

   @Inject
   private EntityManager em;

   @Transactional
   public void createPlayer(Player player) {
      em.persist(player);
   }
}