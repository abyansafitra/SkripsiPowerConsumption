package imageloader.skripsi.abyansafitra.skripsipowerconsumption;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class AdapterImagePicasso extends RecyclerView.Adapter<AdapterImagePicasso.ViewHolder> {


    private ArrayList<ModelFoto> listData;
    private Context context;

    public AdapterImagePicasso(Context context, ArrayList<ModelFoto> listData) {
        this.context = context;
        this.listData = listData;

    }

    @Override
    public AdapterImagePicasso.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_template_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.userID.setText(listData.get(i).getUser());
        viewHolder.like.setText(listData.get(i).getLike());
        viewHolder.status.setText(listData.get(i).getStatus());
        viewHolder.lokasi.setText(listData.get(i).getLokasi());
        //pemanggilan UIL
        Picasso.with(context).load(listData.get(i).getFoto_profil()).into(viewHolder.foto_profil);
        Picasso.with(context).load(listData.get(i).getFoto()).into(viewHolder.foto);

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
