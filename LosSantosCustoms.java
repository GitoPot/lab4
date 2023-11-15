public class LosSantosCustoms implements GenericGarage{//uppgift 3
    // Detta är vår bilverkstads fil

    // Det behövs skapa en gemensam fil som olika verkstäder kan "ärva" från genom composition, det går inte att ärva normalt.
    private final HelperGarage parent = new HelperGarage();  // Composition

    @Override
    public void test() {
        parent.test();        // Delegation
    }
}
