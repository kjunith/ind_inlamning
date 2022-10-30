package menu;

public enum MenuState {
    MAIN("Main Menu"), READ("Läs Dagbok"), WRITE("Skriv Dagbok"), EXIT("Avsluta"), PROFILE("Select Profile:");

    private final String fancy;

    MenuState(String fancy) {
        this.fancy = fancy;
    }

    public String getFancy() {
        return fancy;
    }
}
