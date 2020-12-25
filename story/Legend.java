package story;

public class Legend{
    private String remembrance;

    public Legend(){
        Dragon dragon = new Dragon();
    }

    public Legend(String remembrance){
        this.remembrance = remembrance;
    }

    public class Dragon {
        private String name;
        private int numberOfHeads;

        private Dragon(){
            this.name = "Дракон";
            this.numberOfHeads = 100;
        }

        public String getName() {
            return name;
        }

    }

}
