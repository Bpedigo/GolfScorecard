package btpedigo.golfscorecard;

/**
 * Created by bpedi on 11/12/2016.
 */

public class Hole {

    private String mLabel;
    private int mStrokeCount;

    public Hole (String lable, int strokeCount){
        mLabel = lable;
        mStrokeCount = strokeCount;
    }

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String label) {
        mLabel = label;
    }

    public int getStrokeCount() {
        return mStrokeCount;
    }

    public void setStrokeCount(int strokeCount) {
        mStrokeCount = strokeCount;
    }






}
