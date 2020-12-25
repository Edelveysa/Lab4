package story;

public class Legend{
    private String remembrance;

    public Legend(){
        Dragon dragon = new Dragon();
        setRemembrance(dragon.getName() + ' ' + dragon.getAmountOfHeads() + " решил съесть малышей");
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

        public int getNumberOfHeads() {
            return numberOfHeads;
        }

        public String getAmountOfHeads(){
            return getNumberOfHeads() == 100 ? "Стоголовый" : "Многоголовый";
        }


    }

    public void setRemembrance(String remembrance) {
        this.remembrance = remembrance;
    }

    public String getRemembrance() {
        return remembrance;
    }
}
