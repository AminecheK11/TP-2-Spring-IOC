package metier;

import dao.IDao;
import org.junit.Assert;
import org.junit.Test;

public class MetierImplTest {

    @Test
    public void testCalcul() {

        // Création d'une implémentation fictive de IDao pour le test
        IDao dao = new IDao() {
            @Override
            public double getValue() {
                return 10.0;
            }
        };

        // Création de MetierImpl et injection manuelle du DAO
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao);

        // Exécution du calcul
        double result = metier.calcul();

        // Vérification : 10.0 * 2 = 20.0
        Assert.assertEquals(20.0, result, 0.001);
    }
}