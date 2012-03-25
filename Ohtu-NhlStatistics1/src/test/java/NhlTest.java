*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import ohtuesimerkki.Player;
import ohtuesimerkki.Reader;
import ohtuesimerkki.Statistics;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Noemj
 */
public class NhlTest {

    Statistics stats;
    Reader reader = new Reader() {

        @Override
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    public NhlTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        stats = new Statistics(reader);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void searchTest() {
        assertEquals("Semenko", stats.search("Semenko").getName());
        assertEquals("Yzerman", stats.search("Yzerman").getName());
    }

    @Test
    public void emptySearchTest() {
        assertEquals(null, stats.search("Esa Tikkane"));
    }

    @Test
    public void playerInTeamTest() {
        assertEquals("Semenko", stats.team("EDM").get(0).getName());
        assertEquals("Kurri", stats.team("EDM").get(1).getName());
    }

    @Test
    public void topScoreTest() {
        assertEquals("Gretzky", stats.topScorers(1).get(0).getName());
    }
    
    @Test
    public void loytaakoSearch(){
        Player lemi = stats.search("Lemieux");
        System.out.println(lemi.getName());
        assertEquals("Lemieux", lemi.getName());
    }
}