import org.example.ServiceException;
import org.example.UserService;
import org.example.Utilisateur;
import org.example.UtilisateurApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.junit.jupiter.api.Assertions.assertEquals;



import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    private final Utilisateur utilisateur = new Utilisateur("ahmed", "koffi", "amine@gmail.com",4);


    @Test
    public void testCreerUtilisateur() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("ahmed", "koffi", "amine@gmail.com",4);

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
    @Test(expected = ServiceException.class)
    public void testCreerUtilisateur_Exception() throws ServiceException {
        // Simulation de l'exception
        doThrow(new ServiceException("Echec de la création de l'utilisateur"))
                .when(utilisateurApiMock).creerUtilisateur(utilisateur);

        // Création du service
        UserService userService = new UserService(utilisateurApiMock);

        // Appel
        userService.creerUtilisateur(utilisateur);
    }

    @Test
    public void testCreerUtilisateur_ErreurValidation() throws ServiceException {
        // Simuler un utilisateur invalide
        Utilisateur utilisateurInvalide = new Utilisateur("koffi", "ahmed", "",4);


        // Création du service
        UserService userService = new UserService(utilisateurApiMock);

        // Appel (on suppose qu’on ajoute une validation dans la méthode)
        try {
            userService.creerUtilisateur(utilisateurInvalide);
        } catch (IllegalArgumentException e) {
            // Vérifie que l'API n'a jamais été appelée
            verify(utilisateurApiMock, never()).creerUtilisateur(any());
        }
    }

    @Test

    public void testCreerUtilisateurAvecId() throws ServiceException {
        // Mock
        Utilisateur utilisateur = new Utilisateur("ahmed", "koffi", "amine@gmail.com",4);
        int idUtilisateur = 123;

        // Simulation : l’API crée l’utilisateur et lui attribue un ID
        doAnswer(invocation -> {
            Utilisateur u = invocation.getArgument(0); // Récupère l’utilisateur passé en argument
            u.setId(idUtilisateur); // Simule que l’API lui donne un ID
            return null;
        }).when(utilisateurApiMock).creerUtilisateur(utilisateur);


        // Service
        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur); // variable utilisateur avec minuscule

        // Vérification
        assertEquals(idUtilisateur, utilisateur.getId());
    }



    @Test
    public void testCreerUtilisateur_ArgumentCaptor() throws ServiceException {
        // Création du captor pour les arguments de type Utilisateur
        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);

        // Simuler un appel sans exception (car la méthode est void)
        doNothing().when(utilisateurApiMock).creerUtilisateur(any(Utilisateur.class));

        // Création du service et appel de la méthode
        UserService userService = new UserService(utilisateurApiMock);
        Utilisateur utilisateur = new Utilisateur("ahmed", "koffi", "amine@gmail.com",4);
        userService.creerUtilisateur(utilisateur);

        // Vérifier que l'API a bien été appelée avec un utilisateur
        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());

        // Récupérer l'utilisateur capturé et faire des assertions
        Utilisateur utilisateurCapture = argumentCaptor.getValue();
        assertEquals("ahmed", utilisateurCapture.getPrenom());
        assertEquals("koffi", utilisateurCapture.getNom());
        assertEquals("amine@gmail.com", utilisateurCapture.getEmail());
    }


}
