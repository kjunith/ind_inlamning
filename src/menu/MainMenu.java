package menu;

public class MainMenu {
    private final String[] profileOptions = new String[]{"Välj Användare", "Skapa Användare", "Avsluta Programmet"};
    private final String[] postOptions = new String[]{"Läs Dagbok", "Skriv Dagbok", "Byt Användare", "Avsluta Programmet"};
    private MenuState state;

    public MainMenu() {
        this.state = MenuState.POST;
    }

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

    public MenuState getState() {
        return state;
    }

    public void setState(MenuState state) {
        this.state = state;
    }

    public String[] getProfileOptions() {
        return profileOptions;
    }

    public String[] getPostOptions() {
        return postOptions;
    }
}
