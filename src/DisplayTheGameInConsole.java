public class DisplayTheGameInConsole implements DisplayTheGame{

    @Override
    public void showWelcome() {
        System.out.println("Добро пожаловать в игру!");
    }

    @Override
    public void showGallows() {

    }

    @Override
    public void refreshDisplay() {
        for (int i = 0; i < 20; ++i) System.out.println();
    }

    @Override
    public void showWordMask() {

    }

    @Override
    public void showIncorrectChar() {

    }

    @Override
    public void showSuggestToContinue() {

    }
}
