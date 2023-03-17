public class DrummerEnumerator implements Enumerator{
    public DrummerList list;
    int index = 0;

    public DrummerEnumerator(DrummerList list){
        this.list = list;
    }

    public boolean hasMoreElements(){
        if(this.index >= list.getSize()){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object current() {
        return this.list.list[this.index++];
    }


}
