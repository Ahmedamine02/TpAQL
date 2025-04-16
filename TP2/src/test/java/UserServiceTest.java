import org.example.ServiceException;
import org.example.UserService;
import org.example.Utilisateur;
import org.example.UtilisateurApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verifyNoMoreInteractions;


import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Test
    public void testCreerUtilisateur() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");

        // TODO : Configuration du comportement du mock (ici, pas de retour, mais pas d'exception non plus)
        // Donc rien à faire sauf si on veut forcer un comportement particulier, sinon c’est implicite

        // TODO : Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);

        // TODO : Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);

        // TODO : Vérification de l'appel à l'API
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);

        // Optionnel : s'assurer qu'aucune autre méthode n’a été appelée
        verifyNoMoreInteractions(utilisateurApiMock);
    }
}
