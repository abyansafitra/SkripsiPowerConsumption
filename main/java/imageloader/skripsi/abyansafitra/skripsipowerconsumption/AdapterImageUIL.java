package imageloader.skripsi.abyansafitra.skripsipowerconsumption;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.ArrayList;


public class AdapterImageUIL extends RecyclerView.Adapter<AdapterImageUIL.ViewHolder> {

    //    private List<Model> modelList;
    private ArrayList<ModelFoto> listData;
    private Context context;
    ImageLoader imageLoader = ImageLoader.getInstance();

    public AdapterImageUIL(Context context, ArrayList<ModelFoto> listData) {
          this.context = context;
        this.listData = listData;

    }

    @Override
    public AdapterImageUIL.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_template_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.userID.setText(listData.get(i).getUser());
        viewHolder.like.setText(listData.get(i).getLike());
        viewHolder.status.setText(listData.get(i).getStatus());
        viewHolder.lokasi.setText(listData.get(i).getLokasi());

        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisk(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache()).build();
        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP

        ImageLoader imageLoader = ImageLoader.getInstance();

        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(R.drawable.pleasewait)
                .showImageOnFail(R.drawable.pleasewait)
                .showImageOnLoading(R.drawable.pleasewait).build();

//download and display image from url
//        imageLoader.displayImage(x, y, options);



        imageLoader.displayImage(listData.get(i).getFoto_profil(), viewHolder.foto_profil);
        imageLoader.displayImage(listData.get(i).getFoto(), viewHolder.foto);

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView userID;
        ImageView foto_profil;
        ImageView foto;
        TextView status;
        TextView like;
        TextView lokasi;


        public ViewHolder(View view) {
            super(view);

            userID = (TextView)view.findViewById(R.id.user_id);
            foto_profil = (ImageView)view.findViewById(R.id.foto_profile);
            foto = (ImageView)view.findViewById(R.id.foto);
            status = (TextView)view.findViewById(R.id.status_user);
            like = (TextView)view.findViewById(R.id.user_like);
            lokasi = (TextView)view.findViewById(R.id.lokasi_user);
        }
    }
}
