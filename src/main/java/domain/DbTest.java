package domain;

public class DbTest {
  Connection con;

@Before
    public void getConnectionTest() {
        new ConnectionConfiguration();
        Connection con = ConnectionConfiguration.getConnection();
        assertEquals(connection != null, true);
    }
}
