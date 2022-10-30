package menu;

public class Menu {
    private static final String HEADER = "   MainMenu";
    private static final String[] menuOptions = new String[]{"Läs Dagbok", "Skriv Dagbok", "Avsluta"};
    private MenuState state;

    public Menu() {
        this.state = MenuState.MAIN;
    }

    public void show() {
        System.out.println(HEADER);
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println((i + 1) + ". " + menuOptions[i]);
        }
    }

    public MenuState getState() {
        return state;
    }

    public void setState(MenuState state) {
        this.state = state;
    }
}
