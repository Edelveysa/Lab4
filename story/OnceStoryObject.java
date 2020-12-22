package story;

public abstract class OnceStoryObject {
    private String remembrance;

    public String getRemembrance(){
        return remembrance;
    }

    public void setRemembrance(String remembrance) {
        this.remembrance = remembrance;
    }

    public abstract void doRemembrance();
}
