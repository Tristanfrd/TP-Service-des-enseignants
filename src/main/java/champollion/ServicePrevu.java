package champollion;

public class ServicePrevu {

    private int volumeCM,volumeTD,volumeTP;
    
    public ServicePrevu(int CM,int TD,int TP){
        this.volumeCM = CM;
        this.volumeTD = TD;
        this.volumeTP = TP;
    }

    public int getVolumeCM() {
        return volumeCM;
    }

    public void setVolumeCM(int volumeCM) {
        this.volumeCM = volumeCM;
    }

    public int getVolumeTD() {
        return volumeTD;
    }

    public void setVolumeTD(int volumeTD) {
        this.volumeTD = volumeTD;
    }

    public int getVolumeTP() {
        return volumeTP;
    }

    public void setVolumtTP(int volumeTP) {
        this.volumeTP = volumeTP;
    }

    @Override
    public String toString() {
        return "ServicePrevu{" + "volumeCM=" + volumeCM + ", volumeTD=" + volumeTD + ", volumeTP=" + volumeTP + '}';
    }
    
}
