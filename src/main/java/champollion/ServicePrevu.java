package champollion;

public class ServicePrevu {
	// TODO : implémenter cette classe
    private int volumeCM,volumeTD,volumtTP;
    
    public ServicePrevu(int CM,int TD,int TP){
        this.volumeCM = CM;
        this.volumeTD = TD;
        this.volumtTP = TP;
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

    public int getVolumtTP() {
        return volumtTP;
    }

    public void setVolumtTP(int volumtTP) {
        this.volumtTP = volumtTP;
    }

    @Override
    public String toString() {
        return "ServicePrevu{" + "volumeCM=" + volumeCM + ", volumeTD=" + volumeTD + ", volumtTP=" + volumtTP + '}';
    }
    
}
