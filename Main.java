import exceptions.BadEndException;
import story.Story;

class Main {
    public static void main(String[] args) throws BadEndException {
        Story story = new Story();
        story.start();
    }
}
