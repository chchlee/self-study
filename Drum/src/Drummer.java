public class Drummer {
    private final int drummerNo;
    private final String name;


    public static class DrummerBuilder {
        private final int drummerNo;
        private final String name;
        private int numberOfBass;
        private int countOfSymbol;
        private String teamName;

        public DrummerBuilder(int drummerNo, String name) {
            this.drummerNo = drummerNo;
            this.name = name;
        }

        public DrummerBuilder numberOfBase(int numberOfBass){
            this.numberOfBass = numberOfBass;
            return this;
        }

        public DrummerBuilder countOfSymbol(int countOfSymbol){
            this.countOfSymbol = countOfSymbol;
            return this;
        }

        public DrummerBuilder teamName(String teamName){
            this.teamName = teamName;
            return this;
        }

        public Drummer build(){
            return new Drummer(this);
        }
    }

    private Drummer(DrummerBuilder drummerBuilder){
        this.drummerNo = drummerBuilder.drummerNo;
        this.name = drummerBuilder.name;
    }

}
