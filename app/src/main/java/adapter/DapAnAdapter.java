package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.onblx.DapAn;
import com.example.onblx.R;

import java.util.List;

public class DapAnAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<DapAn> dapAnList;

    public DapAnAdapter(Context context, int layout, List<DapAn> dapAnList) {
        this.context = context;
        this.layout = layout;
        this.dapAnList = dapAnList;
    }

    @Override
    public int getCount() {
        return dapAnList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        //Anh xa
        TextView item_dapan = view.findViewById(R.id.tvItemDapAn);
        TextView checkDapan = view.findViewById(R.id.checkDapan);
        //Gans gia tri
        DapAn dapAn = dapAnList.get(i);
        item_dapan.setText(dapAn.getNoiDung().toString());
        checkDapan.setText(dapAn.getDapAnDung()+"");

        return view;
    }
}
