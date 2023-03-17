public class Test {
    public static void main(String[] args) {
        DrummerList list = new DrummerList(3);


        list.add(new Drummer.DrummerBuilder(1,"이충희")
        .numberOfBase(3)
        .countOfSymbol(4)
        .teamName("레전드팀")
        .build());

        list.add(new Drummer.DrummerBuilder(2,"홍길동")
                .numberOfBase(2)
                .countOfSymbol(3)
                .teamName("새싹팀")
                .build());

        list.add(new Drummer.DrummerBuilder(3,"김철수")
                .numberOfBase(4)
                .countOfSymbol(5)
                .teamName("베테랑팀")
                .build());

                // Enumerator e = list.enumerator();
                // while (e.hasMoreElements()) {
                //     System.out.println(e.current());
                // }
        
    }

}
