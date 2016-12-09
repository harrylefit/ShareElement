package vn.eazy.share.element.util;

import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.request.target.BitmapImageViewTarget;

/**
 * Created by Harry on 12/9/16.
 */

public class RoundImageBitmap extends BitmapImageViewTarget {
    public RoundImageBitmap(ImageView view) {
        super(view);
    }

    @Override
    protected void setResource(Bitmap resource) {
        RoundedBitmapDrawable circularDrawable = RoundedBitmapDrawableFactory.create(view.getContext().getResources(),resource);
        circularDrawable.setCircular(true);
        view.setImageDrawable(circularDrawable);
    }
}
