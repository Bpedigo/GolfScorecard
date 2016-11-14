package btpedigo.golfscorecard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by bpedi on 11/13/2016.
 */

public class ListAdapter extends BaseAdapter {

    private final Context mContext;
    private final Hole[] mHoles;

    public ListAdapter (Context context, Hole[] holes){
        mContext = context;
        mHoles = holes;
    }

    @Override
    public int getCount() {
        return mHoles.length;
    }

    @Override
    public Object getItem(int i) {
        return mHoles[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;

        if(view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.holeLabel = (TextView) view.findViewById(R.id.holeLabel);
            holder.strokeCount = (TextView) view.findViewById(R.id.strokeCount);
            holder.removeStrokeButton = (Button) view.findViewById(R.id.removeStrokeButton);
            holder.addStrokeButton = (Button) view.findViewById(R.id.addStrokeButton);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.holeLabel.setText(mHoles[i].getLabel());
        holder.strokeCount.setText(mHoles[i].getStrokeCount() + "");

        holder.removeStrokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int updateStrokeCounter = mHoles[i].getStrokeCount() - 1;
                if(updateStrokeCounter < 0){
                    updateStrokeCounter = 0;
                }
                mHoles[i].setStrokeCount(updateStrokeCounter);
                holder.strokeCount.setText(updateStrokeCounter + "");
            }
        });

        holder.addStrokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int updateStrokeCounter = mHoles[i].getStrokeCount() + 1;
                mHoles[i].setStrokeCount(updateStrokeCounter);
                holder.strokeCount.setText(updateStrokeCounter + "");
            }
        });

        return view;
    }


    private static class ViewHolder {
        TextView holeLabel;
        TextView strokeCount;
        Button removeStrokeButton;
        Button addStrokeButton;
    }


}
