import org.example.Calculatrice ;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatriceTest {

    @Mock
    private Calculatrice calculatrice;

    @Test
    public void testAdditionner() {
        // Définition du comportement de la méthode "additionner"
        when(calculatrice.additionner(2, 3)).thenReturn(5);

        // TODO : Appel de la méthode à tester
        int resultat = calculatrice.additionner(2, 3);

        // TODO : Vérification du résultat
        assertEquals(5, resultat);

        // TODO : Vérification que la méthode "additionner" a été appelée
        verify(calculatrice).additionner(2, 3);

        // TODO : Vérification qu'aucune autre méthode n'a été appelée
        verifyNoMoreInteractions(calculatrice);

        // TODO : Vérification de l'état de l'objet après l'appel de la méthode "additionner"
        // Impossible ici car on mock l'objet => l'état interne n'existe pas réellement.
        // On peut seulement vérifier les interactions.
        // Donc ceci ne s’applique pas : verify(calculatrice).getState();
    }
}
