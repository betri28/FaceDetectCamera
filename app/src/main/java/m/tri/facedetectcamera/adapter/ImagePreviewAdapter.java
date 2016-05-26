package m.tri.facedetectcamera.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import m.tri.facedetectcamera.R;

/**
 * Created by Nguyen on 5/20/2016.
 */


public class ImagePreviewAdapter extends
        RecyclerView.Adapter<RecyclerView.ViewHolder> {


    // Store the context for later use
    private Context context;

    private ArrayList<Bitmap> bitmaps;
    private int check = 0;

    private ViewHolder.OnItemClickListener onItemClickListener;

    // Pass in the context and menuModels array into the constructor
    public ImagePreviewAdapter(Context context, ArrayList<Bitmap> bitmaps, ViewHolder.OnItemClickListener onItemClickListener) {

        this.context = context;
        this.bitmaps = bitmaps;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).
                inflate(R.layout.item_image_preview, viewGroup, false);
        // Return a new holder instance
        return new ViewHolder(itemView, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int i) {
        final ViewHolder holder = (ViewHolder) viewHolder;
        if (i == check) {
            holder.layoutCheck.setVisibility(View.VISIBLE);
        } else {
            holder.layoutCheck.setVisibility(View.GONE);
        }

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, metrics);

        Bitmap bmp = Bitmap.createScaledBitmap(bitmaps.get(i), size, size, false);
        holder.imgPreview.setImageBitmap(bmp);
    }

    @Override
    public int getItemCount() {
        return bitmaps.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public void add(Bitmap bitmap) {
        insert(bitmap, bitmaps.size());
    }

    public void insert(Bitmap bitmap, int position) {
        bitmaps.add(position, bitmap);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        bitmaps.remove(position);
        notifyDataSetChanged();
    }

    public void clearAll() {
        for (int i = 0; i < bitmaps.size(); i++) {
            if (bitmaps.get(i) != null)
                bitmaps.get(i).recycle();
        }
        bitmaps.clear();
        check = 0;
        notifyDataSetChanged();
    }

    public void addAll(ArrayList<Bitmap> bitmaps) {
        int startIndex = bitmaps.size();
        this.bitmaps.addAll(startIndex, bitmaps);
        notifyItemRangeInserted(startIndex, bitmaps.size());
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }


    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final OnItemClickListener onItemClickListenerListener;
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public RelativeLayout layoutCheck;
        public ImageView imgPreview;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView, OnItemClickListener onItemClickListenerListener) {
            super(itemView);
            this.layoutCheck = (RelativeLayout) itemView.findViewById(R.id.layoutCheck);
            this.imgPreview = (ImageView) itemView.findViewById(R.id.imagePreview);
            this.onItemClickListenerListener = onItemClickListenerListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            v.setSelected(true);
            onItemClickListenerListener.onClick(v, getAdapterPosition());
        }

        public interface OnItemClickListener {
            void onClick(View v, int position);
        }
    }
}