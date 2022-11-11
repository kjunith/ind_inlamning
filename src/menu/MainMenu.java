package menu;

public class MainMenu {
    private final String[] profileOptions = new String[]{"Välj Användare", "Skapa Användare", "Avsluta Programmet"};
    private final String[] postOptions = new String[]{"Läs Dagbok", "Skriv Dagbok", "Byt Användare", "Avsluta " +
            "Programmet"};
    private MenuState state;

    /**
     * Constructor sets the MenuState to POST per default.
     */
    public MainMenu() {
        this.state = MenuState.POST;
    }

    /**
     * Handles and displays the different states of
     * the menu.
     */
    public void show() {
        switch (state) {
            case PROFILE -> {
                for (int i = 0; i < profileOptions.length; i++) {
                    System.out.println((i + 1) + ". " + profileOptions[i]);
                }
            }
            case POST -> {
                for (int i = 0; i < postOptions.length; i++) {
                    System.out.println((i + 1) + ". " + postOptions[i]);
                }
            }
        }
    }

    /**
     * Returns the value of the current menu state.
     *
     * @return the current menu state
     */
    public MenuState getState() {
        return state;
    }

    /**
     * Set the value for the menu state
     *
     * @param state an Enum used for menu navigation
     */
    public void setState(MenuState state) {
        this.state = state;
    }

    /**
     * Returns an Array with Strings that represents
     * the different options for navigating through
     * the profile menu.
     *
     * @return an Array of Strings for the profile menu
     */
    public String[] getProfileOptions() {
        return profileOptions;
    }

    /**
     * Returns an Arrays of Strings that represents
     * the different options for navigating through
     * the main menu.
     *
     * @return an Array of String for the main menu
     */
    public String[] getPostOptions() {
        return postOptions;
    }
}
