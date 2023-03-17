public class DrummerList implements Enumerable {
    public Drummer[] list;
    public int index = 0;
    public int size =0;

    public DrummerList(int size) {
        this.list = new Drummer[size];
    }

    public int getSize(){
        return size;
    }

    public void add(Drummer drummer) {
        if(this.index >= this.list.length) {
            System.out.println("List Full!!!!!!!!");
        } else {
            this.list[index] = drummer;
            this.index++;
        }
    }

    public Enumerator enumerator() {
        return new DrummerEnumerator(this);
    }
}
